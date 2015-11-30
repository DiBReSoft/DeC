package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Categoria;
import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface ReservaEJBLocal {
  
  public Reserva verificarDisponibilidade(Categoria categoriaSelecionada, Hotel hotelSelecionado, Reserva reserva);

  public double calcularValorReserva(Reserva reserva);

  public void cadastrar(Reserva reserva);

  public void buscar(Reserva reserva);

  public void alterar(Reserva reserva);

  public void inativar(Reserva reserva);
  
  public boolean verificarDisponibilidadeQuartos(Reserva reserva,Long categoriaId, Long hotelId);

}
