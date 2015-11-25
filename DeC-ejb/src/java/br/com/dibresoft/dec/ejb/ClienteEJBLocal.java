package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Cliente;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface ClienteEJBLocal {

  public boolean cadastrar(Cliente membro);

  public boolean inativar(Cliente membro);
  
  public void alterar(Cliente membro);
  
  public boolean validar(String cpf, String Email);
  
  public boolean buscarClientePorCpf(String cpf);
  
  public Cliente buscarClientePorId(long id);
  
  public Cliente autenticar (String email, String senha);
  
  

}