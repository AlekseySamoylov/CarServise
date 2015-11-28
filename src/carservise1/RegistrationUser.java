/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import static carservise1.MyConnection.connStr;
import static carservise1.MyConnection.drvStr;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author permp_000
 */
public class RegistrationUser {
      public String registration(String name, String pass) throws SQLException, ClassNotFoundException, IOException{
          String question = name+pass;
          Class.forName(drvStr);
          Connection conn = DriverManager.getConnection(connStr);
          File account = new File("account.txt");
          
          if(account.exists()){
              System.out.println("Exist");
              FileReader reader = new FileReader(account);
              BufferedReader reader1 = new BufferedReader(reader);
            
              String answer = reader1.readLine();
              reader1.close();
              reader.close();
              if(question.equals(answer)){
                  
                      System.out.println(answer);
                      return "OK";
              }else{
                  return "NO";
              }
              
              
          }else{     
              System.out.println("No file");
              FileWriter writer = new FileWriter(account);
          BufferedWriter writer1 = new BufferedWriter(writer);
          writer.write(question);
          writer1.close();
          writer.close();
          
          return "OK";
              
              
              
             
          }
          
          
           
          
          
          
      }
}
