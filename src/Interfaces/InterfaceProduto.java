/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BasicClasses.NotaFiscal_Produto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public interface InterfaceProduto {
    public ArrayList<NotaFiscal_Produto> consultar(NotaFiscal_Produto notfproduto) throws SQLException , Exception;
    
}
