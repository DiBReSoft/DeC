package br.com.dibresoft.dec.servlet;

import br.com.dibresoft.dec.bean.ClienteSessionBean;
import br.com.dibresoft.dec.entidade.Cliente;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * http://www.journaldev.com/1933/java-servlet-filter-example-tutorial
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter", urlPatterns = {"/backoffice/*"})
public class AutorizacaoFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {

    // 1) OBTEM AS INFORMACOES DO USUARIO DA SESSAO
    // A) CAST DOS PARÂMETROS RECEBIDOS
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    // B) TENTA RECUPERAR A SESSÃO DO USUÁRIO
    HttpSession sessao = httpRequest.getSession();
    ClienteSessionBean clienteSession = (ClienteSessionBean) sessao.getAttribute("clienteSessionBean");

    if (clienteSession != null) {

      Cliente cliente = clienteSession.getCliente();

      // 2) NA LÓGICA IMPLEMENTADA, SE EXISTIR OBJETO DO USUÁRIO SIGNIFICA
      //    QUE USUÁRIO ESTÁ LOGADO
      //    CASO CONTRÁRIO, REDIRECIONA PARA TELA DE LOGIN
      if (cliente == null) {
        httpResponse.sendRedirect("/DeC-war/dec");
        return;
      }

      try {
        // 3) VERIFICAR SE USUARIO PODE ACESSAR PAGINA
        if (verificarAcesso(cliente, httpRequest, httpResponse)) {
          // CHAMADA QUE ENVIA A REQUISIÇÃO PARA O PRÓXIMO FILTRO OU SERVLET
          chain.doFilter(request, response);
        } else {
          // SE NAO PODER ACESSAR, APRESENTA ERRO
          httpResponse.sendRedirect("/DeC-war/dec");
        }
      } catch (Throwable t) {
        t.printStackTrace();
      }

    } else {

      httpResponse.sendRedirect("/DeC-war/dec");

    }

  }

  private boolean verificarAcesso(Cliente cliente, HttpServletRequest req, HttpServletResponse resp) {

    String pagina = req.getRequestURI();
    
    System.out.println(pagina);

    if (cliente.getPrivilegio() == 'a' || pagina.equalsIgnoreCase("/DeC-war/dec")) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * ROTINA PARA DESTRUIÇÃO DO FILTRO
   */
  @Override
  public void destroy() {
  }

  /**
   * ROTINA DE INICIALIZAÇÃO DO FILTRO
   */
  @Override
  public void init(FilterConfig filterConfig) {
  }
}
