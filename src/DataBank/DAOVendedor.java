/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBank;

import java.sql.*;
import BasicClasses.Conexao;
import BasicClasses.Vendedor;
import Interfaces.InterfaceVendedor;
import java.util.ArrayList;

public class DAOVendedor extends Conexao implements InterfaceVendedor {

    Conexao conectar = new Conexao();
    ResultSet rs = null;
    PreparedStatement pst;

    @Override
    public ArrayList<Vendedor> consultar(Vendedor vendedor) throws SQLException, Exception {
        ArrayList<Vendedor> vendedorarraylist = new ArrayList<Vendedor>();
        String sql = " Select vend_codigo, vend_nome, vend_cpf ";
        sql += " from Vendedor ";
        sql += " where vend_codigo > 0 ";

        if (vendedor.getVend_codigo() > 0) {
            sql += " and vend_codigo  = ? ";
        }

        if (vendedor.getVendedor_cpf() != null && vendedor.getVendedor_cpf().trim().equals("") == false) {
            sql += " and vend_cpf  = ? ";
        }
        if (vendedor.getVendedor_nome() != null && vendedor.getVendedor_nome().trim().equals("") == false) {
            sql += " and vend_nome  like ? ";
        }
        pst = super.conectar().prepareStatement(sql);
        int pos = 1;

        if (vendedor.getVend_codigo() > 0) {
            pst.setInt(pos, vendedor.getVend_codigo());
            pos++;
        }

        if (vendedor.getVendedor_cpf() != null && vendedor.getVendedor_cpf().trim().equals("") == false) {
            pst.setString(pos, vendedor.getVendedor_cpf());
            pos++;
        }
        if (vendedor.getVendedor_nome() != null && vendedor.getVendedor_nome().trim().equals("") == false) {
            pst.setString(pos, "%" + vendedor.getVendedor_nome() + "%");
            pos++;
        }

        rs = pst.executeQuery();

        while (rs.next()) {
            Vendedor v = new Vendedor();
            v.setVendedor_nome(rs.getString("vend_nome"));
            v.setVendedor_cpf(rs.getString("vend_cpf"));
            v.setVend_codigo(rs.getInt("vend_codigo"));

            vendedorarraylist.add(v);
        }
        super.desconectar();
        return vendedorarraylist;

    }

    @Override
    public void cadastrar(Vendedor vendedor) throws SQLException, Exception {
        String sql = "insert into vendedor (vend_nome,vend_cpf) values (?,?)";

        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, vendedor.getVendedor_nome());
        pst.setString(2, vendedor.getVendedor_cpf());
        pst.executeUpdate();
        super.desconectar();

    }

    @Override
    public void remover(Vendedor vendedor) throws SQLException, Exception {
        String sql = "DELETE FROM vendedor WHERE vend_cpf = ? ";

        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, vendedor.getVendedor_cpf());
        pst.executeUpdate();
        super.desconectar();

    }

    @Override
    public void atualizar(Vendedor vendedor) throws SQLException, Exception {
        String sql = "UPDATE vendedor SET vend_nome = ? WHERE vend_codigo = ? ";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, vendedor.getVendedor_nome());
        pst.setString(2, vendedor.getVendedor_cpf());
        // execute insert SQL stetement
        pst.executeUpdate();
        //fechando a conexÃ£o com o banco de dados
        super.desconectar();
    }

}
