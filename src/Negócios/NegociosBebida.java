/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negócios;

import BasicClasses.Bebida;
import DataBank.DAOBebida;
import Interfaces.InterfaceBebida;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class NegociosBebida implements InterfaceBebida {

    
    
    
    
    
    
    
    
    @Override
    public void cadastrarBebida(Bebida bebida) throws SQLException, Exception {
        if (bebida.getNome().trim().equals("") == true) {
            throw new Exception("este campo não pode ser nulo!!");
        }
        if (!(bebida.getCapacidade()==300 || bebida.getCapacidade() ==600)){
            throw new Exception("No Momento só temos em estoque Longneck de 300ml e 600ml");
        }
        if (!(bebida.getCapacidade()==300 || bebida.getCapacidade() ==600)){
            throw new Exception ("Insira capacidade de 300ml ou 600 ml");
        }
        DAOBebida dados = new DAOBebida();
        dados.cadastrarBebida(bebida);
    }

    @Override
    public void removerBebida(Bebida bebida) throws SQLException, Exception {
          if (bebida.getCodigo()<=0){
            throw new Exception("Insira um numero válido!");
        }
            DAOBebida dados = new DAOBebida();
            dados.removerBebida(bebida);
    }

    @Override
    public void atualizarBebida(Bebida bebida) throws SQLException, Exception {
         if (bebida.getCodigo()<=0){
            throw new Exception("Insira um numero válido!");
        }
         if (bebida.getNome().trim().equals("") == true) {
            throw new Exception("este campo não pode ser nulo!!");
        }
        if (!(bebida.getCapacidade()==300 || bebida.getCapacidade() ==600)){
            throw new Exception("No Momento só temos em estoque Longneck de 300ml e 600ml");
        }
        if (!(bebida.getCapacidade()==300 || bebida.getCapacidade() ==600)){
            throw new Exception ("Insira capacidade de 300ml ou 600 ml");
        }
        DAOBebida dados = new DAOBebida();
        dados.atualizarBebida(bebida);
    }

    @Override
    public ArrayList<Bebida> consultar(Bebida bebida) throws SQLException, Exception {
         if (bebida.getCodigo()<=0){
            throw new Exception("Insira um numero válido!");
        }
            DAOBebida dados = new DAOBebida();
           return dados.consultar(bebida);
    }
    
}
