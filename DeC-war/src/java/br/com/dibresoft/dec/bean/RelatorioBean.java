package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.CompraEJBLocal;
import br.com.dibresoft.dec.entidade.Compra;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jSilverize
 */
@ManagedBean
@RequestScoped
public class RelatorioBean {

  private List<Compra> listaCompras;

  @EJB
  private CompraEJBLocal comprasEJB;

  public RelatorioBean() {
  }

  @PostConstruct
  public void init() {
    listaCompras = new ArrayList<>();
    listaCompras = comprasEJB.listarTodas();
  }

  public double valorTotalRelatorio() {

    double valor = 0;

    for (Compra compra : listaCompras) {
      valor = valor + compra.getValorTotal();
    }

    return valor;

  }

  public List<Compra> getListaCompras() {
    return listaCompras;
  }

  public void setListaCompras(List<Compra> listaCompras) {
    this.listaCompras = listaCompras;
  }

}
