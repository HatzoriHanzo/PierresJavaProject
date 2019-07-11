/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BasicClasses.Comida;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public interface InterfaceComida {
     void cadastrarComida(Comida comida) throws SQLException, Exception;
     void removerComida(Comida comida) throws SQLException, Exception;
     void atualizarComida(Comida comida) throws SQLException, Exception ;
     ArrayList<Comida> consultar(Comida comida) throws SQLException , Exception;
}
