/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Promocao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luciano.lourenco
 */
@Local
public interface PromocaoEJBLocal {
    
    public void cadastrar(Promocao promocao);
    
    public void inativar(Promocao promocao);
    
    public void alterar(Promocao promocao);
    
    public List<Promocao> listar();
    
}
