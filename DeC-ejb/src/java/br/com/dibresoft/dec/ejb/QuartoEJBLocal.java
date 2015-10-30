/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Quarto;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface QuartoEJBLocal {
  
  public void cadastrar(Quarto quarto);
  
}
