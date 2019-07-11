/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negócios;

import BasicClasses.Vendedor;
import DataBank.DAOVendedor;
import Interfaces.InterfaceVendedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Victor
 */
public class NegociosVendedor implements InterfaceVendedor {

    @Override
    public ArrayList<Vendedor> consultar(Vendedor vendedor) throws SQLException, Exception {
        if (vendedor.getVendedor_cpf() != null && vendedor.getVendedor_cpf().trim().equals("") == false) {
            String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
            Pattern pattern = Pattern.compile(cpf_pattern);
            Matcher cpfregexMatcher = pattern.matcher(vendedor.getVendedor_cpf());
            if (!cpfregexMatcher.matches()) {
                throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
            }

        }

        DAOVendedor dados = new DAOVendedor();
        return dados.consultar(vendedor);
    }

    @Override
    public void cadastrar(Vendedor vendedor) throws SQLException, Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        String nome_pattern = "^[A-Z][a-z]+([ ][A-Z][a-z]+)*$";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Pattern pattern1 = Pattern.compile(nome_pattern);
        Matcher cpfregexMatcher = pattern.matcher(vendedor.getVendedor_cpf());
        Matcher nomeregexMatcher = pattern1.matcher(vendedor.getVendedor_nome());

        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }

        if (!nomeregexMatcher.matches()) {
            throw new Exception("Infomar o nome no seguinte formato : Victor Pierre Lima ( Sem Preposições )");
        }

        DAOVendedor dados = new DAOVendedor();
        dados.cadastrar(vendedor);

    }

    @Override
    public void remover(Vendedor vendedor) throws SQLException, Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Matcher cpfregexMatcher = pattern.matcher(vendedor.getVendedor_cpf());
        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }
        DAOVendedor dados = new DAOVendedor();
        dados.remover(vendedor);
    }

    @Override
    public void atualizar(Vendedor vendedor) throws SQLException, Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        String nome_pattern = "(?<FirstName>[A-Z]\\.?\\w*\\-?[A-Z]?\\w*)\\s?(?<MiddleName>[A-Z]\\w*|[A-Z]?\\.?)\\s?(?<LastName>[A-Z]\\w*\\-?[A-Z]?\\w*)(?:,\\s|)(?<Suffix>Jr\\.|Sr\\.|IV|III|II|)";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Pattern pattern1 = Pattern.compile(nome_pattern);
        Matcher cpfregexMatcher = pattern.matcher(vendedor.getVendedor_cpf());
        Matcher nomeregexMatcher = pattern1.matcher(vendedor.getVendedor_nome());

        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }

        if (!nomeregexMatcher.matches()) {
            throw new Exception("Infomar o nome no seguinte formato : Victor Pierre Lima");
        }

        DAOVendedor dados = new DAOVendedor();
        dados.atualizar(vendedor);
    }

}
