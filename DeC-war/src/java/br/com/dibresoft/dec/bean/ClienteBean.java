package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ClienteEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Email;
import br.com.dibresoft.dec.entidade.Hotel;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author udimberto.sjunior
 */
@ManagedBean
@RequestScoped
public class ClienteBean {

  private Cliente cliente;

  @EJB
  private ClienteEJBLocal clienteEJB;

  public ClienteBean() {

    cliente = new Cliente();
    cliente.setStatus(true);
    cliente.setPrivilegio('c');

  }

  public void cadastrar() throws IOException {

    clienteEJB.cadastrar(cliente);

    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/clientes/sucesso-no-cadastro");

  }

  public void verificar() throws IOException {

    if (clienteEJB.validar(cliente.getCpf(), cliente.getEmail())) {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/clientes/me-cadastrar?cpf=" + cliente.getCpf() + "&email=" + cliente.getEmail());

    } else {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/clientes/recuperar-senha");

      FacesMessage fm = new FacesMessage("Já existe cadastro com estas informações.");

      FacesContext.getCurrentInstance().addMessage(null, fm);

    }

  }

  public void alterar() throws IOException {

    clienteEJB.alterar(cliente);

    FacesContext.getCurrentInstance().getExternalContext().redirect("sucesso-no-cadastro");

  }

  public void carregarInfos() {

    Map<String, String> params = FacesContext.getCurrentInstance().
            getExternalContext().getRequestParameterMap();

    Long paramClienteID = Long.parseLong(params.get("id"));

    Cliente clienteAlterar = clienteEJB.buscarClientePorId(paramClienteID);

    cliente = clienteAlterar;

  }

  public void carregarInfos(Cliente clienteSession) {

    cliente = clienteSession;

  }

  public void cadastrarBO() throws IOException {

    clienteEJB.cadastrar(cliente);

    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public void alterarBO() throws IOException {

    clienteEJB.alterar(cliente);

    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/sucesso-na-operacao");

  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
