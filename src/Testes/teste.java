/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aluno
 */
public class teste {
    public static void main(String[] ars){
        String cpf_pattern = "(^(\\d{3}.\\d{3}.\\d{3}-\\d{2})|(\\d{11})$)";
        //^[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{2}$  (^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)
        Pattern pattern = Pattern.compile(cpf_pattern);
        Matcher cpfregexMatcher = pattern.matcher("111.111.111-22");
        if (cpfregexMatcher.matches() == true) {
            System.out.println("cpf válido!");
        }
        else {
            System.out.println("invalido");
        }
    }
}
