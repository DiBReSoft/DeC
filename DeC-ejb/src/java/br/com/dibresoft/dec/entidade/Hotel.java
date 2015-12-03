package br.com.dibresoft.dec.entidade;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

  private String titulo;

  private String telefone;

  private String email;
  
  private String chaveURL;
  
  private boolean servicoQuarto;
  private boolean restaurante;
  private boolean piscina;
  private boolean estacionamento;
  

  @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private Endereco endereco;

  @OneToOne(mappedBy = "hotel")
  private Quarto quartos;

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
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getChaveURL() {
    return chaveURL;
  }

  public void setChaveURL(String chaveURL) {
    this.chaveURL = chaveURL;
  }

  public boolean isServicoQuarto() {
    return servicoQuarto;
  }

  public void setServicoQuarto(boolean servicoQuarto) {
    this.servicoQuarto = servicoQuarto;
  }

  public boolean isRestaurante() {
    return restaurante;
  }

  public void setRestaurante(boolean restaurante) {
    this.restaurante = restaurante;
  }

  public boolean isPiscina() {
    return piscina;
  }

  public void setPiscina(boolean piscina) {
    this.piscina = piscina;
  }

  public boolean isEstacionamento() {
    return estacionamento;
  }

  public void setEstacionamento(boolean estacionamento) {
    this.estacionamento = estacionamento;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Quarto getQuartos() {
    return quartos;
  }

  public void setQuartos(Quarto quartos) {
    this.quartos = quartos;
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

}
