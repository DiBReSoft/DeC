package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Endereco;
import br.com.dibresoft.dec.entidade.Hotel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class HotelEJB implements HotelEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void cadastrar(Hotel hotel) {

    em.persist(hotel);

  }

  @Override
  public void buscar(Hotel hotel) {

  }

  @Override
  public void alterar(Hotel hotel) {

    em.merge(hotel);

  }

  @Override
  public void inativar(Hotel hotel) {

    hotel.setStatus(false);
    em.merge(hotel);

  }

  @Override
  public List<Hotel> listarTodos() {

    Query query = em.createQuery("Select c from Hotel c ORDER BY c.tituloHotel");

    List<Hotel> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public List<Hotel> listarAtivos() {

    Query query = em.createQuery("Select c from Hotel c WHERE c.status = 1 ORDER BY c.tituloHotel");

    List<Hotel> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public List<Hotel> listarInativos() {

    Query query = em.createQuery("Select c from Hotel c WHERE c.status = 0 ORDER BY c.tituloHotel");

    List<Hotel> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public Hotel buscarHotel(String tituloHotel) {

    return em.find(Hotel.class, tituloHotel);

  }

  @Override
  public Hotel buscarHotelPorID(Long id) {

    return em.find(Hotel.class, id);

  }

}
