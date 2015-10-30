package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.MembroEJBLocal;
import br.com.dibresoft.dec.entidade.Membro;
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
public class MembroBean {

  private Membro membro;
  @EJB
  private MembroEJBLocal membroEJB;
  String msgDadoExistente = "Já existe cadastro com estes dados.";

  public MembroBean() {
    membro = new Membro();
  }

  public void cadastrar() throws IOException {
    membroEJB.cadastrar(membro);
    FacesContext.getCurrentInstance().getExternalContext().redirect("sucesso-no-cadastro");
  }

  public void verificarCpf() {

  }

  public Membro getMembro() {
    return membro;
  }

  public void setMembro(Membro membro) {
    this.membro = membro;
  }

  public String getMsgDadoExistente() {
    return msgDadoExistente;
  }

  public void setMsgDadoExistente(String msgDadoExistente) {
    this.msgDadoExistente = msgDadoExistente;
  }

}
