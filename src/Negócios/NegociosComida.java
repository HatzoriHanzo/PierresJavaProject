/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negócios;

import BasicClasses.Comida;
import DataBank.DAOComida;
import Interfaces.InterfaceComida;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class NegociosComida implements InterfaceComida {

    @Override
    public void cadastrarComida(Comida comida) throws SQLException, Exception {
        if (comida.getNome().trim().equals("") == true) {
            throw new Exception("este campo não pode ser nulo!!");
        }
        if (comida.getCategoria().trim().equals("")==true){
            throw new Exception("este campo não pode ser nulo!!");
        }
        DAOComida dados = new DAOComida();
        dados.cadastrarComida(comida);
    }
    

    @Override
    public void removerComida(Comida comida) throws SQLException, Exception {
            if (comida.getCodigo()<=0){
            throw new Exception("Insira um numero válido!");
        }
            DAOComida dados = new DAOComida();
            dados.removerComida(comida);
    }

    @Override
    public void atualizarComida(Comida comida) throws SQLException, Exception {
        if (comida.getNome().trim().equals("") == true) {
            throw new Exception("este campo não pode ser nulo!!");
        }
        if (comida.getCategoria().trim().equals("")==true){
            throw new Exception("este campo não pode ser nulo!!");
        }
          if (comida.getCodigo()<=0){
            throw new Exception("Insira um numero válido!");
        }
            DAOComida dados = new DAOComida();
            dados.atualizarComida(comida);
    }

    @Override
    public ArrayList<Comida> consultar(Comida comida) throws SQLException, Exception {
       
            DAOComida dados = new DAOComida();
           return dados.consultar(comida);
    
    
}


}
