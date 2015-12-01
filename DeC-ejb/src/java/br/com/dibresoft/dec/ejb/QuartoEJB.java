package br.com.dibresoft.dec.ejb;

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
public class QuartoEJB implements QuartoEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void cadastrar(Quarto quarto) {

    em.persist(quarto);

  }

  @Override
  public void buscar(Quarto quarto) {

  }

  @Override
  public void alterar(Quarto quarto) {

    em.merge(quarto);

  }

  @Override
  public List<Quarto> listarTodos() {

    Query query = em.createQuery("Select c from Quarto c ORDER BY c.titulo");

    List<Quarto> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public List<Quarto> listarAtivos() {

    Query query = em.createQuery("Select c from Quarto c WHERE c.status = true ORDER BY c.titulo");

    List<Quarto> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public List<Quarto> listarInativos() {

    Query query = em.createQuery("Select c from Quarto c WHERE c.status = false ORDER BY c.titulo");

    List<Quarto> hoteis = query.getResultList();

    return hoteis;

  }

  @Override
  public Quarto buscarQuarto(String tituloQuarto) {

    return em.find(Quarto.class, tituloQuarto);

  }

  @Override
  public Quarto buscarQuartoPorID(Long id) {

    return em.find(Quarto.class, id);

  }

}
