package br.com.dibresoft.dec.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author jSilverize
 */
@Entity
@Table(name = "DeC_COMPRA")
public class Compra implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String status;

  @ManyToOne
  private Cliente cliente;

  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dataCompra;

  private String cartaoBandeira;
  private double cartaoParcelas;
  private double valorParcelas;
  private double valorTotal;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Date getDataCompra() {
    return dataCompra;
  }

  public void setDataCompra(Date dataCompra) {
    this.dataCompra = dataCompra;
  }

  public String getCartaoBandeira() {
    return cartaoBandeira;
  }

  public void setCartaoBandeira(String cartaoBandeira) {
    this.cartaoBandeira = cartaoBandeira;
  }

  public double getCartaoParcelas() {
    return cartaoParcelas;
  }

  public void setCartaoParcelas(double cartaoParcelas) {
    this.cartaoParcelas = cartaoParcelas;
  }

  public double getValorParcelas() {
    return valorParcelas;
  }

  public void setValorParcelas(double valorParcelas) {
    this.valorParcelas = valorParcelas;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Compra)) {
      return false;
    }
    Compra other = (Compra) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.dibresoft.dec.entidade.Compra[ id=" + id + " ]";
  }

}
