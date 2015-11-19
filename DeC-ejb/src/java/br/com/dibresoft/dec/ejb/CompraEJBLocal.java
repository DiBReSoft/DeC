package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Compra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jSilverize
 */
@Local
public interface CompraEJBLocal {
  
  public void cadastrar(Compra compra);

  public void buscar(Compra compra);

  public void alterar(Compra compra);

  public void inativar(Compra compra);
  
  public List<Compra> listarTodas();
  
}
