package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.QuartoCategoria;
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
public class QuartoCategoriaEJB implements QuartoCategoriaEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public boolean cadastrar(QuartoCategoria categoria) {
    em.persist(categoria);
    return true;
  }

  @Override
  public List<QuartoCategoria> listarTodas() {
    Query query = em.createQuery("Select c from QuartoCategoria c");
    return query.getResultList();
  }
}
