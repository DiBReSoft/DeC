package br.com.dibresoft.dec.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author udimberto.sjunior
 */
@Entity
@Table(name = "DeC_RESERVA")
@NamedQueries({
  @NamedQuery(
          name = "Reserva.listarNoPeriodo",
          query
          = "SELECT r FROM Reserva r WHERE r.checkIn >= :checkIn OR r.checkOut <= :checkOut "),
  @NamedQuery(
          name = "Reserva.listarTodas",
          query
          = "SELECT r FROM Reserva r "),
  @NamedQuery(
          name = "Reserva.listarReservasCliente",
          query
          = "SELECT r FROM Reserva r WHERE r.cliente.id = :clienteId ")
})
public class Reserva implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  /* 'a' = aprovada || 'c' = cancelada */
  private char status;

  @ManyToOne
  private Cliente cliente;
  @OneToOne
  private Quarto quarto;

  @Temporal(javax.persistence.TemporalType.DATE)
  private Date checkIn;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date checkOut;

  private double valorEstadia;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Quarto getQuarto() {
    return quarto;
  }

  public void setQuarto(Quarto quarto) {
    this.quarto = quarto;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(Date checkIn) {
    this.checkIn = checkIn;
  }

  public Date getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(Date checkOut) {
    this.checkOut = checkOut;
  }

  public double getValorEstadia() {
    return valorEstadia;
  }

  public void setValorEstadia(double valorEstadia) {
    this.valorEstadia = valorEstadia;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) id;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Reserva)) {
      return false;
    }
    Reserva other = (Reserva) object;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.dibresoft.dec.entidade.Reserva[ id=" + id + " ]";
  }

}
