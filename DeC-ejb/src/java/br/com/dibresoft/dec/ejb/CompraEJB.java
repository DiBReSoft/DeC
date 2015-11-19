package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Compra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jSilverize
 */
@Stateless
public class CompraEJB implements CompraEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void cadastrar(Compra compra) {
    em.persist(compra);
  }

  @Override
  public void buscar(Compra compra) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void alterar(Compra compra) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void inativar(Compra compra) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Compra> listarTodas() {
    Query query = em.createQuery("Select c from Compra c");
    return query.getResultList();
  }

}
