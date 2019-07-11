/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicClasses;

import Negócios.NegociosNotaFiscal;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class NewClass {
    public static void main(String[] args){
        
        try {
            NegociosNotaFiscal notafneg = new NegociosNotaFiscal();
            NotaFiscal notaf = new NotaFiscal();
            notaf.getVendedor().setVend_codigo(1);
            notafneg.cadastrarNotaf(notaf);
            notaf.setNota_codigo(-05);
            notafneg.removerNotaFiscal(notaf);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
   
}
