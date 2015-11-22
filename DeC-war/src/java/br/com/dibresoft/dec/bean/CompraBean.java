package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.CompraEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Compra;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jSilverize
 */
@ManagedBean
@RequestScoped
public class CompraBean {
  
  private Compra compra;
  
  @EJB
  private CompraEJBLocal compraEJB;
  
  public CompraBean() {
    compra = new Compra();
  }
  
  public void gravar(Cliente cliente, double valorTotal) throws IOException {
    
    compra.setStatus("aprovada");
    compra.setCliente(cliente);
    compra.setDataCompra(new Date());    
    compra.setValorParcelas(valorTotal / compra.getCartaoParcelas());
    compra.setValorTotal(valorTotal);
    
    compraEJB.cadastrar(compra);
    
    FacesContext.getCurrentInstance().getExternalContext().redirect("/DeC-war/reservas/sucesso");
    
  }
  
  public Compra getCompra() {
    return compra;
  }
  
  public void setCompra(Compra compra) {
    this.compra = compra;
  }
  
}
