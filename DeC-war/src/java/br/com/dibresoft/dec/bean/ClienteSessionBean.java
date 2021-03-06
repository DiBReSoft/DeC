package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ClienteEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
    cliente = new Cliente();
  }

  @PostConstruct
  public void init() {
  }

  public void autenticar() throws IOException {

    cliente = clienteEJB.autenticar(cliente.getEmail(), cliente.getSenha());

    if (cliente.getId() != null) {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/mala");

    } else {
      FacesMessage fm = new FacesMessage("Login ou senha inválidos!");
      FacesContext.getCurrentInstance().addMessage("msg", fm);
      //FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/login?erro=credenciais-nao-encontradas");

    }

  }

  public void encerrarSessao() throws IOException {

    cliente = new Cliente();

    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/");

  }

  public void autenticarAdm() throws IOException {

    System.out.println("Autenticar ADM");

    cliente = clienteEJB.autenticar(cliente.getEmail(), cliente.getSenha());

    if (cliente.getId() != null && cliente.getPrivilegio() == 'a') {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/dashboard");

    } else {

      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/dec?erro=nao-autorizado");

    }

  }

  public void encerrarSessaoAdm() throws IOException {

    cliente = new Cliente();

    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/backoffice/login");

  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
