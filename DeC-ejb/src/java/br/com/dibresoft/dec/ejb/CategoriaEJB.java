package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Categoria;
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
public class CategoriaEJB implements CategoriaEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void cadastrar(Categoria categoria) {

    em.persist(categoria);

  }

  @Override
  public void buscar(Categoria categoria) {

  }

  @Override
  public void alterar(Categoria categoria) {

    em.merge(categoria);

  }

  @Override
  public List<Categoria> listarTodos() {

    Query query = em.createQuery("Select c from Categoria c ORDER BY c.titulo");

    List<Categoria> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public List<Categoria> listarAtivas() {

    Query query = em.createQuery("Select c from Categoria c WHERE c.status = 1 ORDER BY c.titulo");

    List<Categoria> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public List<Categoria> listarInativas() {

    Query query = em.createQuery("Select c from Categoria c WHERE c.status = 0 ORDER BY c.titulo");

    List<Categoria> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public Categoria buscarCategoria(String tituloCategoria) {

    return em.find(Categoria.class, tituloCategoria);

  }

  @Override
  public Categoria buscarCategoriaPorID(Long id) {

    return em.find(Categoria.class, id);

  }

}
