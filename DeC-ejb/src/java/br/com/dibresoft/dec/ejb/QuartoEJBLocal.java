package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Quarto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface QuartoEJBLocal {
  
  public boolean cadastrar(Quarto quarto);
  
  public List<Quarto> listarTodos();
  
  public Quarto getQuartoById(long id);
  
}
