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
  public double valorReserva(Date checkIn, Date checkOut, double valorQuarto) {
    throw new UnsupportedOperationException("Not supported yet.");
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
