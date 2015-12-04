package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Categoria;
import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
import java.util.List;
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

  public List<Reserva> listarReservasCliente(Cliente cliente);

}
