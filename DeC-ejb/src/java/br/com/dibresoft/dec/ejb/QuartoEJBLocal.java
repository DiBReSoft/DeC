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

  public void cadastrar(Quarto quarto);

  public void buscar(Quarto quarto);

  public void alterar(Quarto quarto);

  public List<Quarto> listarTodos();

  public List<Quarto> listarAtivos();

  public List<Quarto> listarInativos();

  public Quarto buscarQuarto(String titulo);

  public Quarto buscarQuartoPorID(Long id);

}
