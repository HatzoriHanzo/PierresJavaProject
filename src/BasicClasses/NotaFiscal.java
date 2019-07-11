/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package BasicClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class NotaFiscal {
    private int nota_codigo;
    private Cliente cliente;
    private Vendedor vendedor;
    private Date data;
    private ArrayList<NotaFiscal_Produto> items;
    
    public NotaFiscal(){
       this.cliente  =  new Cliente();
       this.vendedor = new Vendedor();
       this.items = new ArrayList<NotaFiscal_Produto>();
       
        
    }
   
    /**
     * @return the nota_codigo
     */
    public int getNota_codigo() {
        return nota_codigo;
    }

    /**
     * @param nota_codigo the nota_codigo to set
     */
    public void setNota_codigo(int nota_codigo) {
        this.nota_codigo = nota_codigo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the items
     */
    public ArrayList<NotaFiscal_Produto> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<NotaFiscal_Produto> items) {
        this.items = items;
    }

    
}