package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Hotel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface HotelEJBLocal {

  public void cadastrar(Hotel hotel);

  public void buscar(Hotel hotel);

  public void alterar(Hotel hotel);

  public void inativar(Hotel hotel);

  public List<Hotel> listarTodos();

  public List<Hotel> listarAtivos();

  public List<Hotel> listarInativos();

  public Hotel buscarHotel(String nome);

  public Hotel buscarHotelPorID(Long id);

}
