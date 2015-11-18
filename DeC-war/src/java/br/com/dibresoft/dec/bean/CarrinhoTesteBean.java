/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.ejb.CarrinhoEJB;
import br.com.dibresoft.dec.ejb.CarrinhoEJBLocal;
import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.Reserva;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thi
 */
@ManagedBean
@SessionScoped
public class CarrinhoTesteBean {

  private Reserva reserva = new Reserva();
  private List<Reserva> lista = new ArrayList<>();
  @EJB
  private CarrinhoEJBLocal carrinhoEJB;

  public CarrinhoTesteBean() {
    reserva.setQuarto(new Quarto());
  }

  public CarrinhoTesteBean(List<Reserva> lista) {
    this.lista = lista;
  }

  public List<Reserva> getLista() {
    return lista;
  }

  public void setLista(List<Reserva> lista) {
    this.lista = lista;
  }

  public void create() throws IOException {

    try {
      
      reserva.setId(lista.size());

      lista.add(reserva);
      System.out.println("[INFO SITE] Adicionada nova reserva à Mala de Reservas:");
      System.out.println("Data de CheckIn: " + reserva.getCheckIn());
      System.out.println("Data de CheckOut: " + reserva.getCheckOut());
      System.out.println("Quarto Selecionado: " + reserva.getQuarto());
      System.out.println("Itens na Mala: " + lista.size());

      reserva = new Reserva();
      reserva.setQuarto(new Quarto());

      FacesContext.getCurrentInstance().getExternalContext().redirect("reservas/mala");

    } catch (IOException ex) {

      Logger.getLogger(CarrinhoTesteBean.class.getName()).log(Level.SEVERE, null, ex);

      FacesContext.getCurrentInstance().getExternalContext().redirect("erro");

    }

  }
  
  public void removerReserva(int idReserva) throws IOException {
    
    try {
      lista.remove(idReserva);
      
      FacesContext.getCurrentInstance().getExternalContext().redirect("reservas/mala");
      
    } catch (IOException ex) {
      
      Logger.getLogger(CarrinhoTesteBean.class.getName()).log(Level.SEVERE, null, ex);
      
      FacesContext.getCurrentInstance().getExternalContext().redirect("erro");
      
    }
    
  }
  
  public void limparCarrinho() {
    
    lista.clear();
    
  }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

}
