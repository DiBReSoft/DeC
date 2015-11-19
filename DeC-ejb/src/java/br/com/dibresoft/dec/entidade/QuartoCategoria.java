package br.com.dibresoft.dec.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jSilverize
 */
@Entity
@Table(name = "DeC_QUARTOCATEGORIA")
public class QuartoCategoria implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String status;
  private String nome;  
  private double valor;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
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
    if (!(object instanceof QuartoCategoria)) {
      return false;
    }
    QuartoCategoria other = (QuartoCategoria) object;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.dibresoft.dec.entidade.QuartoCategoria[ id=" + id + " ]";
  }

}
