package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.QuartoCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jSilverize
 */
@Local
public interface QuartoCategoriaEJBLocal {

  public boolean cadastrar(QuartoCategoria categoria);

  public List<QuartoCategoria> listarTodas();

}
