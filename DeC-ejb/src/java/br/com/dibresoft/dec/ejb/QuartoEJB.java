package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Quarto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class QuartoEJB implements QuartoEJBLocal {
  
  @PersistenceContext
  private EntityManager em;
  
  /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */
  @Override
  public boolean cadastrar(Quarto quarto) {
    em.persist(quarto);
    return true;
  }
  /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */
  
}
