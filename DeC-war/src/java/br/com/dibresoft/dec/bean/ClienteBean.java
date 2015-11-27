package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ClienteEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Email;
import java.io.IOException;
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
  String msgDadoExistente = "Já existe cadastro com estes dados.";

  public ClienteBean() {
    cliente = new Cliente();
  }

  public void cadastrar() throws IOException {
    clienteEJB.cadastrar(cliente);
    
    FacesContext.getCurrentInstance().getExternalContext().redirect("sucesso-no-cadastro");
  }

  public void verificar() throws IOException {
     if(clienteEJB.validar(cliente.getCpf(), cliente.getEmail())){
      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/clientes/me-cadastrar?cpf=" + cliente.getCpf()+ "&email=" + cliente.getEmail());
    }else{
      FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/clientes/recuperar-senha");
     }

     
  }

  
  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getMsgDadoExistente() {
    return msgDadoExistente;
  }

  public void setMsgDadoExistente(String msgDadoExistente) {
    this.msgDadoExistente = msgDadoExistente;
  }
  
 

}
