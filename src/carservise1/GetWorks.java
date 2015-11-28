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
import javafx.collections.ObservableList;

/**
 *
 * @author aleksei
 */


public class GetWorks {

    
    public ObservableList makeWork() throws ClassNotFoundException, SQLException{
        
        ObservableList<Work> listWork = null;
          Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connStr);
        String sql = "SELECT * FROM works;";
        PreparedStatement prepare = conn.prepareStatement(sql);
        ResultSet result = prepare.executeQuery();
        while(result.next()){
            String one = result.getString("master");
            String two = result.getString("date");
            String three = result.getString("client");
            String four = result.getString("tel");
            String five = result.getString("car");
            String six = result.getString("works");
            String seven = result.getString("price");
            String eight = result.getString("other");
            
            
            
            Work a = new Work(one,two, three, four, five, six, seven, eight);
            
            listWork.add(a);
            
           
        } 
        
        
        
        
        return listWork;
    }
    
    
    
    
    public ResultSet getTable() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connStr);
        String sql = "SELECT * FROM works;";
        PreparedStatement prepare = conn.prepareStatement(sql);
        ResultSet result = prepare.executeQuery();
        while(result.next()){
            String one = result.getString("car");
            
        }
        return result;
        
    }
    
}
