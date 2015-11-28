/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author permp_000
 */
public class GetDate {
  
    public String getDate(){
        SimpleDateFormat date = new SimpleDateFormat("kk:mm dd/M/yyyy");
            return date.format(new Date());
    }
}
