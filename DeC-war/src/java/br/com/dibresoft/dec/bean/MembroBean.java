package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.MembroEJB;
import br.com.dibresoft.dec.entidade.Membro;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author udimberto.sjunior
 */
@ManagedBean
@RequestScoped
public class MembroBean {

  private Membro membro;
  @EJB
  private MembroEJB membroEJB;

  public MembroBean() {
    membro = new Membro();
  }

  public void cadastrar() {
    membroEJB.cadastrar(membro);
  }

  public Membro getMembro() {
    return membro;
  }

  public void setMembro(Membro membro) {
    this.membro = membro;
  }

  public MembroEJB getMembroEJB() {
    return membroEJB;
  }

  public void setMembroEJB(MembroEJB membroEJB) {
    this.membroEJB = membroEJB;
  }

}
