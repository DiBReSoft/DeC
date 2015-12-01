package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ClienteEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jSilverize
 */
@ManagedBean
@SessionScoped
public class ClienteSessionBean {

  private Cliente cliente;

  @EJB
  private ClienteEJBLocal clienteEJB;

  public ClienteSessionBean() {

  }

  @PostConstruct
  public void init() {
    cliente = new Cliente();
  }

  public void autenticar() throws IOException {

    cliente = clienteEJB.autenticar(cliente.getEmail(), cliente.getSenha());

    if (cliente.getId() != null) {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/mala");

    } else {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/login?erro=credenciais-nao-encontradas");

    }

  }

  public void encerrarSessao() throws IOException {

    cliente = new Cliente();

    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/");

  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
