package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class ReservaEJB implements ReservaEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public double calcularValorReserva(Reserva reserva) {
    double valor;
    long t1 = reserva.getCheckIn().getTime();
    long t2 = reserva.getCheckOut().getTime();
    long t3 = t2 - t1;
    t3 = (t3 / 86400000) + 1;

    if (t3 < 0) {
      return 0;
    } else {
      return valor = t3 * reserva.getQuarto().getValor();
    }
  }

  @Override
  public void cadastrar(Reserva reserva) {
    em.persist(reserva);
  }

  @Override
  public void buscar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void alterar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void inativar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
