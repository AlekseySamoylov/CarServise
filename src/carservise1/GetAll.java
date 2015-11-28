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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author permp_000
 */
public class GetAll {

    public ObservableList getAll() throws ClassNotFoundException, SQLException{
        Class.forName(drvStr);
        Connection conn = DriverManager.getConnection(connStr);
        String sql = "SELECT * FROM works";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        ResultSet result = statement.executeQuery();
        
        ObservableList<String> listCash = FXCollections.observableArrayList();
        while(result.next()){
            String all;
            int id = result.getInt("id");
            System.out.println(id);
            String date = result.getString("date");
             System.out.println(date);
            float many = result.getFloat("price");
            String other = result.getString("other");
            String master = result.getString("master");
            String works = result.getString("works");
            String car = result.getString("car");
            String client = result.getString("client");
            String tel = result.getString("tel");
            
            all = id + " " + date + " " + many + " " + other + " " + master + " " + works + " " + car  + " " + client + " " + tel;
            listCash.add(all);
        }
        
        conn.close();
        return listCash;
    }
    
}
