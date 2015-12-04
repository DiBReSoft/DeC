package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Cliente;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface ClienteEJBLocal {

  public boolean cadastrar(Cliente cliente);

  public void inativar(Cliente cliente);
  
  public void alterar(Cliente cliente);
  
  public boolean validar(String cpf, String Email);
  
  public boolean buscarClientePorCpf(String cpf);
  
  public Cliente buscarClientePorId(long id);
  
  public Cliente autenticar (String email, String senha);
  
  

}