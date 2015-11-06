package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

    @PersistenceContext
    private EntityManager em;

    /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */
    @Override
    public boolean cadastrar(Cliente membro) {
        em.persist(membro);
        return true;
    }
    /* AJUSTAR PARA VERIFICAR O RESULTADO DA OPERAÇÃO */

    @Override
    public boolean inativar(Cliente membro) {
        membro.setStatus(false);
        em.refresh(membro);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Cliente membro) {
        em.refresh(membro);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarCpf(Cliente membro) {
        em.find(Cliente.class, membro);
        return em.contains(membro);
    }

}
