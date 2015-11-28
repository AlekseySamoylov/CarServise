/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import static carservise1.MyConnection.connStr;
import static carservise1.MyConnection.drvStr;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;


public class MessageArea {
    

      public void getMessage(String account, String message) throws ClassNotFoundException, SQLException{
          SimpleDateFormat time1 = new SimpleDateFormat("kk:mm dd/M/yyyy");
          String time = time1.format(new Date());
          
          Class.forName(drvStr);
         Connection conn = DriverManager.getConnection(connStr);
         String sql = "INSERT INTO messagelist(time, account, message) VALUES (?,?,?);";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1, time);
         statement.setString(2, account);
         statement.setString(3, ":  " + message);
         System.out.println(time + account+message);
         statement.executeUpdate();
         
         conn.close();

}
    
}
