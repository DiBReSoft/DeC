/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.ejb;

import javax.ejb.Local;
import java.util.ArrayList;
import br.com.dibresoft.dec.entidade.Quarto;
import br.com.dibresoft.dec.entidade.Reserva;
/**
 *
 * @author fabio
 */
@Local
public interface CarrinhoEJBLocal {
    
    public boolean adicionaItem(Reserva reserva);
    
    public boolean removeItem(Reserva reserva);
    
    public float calculaTotal(ArrayList<Reserva> itens);
}
