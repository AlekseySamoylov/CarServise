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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author permp_000
 */
public class ChatArea {
 
      static String all2 = "";
      
      public String getMessageList() throws ClassNotFoundException, SQLException
      {
          Class.forName(drvStr);
          Connection conn = DriverManager.getConnection(connStr);
          String sql = "SELECT * FROM messagelist;";
          PreparedStatement prepared = conn.prepareStatement(sql);
          ResultSet result = prepared.executeQuery();
          
          String all2 = "";
          while(result.next()){
              
              String date = result.getString("time");
              String name = result.getString("account");
              String message = result.getString("message");
              String all = date + " | " + name + ":  " + message + "\n";
              
              all2 = all + all2;
             
              
          }
          conn.close();
              return all2;    
          
      }
    
    
}
