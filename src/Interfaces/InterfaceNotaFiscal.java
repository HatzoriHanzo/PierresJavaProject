/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BasicClasses.NotaFiscal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public interface InterfaceNotaFiscal {
    
    public void cadastrarNotaf(NotaFiscal notaf) throws SQLException, Exception;
    public void removerNotaFiscal(NotaFiscal notaf) throws SQLException, Exception;
    public void atualizarNotaFiscal(NotaFiscal notaf) throws SQLException, Exception;
    public ArrayList<NotaFiscal> consultar(NotaFiscal notaf) throws SQLException , Exception;
}
