package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Reserva;
import java.util.Date;
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
public class ReservaEJB implements ReservaEJBLocal {

  @PersistenceContext
  private EntityManager em;

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
  public boolean verificarDisponibilidadeQuartos(Reserva reserva,Long categoriaId, Long hotelId) {
        List <Reserva> reservas;
    
    Query q = em.createNamedQuery("Reserva.verificarDisponibilidade");
    q.setParameter("checkIn",reserva.getCheckIn());
    q.setParameter("checkOut",reserva.getCheckOut());
    q.setParameter("categoriaId",categoriaId);
    q.setParameter("hotelId",hotelId);
    
    reservas = q.getResultList();
    
    for(Reserva r : reservas)
    {
      System.out.println(r.getQuarto().getTitulo()+" "+r.getQuarto().getHotel()+" "+r.getQuarto().getCategoria());
    }
    
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
