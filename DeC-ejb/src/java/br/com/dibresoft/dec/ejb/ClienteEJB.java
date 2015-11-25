package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Cliente;
import br.com.dibresoft.dec.entidade.Quarto;
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
    public boolean validar(String cpf, String email) {
        List <Cliente> clientes;
    
    Query q = em.createNamedQuery("Cliente.validar");
    q.setParameter("cpf",cpf);
    q.setParameter("email",email);
    
    clientes = q.getResultList();
        
    if (clientes.isEmpty()){
      
    return true;
    }
    
   return false; 
    }

  @Override
  public boolean buscarClientePorCpf(String cpf) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Cliente autenticar(String email, String senha) {
    Cliente c = null;
    List <Cliente> clientes;
    
    Query q = em.createNamedQuery("Cliente.autenticar");
    q.setParameter("email",email);
    q.setParameter("senha",senha);
    
    clientes = q.getResultList();
        
    if (clientes.size() > 0){
      c = clientes.get(0);
      
    return c;
    }
    
   return c; 
  }

  @Override
  public Cliente buscarClientePorId(long id) {    
    Query query = em.createQuery("Select c from Cliente c where c.id = " + id);
    return (Cliente) query.getSingleResult();
  }

}
