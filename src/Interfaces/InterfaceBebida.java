/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BasicClasses.Bebida;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Victor
 */
public interface InterfaceBebida {
     void cadastrarBebida(Bebida bebida) throws SQLException, Exception;
     void removerBebida(Bebida bebida) throws SQLException, Exception;
     void atualizarBebida(Bebida bebida) throws SQLException, Exception;
     ArrayList<Bebida> consultar(Bebida bebida) throws SQLException , Exception;
     
    
}
