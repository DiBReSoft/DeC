package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Categoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface CategoriaEJBLocal {

  public void cadastrar(Categoria categoria);

  public void buscar(Categoria categoria);

  public void alterar(Categoria categoria);

  public List<Categoria> listarTodos();

  public List<Categoria> listarAtivas();

  public List<Categoria> listarInativas();

  public Categoria buscarCategoria(String nome);

  public Categoria buscarCategoriaPorID(Long id);

}
