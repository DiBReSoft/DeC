package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface ReservaEJBLocal {
  
  public double valorReserva(Date checkIn, Date checkOut, double valorQuarto);
  
  public void cadastrar(Reserva reserva);
  
  public void buscar(Reserva reserva);
  
  public void alterar(Reserva reserva);
  
  public void inativar(Reserva reserva);
  
}
