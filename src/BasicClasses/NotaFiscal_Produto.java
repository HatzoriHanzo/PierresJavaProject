/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicClasses;

/**
 *
 * @author Victor
 */
public class NotaFiscal_Produto {
    private int quantidade;
    private Produto produto;
    private NotaFiscal nota;
    private double preco;
    
    public NotaFiscal_Produto(){
        this.produto = new Produto();
        this.nota = new NotaFiscal();
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the nota
     */
    public NotaFiscal getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(NotaFiscal nota) {
        this.nota = nota;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

}