/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Utilidade {
    public static Date parseDate(String data) throws ParseException{
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
        sdf1.setLenient(false);
        return sdf1.parse(data);
}
public static String parseString(Date data) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    sdf.setLenient(false);
    return sdf.format(data);
}
public static java.sql.Date getSqlDate(Date data){
    return new java.sql.Date(data.getTime());
}
}
