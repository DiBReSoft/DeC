package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
import javax.ejb.Singleton;

/**
 *
 * @author udimberto.sjunior
 */
@Singleton
public class ReservaEJB implements ReservaEJBLocal {

  @Override
  public double valorReserva(Date checkIn, Date checkOut, double valorQuarto) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void cadastrar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
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
