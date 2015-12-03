package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Categoria;
import br.com.dibresoft.dec.entidade.Hotel;
import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author udimberto.sjunior
 */
@Stateless
public class ReservaEJB implements ReservaEJBLocal {

  @PersistenceContext
  private EntityManager em;

  @EJB
  private QuartoEJBLocal quartoEJB;

  @EJB
  private CategoriaEJBLocal categoriaEJB;

  @Override
  public Reserva verificarDisponibilidade(Categoria categoriaSelecionada, Hotel hotelSelecionado, Reserva reserva) {
    /**
     * Aqui nós precisamos fazer uma verificação de Quartos disponíveis, de
     * acordo com o período (reserva.getCheckin() reserva.getCheckout()) e
     * considerando a 'categoriaSelecionada.getId()' e também considerando o
     * 'hotelSelecionado.getId()', retornando a Reserva. CASO TENHA QUARTO
     * DISPONÍVEL, aí retorna a Reserva, definindo um Quarto para ela
     * 'reserva.setQuarto(quartoEncontrado)'. CASO NÃO TENHA, aí é só retornar a
     * reserva sem o quarto mesmo, como null.
     */

    List<Quarto> quartos;
    Query q = em.createNamedQuery("Quarto.listarCategoriaHotel");
    q.setParameter("categoria_id", categoriaSelecionada.getId());
    q.setParameter("hotel_id", hotelSelecionado.getId());
    quartos = q.getResultList();

    List<Reserva> reservas;
    q = em.createNamedQuery("Reserva.listarNoPeriodo");
    q.setParameter("checkIn", reserva.getCheckIn());
    q.setParameter("checkOut", reserva.getCheckOut());
    reservas = q.getResultList();

    Quarto quarto = new Quarto();

    if (!reservas.isEmpty() && !quartos.isEmpty()) {

      for (Reserva reser : reservas) {

        for (Quarto quar : quartos) {

          if (!Objects.equals(reser.getQuarto().getId(), quar.getId())) {

            quarto = quar;

          }

        }

      }

    } else if (!quartos.isEmpty()) {
      
      quarto = quartos.get(0);
      
    }

    if (quarto.getId() != null) {

      Categoria categoria;
      categoria = categoriaEJB.buscarCategoriaPorID(quarto.getCategoria().getId());

      quarto.setCategoria(categoria);

      reserva.setQuarto(quarto);

    } else {

      reserva.setQuarto(null);

    }

    return reserva;

  }

  @Override
  public double calcularValorReserva(Reserva reserva) {

    double valor;

    long t1 = reserva.getCheckIn().getTime();
    long t2 = reserva.getCheckOut().getTime();
    long t3 = t2 - t1;

    t3 = (t3 / 86400000) + 1;

    if (t3 < 0) {

      return 0;

    } else {

      return valor = t3 * reserva.getQuarto().getCategoria().getValor();

    }

  }

  @Override
  public void cadastrar(Reserva reserva) {
    em.persist(reserva);
  }

  @Override
  public void buscar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void alterar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void inativar(Reserva reserva) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean verificarDisponibilidadeQuartos(Reserva reserva, Long categoriaId, Long hotelId) {
    List<Reserva> reservas;

    Query q = em.createNamedQuery("Reserva.verificarDisponibilidade");
    q.setParameter("checkIn", reserva.getCheckIn());
    q.setParameter("checkOut", reserva.getCheckOut());
    q.setParameter("categoriaId", categoriaId);
    q.setParameter("hotelId", hotelId);

    reservas = q.getResultList();

    for (Reserva r : reservas) {
      System.out.println(r.getQuarto().getTitulo() + " " + r.getQuarto().getHotel() + " " + r.getQuarto().getCategoria());
    }

    throw new UnsupportedOperationException("Not supported yet.");
  }
}
