/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.entidade;

import java.util.List;

/**
 *
 * @author Thi
 */
public class CarrinhoTeste {
    private List<Reserva> lista;

    public CarrinhoTeste(List<Reserva> lista) {
        this.lista = lista;
    }

    public List<Reserva> getLista() {
        return lista;
    }

    public void setLista(Reserva lista) {
        this.lista.add(lista);
    }
    
    
}
