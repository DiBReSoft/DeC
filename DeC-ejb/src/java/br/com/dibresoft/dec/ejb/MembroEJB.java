package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Membro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class MembroEJB {

  @PersistenceContext
  private EntityManager em;

  public void cadastrar(Membro membro) {
    em.persist(membro);
  }

}
