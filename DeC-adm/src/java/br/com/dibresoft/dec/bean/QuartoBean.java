package br.com.dibresoft.dec.bean;


import br.com.dibresoft.dec.ejb.QuartoEJBLocal;
import br.com.dibresoft.dec.entidade.Quarto;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class QuartoBean {

  private Quarto quarto;
  private List<Quarto> todosQuartos;
  @EJB
  private QuartoEJBLocal quartoEJB;
  
  public QuartoBean() {
    quarto = new Quarto();
  }
  
  @PostConstruct
  public void init() {
    todosQuartos = quartoEJB.listarTodos();
  }

  public void cadastrar() throws IOException {
    quartoEJB.cadastrar(quarto);
    FacesContext.getCurrentInstance().getExternalContext().redirect("sucesso-no-cadastro");
  }

  public Quarto getQuarto() {
    return quarto;
  }

  public void setQuarto(Quarto quarto) {
    this.quarto = quarto;
  }

}
