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
import java.util.HashMap;

/**
 *
 * @author permp_000
 */
public class SaveClientStage {
    public void saveClient(String client, String tel, String car, String stage, String other) throws SQLException, ClassNotFoundException{
       GetDate md = new GetDate();
        String date = md.getDate();
        Class.forName(drvStr);
    Connection conn = DriverManager.getConnection(connStr);
    String sql = "INCERT INTO savedclients (date, client, tel, car, stage, other) VALUES (?,?,?,?,?);";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, date);
statement.setString(2, client);
statement.setString(3, tel);
statement.setString(4, car);
statement.setString(5, stage);
statement.setString(6, other);
statement.executeUpdate();
conn.close();
    }
    
     static String all2 = "";
      
      public String getClientList() throws ClassNotFoundException, SQLException
      {
          Class.forName(drvStr);
          Connection conn = DriverManager.getConnection(connStr);
          String sql = "SELECT * FROM stagelistt;";
          PreparedStatement prepared = conn.prepareStatement(sql);
          ResultSet result = prepared.executeQuery();
          HashMap<Integer, String> map = new HashMap<>();
          String all2 = "";
          while(result.next()){
              int id = result.getInt("id");
              String client = result.getString("client");
              String car = result.getString("car");
              String tel = result.getString("tel");
              
              
              
              String all = client + " | " + car + ":  " + tel + "\n";
              
              all2 = all + all2;
              map.put(id, all2);
             
              
          }
          conn.close();
              return all2;    
    
    
      }
}
