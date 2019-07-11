/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BasicClasses.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;


 public interface InterfaceCliente {
    
     //public ArrayList<Cliente> consultarNomeCliente(Cliente cliente) throws SQLException , Exception;
     public ArrayList<Cliente> consultarClienteCpf(Cliente cliente) throws Exception;
     public void cadastrarCliente(Cliente cliente) throws Exception;
     public void removerCliente(Cliente cliente) throws Exception;
     public void atualizarCliente(Cliente cliente) throws Exception;
}
