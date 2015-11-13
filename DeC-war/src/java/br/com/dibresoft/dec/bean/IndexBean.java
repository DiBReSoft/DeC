package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.ejb.HotelEJBLocal;
import br.com.dibresoft.dec.ejb.ReservaEJBLocal;
import br.com.dibresoft.dec.entidade.Reserva;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

  private Reserva reserva;
  @EJB
  private ReservaEJBLocal reservaEJB;

  public IndexBean() {
    reserva = new Reserva();
    reserva.setCliente(null);
    reserva.setQuarto(null); 
  }

  @PostConstruct
  public void init() {
    hoteis = hoteisEJB.listarTodos();
  }

  public List<Hotel> getHoteis() {
    return hoteis;
  }

  public void setHoteis(List<Hotel> hoteis) {
    this.hoteis = hoteis;
  }

  public void reservar() {
    reservaEJB.cadastrar(reserva);
  }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

}
