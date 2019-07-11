/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BasicClasses.Vendedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public interface InterfaceVendedor {
    public ArrayList<Vendedor> consultar(Vendedor vendedor) throws SQLException , Exception;
    public void cadastrar(Vendedor vendedor)throws SQLException , Exception;
    public void remover(Vendedor vendedor) throws SQLException, Exception;
    public void atualizar(Vendedor vendedor) throws SQLException, Exception;
 
}
