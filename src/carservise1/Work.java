/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleksei
 */
public class Work  implements Serializable
{
    
    static String masterB;
    static String timeB;
    static String clientB;
    static String telB;
    static String carB;
    static String worksB;
    static String priceB;
    static String otherB;
    static LocalDate ld;
    
    public Work(){}
    
    public Work(String masterB, String timeB, String clientB, String telB, String carB, String worksB, String priceB, String otherB){
       
       // List listWorks<Sting> = new ArrayList<String>();
        
        
        this.masterB = masterB;
        this.timeB = timeB;
        this.clientB = clientB;
        this.telB = telB;
        this.carB = carB;
        this.worksB = worksB;
        this.priceB = priceB;
        this.otherB = otherB;
        
    }
    
    public void obj(String masterB, String timeB, String clientB, String telB, String carB, String priceB, String otherB){
        this.masterB = masterB;
        this.timeB = timeB;
        this.clientB = clientB;
        this.telB = telB;
        this.carB = carB;
        this.priceB = priceB;
        this.otherB = otherB;
        
    }
    }