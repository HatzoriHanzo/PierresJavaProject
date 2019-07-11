/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBank;
import BasicClasses.Bebida;
import BasicClasses.Conexao;
import Interfaces.InterfaceBebida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class DAOBebida extends Conexao implements InterfaceBebida { 
    Conexao conectar = new Conexao();
    ResultSet rs = null;
    PreparedStatement pst;
    
    @Override
     public void cadastrarBebida(Bebida bebida) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO produto (Prod_Nome,Prod_Beb_Capacidade,Prod_Beb_Marca,Prod_Tipo) ";
        sql += " VALUES (?,?,?,0)";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, bebida.getNome());
        pst.setInt(2, bebida.getCapacidade());
        pst.setString(3, bebida.getMarca());
        pst.executeUpdate();
        super.desconectar();
    
}
    @Override
     public void removerBebida(Bebida bebida) throws SQLException, Exception {
        String sql = "DELETE FROM produto WHERE Prod_Codigo = ? and Prod_Tipo = 0 ";

        pst = super.conectar().prepareStatement(sql);
        pst.setInt(1, bebida.getCodigo());
        pst.executeUpdate();
        super.desconectar();
    }
    @Override
     public void atualizarBebida(Bebida bebida) throws SQLException, Exception {
        String sql = "UPDATE produto SET Prod_Nome = ?,Prod_Capacidade = ?,Prod_Marca = ? WHERE Prod_Codigo = ? and Prod_Tipo = 0 ";

        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, bebida.getNome());
        pst.setInt(2, bebida.getCapacidade());
        pst.setString(3,bebida.getMarca());
        pst.setInt(4,bebida.getCodigo());
        pst.executeUpdate();
        super.desconectar();
    }
    @Override
     public ArrayList<Bebida> consultar(Bebida bebida) throws SQLException , Exception {
            ArrayList<Bebida> bebidaarraylist = new ArrayList<Bebida>();
            String sql = "Select Prod_Codigo,Prod_Nome,Prod_Beb_Capacidade,Prod_Beb_Marca from produto where Prod_Codigo =? and Prod_Tipo = 0";
            pst = super.conectar().prepareStatement(sql);
            pst.setInt(1, bebida.getCodigo());
            rs = pst.executeQuery();
            
            while(rs.next()) 
            { Bebida b = new Bebida();
            b.setCodigo(rs.getInt("Prod_Codigo"));
            b.setNome(rs.getString("Prod_Nome"));
            b.setCapacidade(rs.getInt("Prod_Beb_Capacidade"));
            b.setMarca(rs.getString("Prod_Beb_Marca"));
            
            bebidaarraylist.add(b);
            }
            super.desconectar();   
            return bebidaarraylist;    
            
    }
     
    
}
  