/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBank;

import BasicClasses.Comida;
import java.sql.*;
import BasicClasses.Conexao;
import Interfaces.InterfaceComida;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class DAOComida extends Conexao implements InterfaceComida {
    Conexao conectar = new Conexao();
    ResultSet rs = null;
    PreparedStatement pst;
    
    @Override
    public void cadastrarComida(Comida comida) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO produto (Prod_Nome,Prod_Com_Categoria,Prod_Tipo) ";
        sql += " VALUES (?,?,1)";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1,comida.getNome());
        pst.setString(2, comida.getCategoria());
        pst.executeUpdate();
        super.desconectar();
    
}
    @Override
    public void removerComida(Comida comida) throws SQLException, Exception {
        String sql = "DELETE FROM produto WHERE Prod_Codigo =? and Prod_Tipo = 1 ;";

        pst = super.conectar().prepareStatement(sql);
        pst.setInt(1, comida.getCodigo());
        pst.executeUpdate();
        super.desconectar();
    }
    @Override
    public void atualizarComida(Comida comida) throws SQLException, Exception {
        String sql = "UPDATE produto SET Prod_Nome = ?,Prod_Com_Categoria = ? WHERE Prod_Codigo = ? and Prod_Tipo = 1";

        pst = super.conectar().prepareStatement(sql);
        pst.setString(1,comida.getNome());
        pst.setString(2,comida.getCategoria());
        pst.setInt(3,comida.getCodigo());
        pst.executeUpdate();
        super.desconectar();
    }
    @Override
    public ArrayList<Comida> consultar(Comida comida) throws SQLException , Exception {
            ArrayList<Comida> comidaarraylist = new ArrayList<Comida>();
            String sql = "Select Prod_Codigo,Prod_Nome,Prod_Com_Categoria from produto where Prod_Codigo =? and Prod_Tipo = 1 ";
            pst = super.conectar().prepareStatement(sql);
            pst.setInt(1, comida.getCodigo());
            rs = pst.executeQuery();
            
            while(rs.next()) 
            { Comida c = new Comida();
            c.setCodigo(rs.getInt("Prod_Codigo"));
            c.setNome(rs.getString("Prod_Nome"));
            c.setCategoria(rs.getString("Prod_Com_Categoria"));
            
            comidaarraylist.add(c);
            }
            super.desconectar();   
            return comidaarraylist;    
            
    }
}


