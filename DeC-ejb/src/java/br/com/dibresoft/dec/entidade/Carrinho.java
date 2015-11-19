package br.com.dibresoft.dec.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import javax.persistence.OneToMany;

/**
 *
 * @author udimberto.sjunior
 */
@Entity
@Table(name = "DeC_CARRINHO")
public class Carrinho implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  @OneToMany
  private ArrayList<Quarto> itens = new ArrayList();

  public ArrayList<Quarto> getItens() {
    return itens;
  }

  public void setItens(ArrayList<Quarto> itens) {
    this.itens = itens;
  }

  public int getPrecoTotal() {
    return precoTotal;
  }

  public void setPrecoTotal(int precoTotal) {
    this.precoTotal = precoTotal;
  }
  private int precoTotal;

  private boolean status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
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
    if (!(object instanceof Carrinho)) {
      return false;
    }
    Carrinho other = (Carrinho) object;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.dibresoft.dec.entidade.Carrinho[ id=" + id + " ]";
  }

}