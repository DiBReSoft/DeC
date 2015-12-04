package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ReservaEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Reserva;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jSilverize
 */
@ManagedBean
@SessionScoped
public class ReservaBean {

  private Reserva reserva;

  private Date periodoI;
  private Date periodoII;

  @EJB
  private ReservaEJBLocal reservaEJB;

  public ReservaBean() {
    reserva = new Reserva();
  }

  @PostConstruct
  public void init() {
  }

  public List<Reserva> listarReservasCliente(Cliente cliente) {

    if (cliente.getId() != null) {

      return reservaEJB.listarReservasCliente(cliente);

    } else {

      return null;

    }

  }

  public List<Reserva> listarReservasPeriodo() {

    return reservaEJB.listarReservasPeriodo(periodoI, periodoII);

  }

  public List<Reserva> listarReservasPeriodo(int ultimosXdias) {

    Calendar c = Calendar.getInstance();

    if (ultimosXdias >= 1) {

      periodoI = new Date();

      c.setTime(periodoI);

      c.add(Calendar.DATE, -ultimosXdias);

      periodoII.setTime(c.getTime().getTime());

      return reservaEJB.listarReservasPeriodo(periodoI, periodoII);

    } else {

      return null;

    }

  }

  public List<Reserva> listarReservasTodas() {

    return reservaEJB.listarReservasTodas();

  }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

  public Date getPeriodoI() {
    return periodoI;
  }

  public void setPeriodoI(Date periodoI) {
    this.periodoI = periodoI;
  }

  public Date getPeriodoII() {
    return periodoII;
  }

  public void setPeriodoII(Date periodoII) {
    this.periodoII = periodoII;
  }

}
