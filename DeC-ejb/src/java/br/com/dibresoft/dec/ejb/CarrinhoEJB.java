/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.ejb;

import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.Reserva;
/**
 *
 * @author fabio
 */
@Stateful
public class CarrinhoEJB implements CarrinhoEJBLocal {
    @PersistenceContext
    private EntityManager em;
    private ArrayList<Reserva> itens = new ArrayList();
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean adicionaItem(Reserva reserva) {
        itens.add(reserva);
        em.persist(itens);
        return true;
    }

    @Override
    public boolean removeItem(Reserva reserva) {
        if(itens.contains(reserva)){
            itens.remove(reserva);
            return true;
        }
        return false;
    }

    @Override
    public float calculaTotal(ArrayList<Reserva> itens) {
        float precoTotal=0;
        for(int i = 0; i < itens.size(); i++){
            Reserva r = itens.get(i);
            precoTotal += r.getValorEstadia();
        }
        return precoTotal;
    }
}
