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
public class MembroEJB implements MembroEJBLocal {

  @PersistenceContext
  private EntityManager em;
  
  /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */
  @Override
  public boolean cadastrar(Membro membro) {
    em.persist(membro);
    return true;
  }
  /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */

  @Override
  public boolean remover(Membro membro) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean validarCpf(Membro membro) {
    em.find(Membro.class, membro);
    return em.contains(membro);
  }

}
