package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.ReservaEJBLocal;
import br.com.dibresoft.dec.entidade.Cliente;
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
 * @author jSilverize
 */
@ManagedBean
@SessionScoped
public class ReservaBean {

  private Reserva reserva;

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

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

}
