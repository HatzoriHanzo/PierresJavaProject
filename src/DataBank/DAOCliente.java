/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBank;

import java.sql.*;
import BasicClasses.Conexao;
import BasicClasses.Cliente;
import java.util.ArrayList;
import Interfaces.InterfaceCliente;

public class DAOCliente extends Conexao implements InterfaceCliente {

    Conexao conectar = new Conexao();
    ResultSet rs = null;
    PreparedStatement pst;

   
   
   

 
    @Override
    public ArrayList<Cliente> consultarClienteCpf(Cliente cliente) throws SQLException, Exception {
        ArrayList<Cliente> clientearraylist = new ArrayList<Cliente>();
        String sql = "Select cli_nome,cli_cpf,cli_endereco ";
        sql += " from Cliente ";
        sql += " where cli_cpf is not null ";
        
        
         if (cliente.getCliente_cpf()!= null && cliente.getCliente_cpf().trim().equals("") == false) {
            sql += " and cli_cpf  = ? ";
        }
        if (cliente.getCliente_nome() != null && cliente.getCliente_nome().trim().equals("") == false) {
            sql += " and cli_nome like ? ";
        }
        pst = super.conectar().prepareStatement(sql);
        int pos = 1;
       
        if (cliente.getCliente_cpf() != null && cliente.getCliente_cpf().trim().equals("") == false) {
            pst.setString(pos, cliente.getCliente_cpf());
            pos++;
        }
        if (cliente.getCliente_nome() != null && cliente.getCliente_nome().trim().equals("") == false) {
            pst.setString(pos, "%" + cliente.getCliente_nome() + "%");
            pos++;
        }
        
        rs = pst.executeQuery();

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setCliente_nome(rs.getString("cli_nome"));
            c.setCliente_cpf(rs.getString("cli_cpf"));
            c.setCliente_endereco(rs.getString("cli_endereco"));

            clientearraylist.add(c);
        }
        super.desconectar();
        return clientearraylist;

    }


    @Override
    public void cadastrarCliente(Cliente cliente) throws Exception {
        String sql = "insert into cliente (cli_nome,cli_cpf,cli_endereco) values (?,?,?)";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, cliente.getCliente_nome());
        pst.setString(2, cliente.getCliente_cpf());
        pst.setString(3, cliente.getCliente_endereco());
        pst.executeUpdate();
        super.desconectar();
    }

    @Override
    public void removerCliente(Cliente cliente) throws Exception {
        String sql = "DELETE FROM cliente WHERE cli_cpf = ? ";

        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, cliente.getCliente_cpf());
        pst.executeUpdate();
        super.desconectar();
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws Exception {
        String sql = "UPDATE cliente SET cli_nome = ?,cli_endereco = ? WHERE cli_cpf = ? ";
        pst = super.conectar().prepareStatement(sql);
        pst.setString(1, cliente.getCliente_nome());
        pst.setString(2, cliente.getCliente_endereco());
        pst.setString(3, cliente.getCliente_cpf());
        pst.executeUpdate();
        super.desconectar();
    }

  
   
}
