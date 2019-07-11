
package BasicClasses;

import java.util.ArrayList;


public class Vendedor {
    private int vend_codigo;
    private String vendedor_nome;
    private String vendedor_cpf;
    private ArrayList<NotaFiscal> nota;

    /**
     * @return the vend_codigo
     */
    public int getVend_codigo() {
        return vend_codigo;
    }

    /**
     * @param vend_codigo the vend_codigo to set
     */
    public void setVend_codigo(int vend_codigo) {
        this.vend_codigo = vend_codigo;
    }

    /**
     * @return the vendedor_nome
     */
    public String getVendedor_nome() {
        return vendedor_nome;
    }

    /**
     * @param vendedor_nome the vendedor_nome to set
     */
    public void setVendedor_nome(String vendedor_nome) {
        this.vendedor_nome = vendedor_nome;
    }

    /**
     * @return the vendedor_cpf
     */
    public String getVendedor_cpf() {
        return vendedor_cpf;
    }

    /**
     * @param vendedor_cpf the vendedor_cpf to set
     */
    public void setVendedor_cpf(String vendedor_cpf) {
        this.vendedor_cpf = vendedor_cpf;
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
