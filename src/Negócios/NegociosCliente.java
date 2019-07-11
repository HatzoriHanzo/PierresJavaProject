/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negócios;

import BasicClasses.Cliente;
import DataBank.DAOCliente;
import Interfaces.InterfaceCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.*;

/**
 *
 * @author Victor
 */
public class NegociosCliente implements InterfaceCliente {

    @Override
    public ArrayList<Cliente> consultarClienteCpf(Cliente cliente) throws Exception {
        if (cliente.getCliente_cpf() != null && cliente.getCliente_cpf().trim().equals("") == false) {

            String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
            //^[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{2}$  (^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)
            Pattern pattern = Pattern.compile(cpf_pattern);
            Matcher cpfregexMatcher = pattern.matcher(cliente.getCliente_cpf());
            if (!cpfregexMatcher.matches()) {
                throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
            }
        }

        DAOCliente dados = new DAOCliente();
        return dados.consultarClienteCpf(cliente);

    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        String nome_pattern = "(?<FirstName>[A-Z]\\.?\\w*\\-?[A-Z]?\\w*)\\s?(?<MiddleName>[A-Z]\\w*|[A-Z]?\\.?)\\s?(?<LastName>[A-Z]\\w*\\-?[A-Z]?\\w*)(?:,\\s|)(?<Suffix>Jr\\.|Sr\\.|IV|III|II|)";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Pattern pattern1 = Pattern.compile(nome_pattern);
        Matcher cpfregexMatcher = pattern.matcher(cliente.getCliente_cpf());
        Matcher nomeregexMatcher = pattern1.matcher(cliente.getCliente_nome());

        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }

        if (!nomeregexMatcher.matches()) {
            throw new Exception("Infomar o nome no seguinte formato : Victor Pierre Lima ( Sem Preposições )");
        }
        if (cliente.getCliente_endereco().trim().equals("") == true) {
            throw new Exception("informar o endereço corretamente!");
        }
        DAOCliente dados = new DAOCliente();
        dados.cadastrarCliente(cliente);
    }

    @Override
    public void removerCliente(Cliente cliente) throws Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        //^[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{2}$  (^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)
        Pattern pattern = Pattern.compile(cpf_pattern);
        Matcher cpfregexMatcher = pattern.matcher(cliente.getCliente_cpf());
        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }

        DAOCliente dados = new DAOCliente();
        dados.removerCliente(cliente);
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        String nome_pattern = "(?<FirstName>[A-Z]\\.?\\w*\\-?[A-Z]?\\w*)\\s?(?<MiddleName>[A-Z]\\w*|[A-Z]?\\.?)\\s?(?<LastName>[A-Z]\\w*\\-?[A-Z]?\\w*)(?:,\\s|)(?<Suffix>Jr\\.|Sr\\.|IV|III|II|)";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Pattern pattern1 = Pattern.compile(nome_pattern);
        Matcher cpfregexMatcher = pattern.matcher(cliente.getCliente_cpf());
        Matcher nomeregexMatcher = pattern1.matcher(cliente.getCliente_nome());

        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }

        if (!nomeregexMatcher.matches()) {
            throw new Exception("Infomar o nome no seguinte formato : Victor Pierre Lima");
        }
        if (cliente.getCliente_endereco().trim().equals("") == true) {
            throw new Exception("informar o endereço corretamente!");
        }
        if (cliente.getCliente_endereco().trim().equals("") == true) {
            throw new Exception("Infomar o endereço corretamente");
        }
        DAOCliente dados = new DAOCliente();
        dados.atualizarCliente(cliente);
    }

}
