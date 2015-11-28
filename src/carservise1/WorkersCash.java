/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import static carservise1.MyConnection.connStr;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author permp_000
 */
public class WorkersCash {

    public float manyOfSlesar(String name) throws ClassNotFoundException, SQLException{
        
        GregorianCalendar calendar = new GregorianCalendar(Locale.ROOT);
        
        SimpleDateFormat date = new SimpleDateFormat("dd/M/yyyy");
        String ss = date.format(new Date());
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(connStr);
        String sql = "Select price FROM works WHERE master LIKE ? AND date LIKE ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, "%"+ss+"%");
        ResultSet result = statement.executeQuery();
        float resultEnd = 0;
        while(result.next()){
            float resultAll = result.getFloat("price");
            resultEnd = resultEnd + resultAll;
        }
        con.close();
        if(resultEnd>1000){
                resultEnd = (resultEnd/2-80);
                return resultEnd;
            }else{
                resultEnd = (resultEnd/2);
                return resultEnd;
            }
        
       
    }
    
    }
    
    
    

