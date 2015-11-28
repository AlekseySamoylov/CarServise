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

/**
 *
 * @author permp_000
 */
public class PutMoney {

     public String putMany(float many, String other) throws ClassNotFoundException{
        try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection(connStr);
         String sql = "INSERT INTO many(many)VALUES(?);";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setFloat(1, many);
         statement.executeUpdate();
         
         String sql2 = "INSERT INTO works(price, other) VALUES (?,?);";
         PreparedStatement statement2 = con.prepareStatement(sql2);
         statement2.setFloat(1, many);
         statement2.setString(2, other);
         statement2.executeUpdate();
         
         con.close();
         return "All ok!";

        }catch(Exception ex){
           
            return "Wrong way!";
        }
        
     }
     
     
     public float getSumm() throws ClassNotFoundException, SQLException{
     Class.forName("com.mysql.jdbc.Driver"); 
     float summ = 0; 
     
     Connection conn = DriverManager.getConnection(connStr);
     String sql = "SELECT many FROM many;";
          
         PreparedStatement st = conn.prepareStatement(sql);
         
         ResultSet result = st.executeQuery();
     
         while(result.next()){
             summ  += result.getFloat("many");
          
         }
         return summ;
             
             
             
     }
}
