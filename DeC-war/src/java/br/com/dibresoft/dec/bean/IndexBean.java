package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.ejb.HotelEJBLocal;
import br.com.dibresoft.dec.ejb.QuartoEJBLocal;
import br.com.dibresoft.dec.ejb.ReservaEJBLocal;
import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.Reserva;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author udimberto.sjunior
 */
@ManagedBean
@SessionScoped
public class IndexBean {

  private List<Hotel> hoteis;
  @EJB
  private HotelEJBLocal hoteisEJB;

  private List<Quarto> quartos;
  @EJB
  private QuartoEJBLocal quartosEJB;

  public IndexBean() {
  }

  @PostConstruct
  public void init() {
    hoteis = hoteisEJB.listarTodos();
    quartos = quartosEJB.listarTodos();
  }

  public List<Hotel> getHoteis() {
    return hoteis;
  }

  public void setHoteis(List<Hotel> hoteis) {
    this.hoteis = hoteis;
  }

  public List<Quarto> getQuartos() {
    return quartos;
  }

  public void setQuartos(List<Quarto> quartos) {
    this.quartos = quartos;
  }

  public List<SelectItem> getComboHoteis() {

    List<SelectItem> lista = new ArrayList<>();

    for (Hotel hotel : hoteis) {
      lista.add(
              new SelectItem(
                      hotel.getId(),
                      hotel.getEndereco().getEstado() + " - " + hotel.getTitulo()
              )
      );
    }
    return lista;
  }

  public List<SelectItem> getComboQuartos() {

    List<SelectItem> lista = new ArrayList<>();

    for (Quarto quarto : quartos) {
      lista.add(
              new SelectItem(
                      quarto.getId(),
                      quarto.getTitulo() + " ( Diária: R$ " + quarto.getCategoria().getValor() + " )"
              )
      );
    }
    return lista;
  }

}
