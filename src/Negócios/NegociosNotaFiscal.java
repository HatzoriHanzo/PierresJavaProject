/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negócios;

import BasicClasses.NotaFiscal;
import BasicClasses.NotaFiscal_Produto;
import BasicClasses.Produto;
import BasicClasses.Utilidade;
import DataBank.DAOCliente;
import DataBank.DAONotaFiscal;
import DataBank.DAOProduto;
import DataBank.DAOVendedor;
import Interfaces.InterfaceNotaFiscal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Victor
 */
public class NegociosNotaFiscal implements InterfaceNotaFiscal {

    @Override
    public void cadastrarNotaf(NotaFiscal notaf) throws SQLException, Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        String data_pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Pattern pattern1 = Pattern.compile(data_pattern);
        Matcher cpfregexMatcher = pattern.matcher(notaf.getCliente().getCliente_cpf());
        Matcher dataregexMatcher = pattern1.matcher(Utilidade.parseString(notaf.getData()));
        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }
        if (!dataregexMatcher.matches()) {
            throw new Exception("Insira uma data no formato : 4/1/2001  ou 12/12/2001 ");
        }
        DAOVendedor daovnd = new DAOVendedor();
        if (daovnd.consultar(notaf.getVendedor()).isEmpty()) {
            throw new Exception("Vendedor informado não está cadastrado!");
        }
        DAOCliente daoclnt = new DAOCliente();
        if (daoclnt.consultarClienteCpf(notaf.getCliente()).isEmpty()) {
            throw new Exception ("Cliente informado não cadastrado!");
        }
        DAONotaFiscal dadosnt = new DAONotaFiscal();
        dadosnt.cadastrarNotaf(notaf);
        
    }

    @Override
    public void removerNotaFiscal(NotaFiscal notaf) throws SQLException, Exception {
        if (notaf.getNota_codigo() <= 0) {
            throw new Exception("Código tem que ser acima de zero!");
        }
        DAONotaFiscal dadosnt = new DAONotaFiscal();
        dadosnt.removerNotaFiscal(notaf);
        
    }

    @Override
    public void atualizarNotaFiscal(NotaFiscal notaf) throws SQLException, Exception {
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        String data_pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
        Pattern pattern = Pattern.compile(cpf_pattern);
        Pattern pattern1 = Pattern.compile(data_pattern);
        Matcher cpfregexMatcher = pattern.matcher(notaf.getCliente().getCliente_cpf());
        Matcher dataregexMatcher = pattern1.matcher(Utilidade.parseString(notaf.getData()));
        if (!cpfregexMatcher.matches()) {
            throw new Exception("Insira um cpf no seguinte formato 111.111.111-11 ou 11111111111");
        }
        if (!dataregexMatcher.matches()) {
            throw new Exception("Insira uma data no formato : 4/1/2001  ou 12/12/2001 ");
        }
        DAOVendedor daovnd = new DAOVendedor();
        if (daovnd.consultar(notaf.getVendedor()).isEmpty()) {
            throw new Exception("Vendedor informado não está cadastrado!");
        }
        DAOCliente daoclnt = new DAOCliente();
        if (daoclnt.consultarClienteCpf(notaf.getCliente()).isEmpty()) {
            throw new Exception ("Cliente informado não cadastrado!");
        }
        DAONotaFiscal dadosnt = new DAONotaFiscal();
        dadosnt.atualizarNotaFiscal(notaf);
    }

    @Override
    public ArrayList<NotaFiscal> consultar(NotaFiscal notaf) throws SQLException, Exception {
        if (notaf.getNota_codigo() <=0){
             throw new Exception ("Insira um código maior que zero!");

        }
        DAONotaFiscal dadosnt = new DAONotaFiscal();
        return dadosnt.consultar(notaf);
           
    }
    public boolean verificarProduto(NotaFiscal_Produto notfisprodt) throws Exception ,SQLException {
    DAOProduto daoprof = new DAOProduto();
    
        return daoprof.consultar(notfisprodt).isEmpty();
    
}

}
