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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Thi
 */
@ManagedBean
@SessionScoped
public class CarrinhoTesteBean{
  
  private Reserva reserva = new Reserva();
    private List<Reserva> lista = new ArrayList<>();
    @EJB
    private CarrinhoEJBLocal carrinhoEJB;
    
    public CarrinhoTesteBean(){
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
    public String create(){
      lista.add(reserva);
      System.out.println(lista.size());
      System.out.println(reserva.getCheckIn());
      System.out.println(reserva.getCheckOut());
      System.out.println(reserva.getQuarto());
      reserva = new Reserva();
      reserva.setQuarto(new Quarto());
      
      
      return "carrinho";
 }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }
    
    
}
