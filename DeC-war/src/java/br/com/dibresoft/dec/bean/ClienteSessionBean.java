package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ClienteEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

    // SOMENTE PARA PRÉ-APRESENTAÇÃO
    /*cliente = clienteEJB.buscarClientePorId(4L);*/
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
  public String autenticar() {
    cliente = clienteEJB.autenticar(cliente.getEmail(), cliente.getSenha());
    if(cliente != null){
      return "home?faces-redirect=true";
    }

    return "404?faces-redirect=true";
  }
  
  



}
