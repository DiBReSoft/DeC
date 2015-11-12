package br.com.dibresoft.dec.ejb;

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
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void buscar(Hotel hotel) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void alterar(Hotel hotel) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void inativar(Hotel hotel) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<Hotel> listarTodos() {
    Query query = em.createQuery("Select c from Hotel c");
    List<Hotel> hoteis = query.getResultList();
    System.out.println("Número de hoteis encontrados: " + hoteis.size());
    return hoteis;
  }

}
