/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBank;

import BasicClasses.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import BasicClasses.NotaFiscal;
import BasicClasses.NotaFiscal_Produto;
import BasicClasses.Utilidade;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class DAONotaFiscal extends Conexao {
    Conexao conectar = new Conexao();
    ResultSet rs = null;
    PreparedStatement pst;
    PreparedStatement pst2;
    
    public void cadastrarNotaf(NotaFiscal notaf) throws SQLException, Exception {
        
        String sql = "INSERT INTO NotaFiscal (Cli_Cpf,Vend_Codigo,Data_Emissao,Nota_Codigo) ";
        sql += " VALUES (?,?,?,?)";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1,notaf.getCliente().getCliente_cpf());
        pst.setInt(2,notaf.getVendedor().getVend_codigo());
        pst.setDate(3,Utilidade.getSqlDate(notaf.getData()));
        pst.setInt(4,notaf.getNota_codigo());
        pst.executeUpdate();
        
        for(NotaFiscal_Produto notaprodutoarray : notaf.getItems()){
           String sql2 = "INSERT INTO NotaFiscal_Produto (Quantidade,Preco,Nota_Codigo,Prod_Codigo) values (?,?,?,?) "; 
           pst2 = super.conectar().prepareStatement(sql2);
           pst2.setInt(1, notaprodutoarray.getQuantidade());
           pst2.setDouble(2,notaprodutoarray.getPreco());
           pst2.setInt(3,notaf.getNota_codigo());
           pst2.setInt(4,notaprodutoarray.getProduto().getCodigo());
           pst2.executeUpdate();
        }
                
        super.desconectar();
    
}
 public void removerNotaFiscal(NotaFiscal notaf) throws SQLException, Exception {
        String sql = "DELETE FROM NotaFiscal WHERE Nota_Codigo = ?";

        pst = super.conectar().prepareStatement(sql);
        pst.setInt(1, notaf.getNota_codigo());
        pst.executeUpdate();
        super.desconectar();
    }
 public void atualizarNotaFiscal(NotaFiscal notaf) throws SQLException, Exception {
        String sql = "UPDATE Nota_Fiscal SET Cli_Cpf = ?,Vend_Codigo = ?,Data_Emissao = ? WHERE Nota_Codigo = ? ";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, notaf.getCliente().getCliente_cpf());
        pst.setInt(2, notaf.getVendedor().getVend_codigo());
        pst.setDate(3,(Utilidade.getSqlDate(notaf.getData())));
        pst.setInt(4,notaf.getNota_codigo());
        pst.executeUpdate();
        super.desconectar();
    }
 public ArrayList<NotaFiscal> consultar(NotaFiscal notaf) throws SQLException , Exception {
            ArrayList<NotaFiscal> notafarraylist = new ArrayList<NotaFiscal>();
            String sql = " Select NotaFiscal.Nota_Codigo,NotaFiscal.Data_Emissao,Cliente.Cli_Nome,Vendedor.Vend_Nome from NotaFiscal ";
            sql +=" JOIN Cliente ";
            sql +=" JOIN Vendedor ";
            sql +=" ON NotaFiscal.Cli_Cpf = Cliente.Cli_Cpf ";
            sql +=" and NotaFiscal.Vend_Codigo = Vendedor.Vend_Codigo ";
            pst = super.conectar().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) 
            { NotaFiscal n = new NotaFiscal();
            n.setNota_codigo(rs.getInt("Nota_Codigo"));
            n.setData(rs.getDate("Data_Emissao"));
            n.getVendedor().setVendedor_nome(rs.getString("Vend_Nome"));
            n.getCliente().setCliente_nome(rs.getString("Cli_Nome"));
            
            notafarraylist.add(n);
            }
            super.desconectar();   
            return notafarraylist;    
            
    }
}
