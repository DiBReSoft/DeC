package br.com.dibresoft.dec.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author udimberto.sjunior
 */
@Entity
@Table(name = "DeC_HOTEL")
public class Hotel implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private boolean status;
  
  private String tituloHotel;
  @OneToOne
  private Endereco endereco;
  private int qtdeQuartos;
  private String cidade;
  private int telefone;
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getTitulo() {
    return tituloHotel;
  }

  public void setTitulo(String tituloHotel) {
    this.tituloHotel = tituloHotel;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
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
    if (!(object instanceof Hotel)) {
      return false;
    }
    Hotel other = (Hotel) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "br.com.dibresoft.dec.entidade.Hotel[ id=" + id + " ]";
  }

  public String getTituloHotel() {
    return tituloHotel;
  }

  public void setTituloHotel(String tituloHotel) {
    this.tituloHotel = tituloHotel;
  }

  public int getQtdeQuartos() {
    return qtdeQuartos;
  }

  public void setQtdeQuartos(int qtdeQuartos) {
    this.qtdeQuartos = qtdeQuartos;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public int getTelefone() {
    return telefone;
  }

  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
