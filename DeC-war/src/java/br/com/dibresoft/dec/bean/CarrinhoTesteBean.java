/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.bean;

import br.com.dibresoft.dec.entidade.Reserva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Thi
 */
@ManagedBean
@SessionScoped
public class CarrinhoTesteBean {
  private Reserva reserva = new Reserva();
    private List<Reserva> lista;

    public CarrinhoTesteBean(List<Reserva> lista) {
        this.lista = lista;
    }

    public List<Reserva> getLista() {
        return lista;
    }

    public void setLista(List<Reserva> lista) {
        this.lista = lista;
 
    }
    public void create(){
      reserva = new Reserva();
 }
}
