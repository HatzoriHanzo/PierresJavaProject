/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicClasses;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Cliente {

    private String cliente_cpf;
    private String cliente_nome;
    private String cliente_endereco;
    private ArrayList<NotaFiscal> nota;

    /**
     * @return the cliente_cpf
     */
    public String getCliente_cpf() {
        return cliente_cpf;
    }

    /**
     * @param cliente_cpf the cliente_cpf to set
     */
    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    /**
     * @return the cliente_nome
     */
    public String getCliente_nome() {
        return cliente_nome;
    }

    /**
     * @param cliente_nome the cliente_nome to set
     */
    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    /**
     * @return the cliente_endereco
     */
    public String getCliente_endereco() {
        return cliente_endereco;
    }

    /**
     * @param cliente_endereco the cliente_endereco to set
     */
    public void setCliente_endereco(String cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    /**
     * @return the nota
     */
    public ArrayList<NotaFiscal> getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(ArrayList<NotaFiscal> nota) {
        this.nota = nota;
    }

}
