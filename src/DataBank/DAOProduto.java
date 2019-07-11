/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBank;

import BasicClasses.Conexao;
import BasicClasses.NotaFiscal_Produto;
import Interfaces.InterfaceProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class DAOProduto extends Conexao implements InterfaceProduto {
    Conexao conectar = new Conexao();
    ResultSet rs = null;
    PreparedStatement pst;
public ArrayList<NotaFiscal_Produto> consultar(NotaFiscal_Produto notfproduto) throws SQLException , Exception {
            ArrayList<NotaFiscal_Produto> bebidaarraylist = new ArrayList<NotaFiscal_Produto>();
            String sql = "Select Prod_Codigo from produto where Prod_Codigo =?";
            pst = super.conectar().prepareStatement(sql);
            pst.setInt(1, notfproduto.getProduto().getCodigo());
            rs = pst.executeQuery();
            
            while(rs.next()) 
            { NotaFiscal_Produto b = new NotaFiscal_Produto();
            b.getProduto().setCodigo(rs.getInt("Prod_Codigo"));
           
            
            
            bebidaarraylist.add(b);
            }
            super.desconectar();   
            return bebidaarraylist;    
            
    }


    
    
}
