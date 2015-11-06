/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dibresoft.dec.ejb;

import br.com.dibresoft.dec.entidade.Cliente;
import javax.ejb.Local;

/**
 *
 * @author udimberto.sjunior
 */
@Local
public interface ClienteEJBLocal {

  public boolean cadastrar(Cliente membro);

  public boolean inativar(Cliente membro);
  
  public void alterar(Cliente membro);
  
  public boolean validarCpf(Cliente membro);

}