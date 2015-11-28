/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;


import static carservise1.MyConnection.connStr;
import java.sql.*;

/**
 *
 * @author AlekseiSamoilov
 */
public class ConnSQL {
    

	public String connected(String master, String time, String client, String tel, String car, String works, float price, String other) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
                 String title = "Wrong!";
                Connection conn = DriverManager.getConnection(connStr);
                
               
                try{
                    String sql = "INSERT INTO works (master, date, client, tel, car, works, price, other) VALUES (?,?,?,?,?,?,?,?);";
                    String sql2 = "INSERT INTO many(many) VALUES (?);";
//                String sql = "INSERT INTO works (time) VALUES (?)";
               
                PreparedStatement stat = conn.prepareStatement(sql);
              
                stat.setString(1,master);
                stat.setString(2,time);
                stat.setString(3,client);
                stat.setString(4,tel);
                stat.setString(5,car);
                stat.setString(6,works);
                stat.setFloat(7,price);
                stat.setString(8,other);
                 PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat2.setFloat(1, price);
                //stat.setString(1,other);
                
                
                stat.executeUpdate();
                stat2.executeUpdate();
               // conn.commit();
//                ResultSet result = stat.executeQuery();
//                
//                while(result.next()){
//                    String res = result.getString("master");
//                 System.out.println(res);
//                 
//                }
 title = "All right!";
                return title;
                }catch(Exception ex){
                    System.out.println(ex);
                  // conn.rollback();
                    
                }finally{
                    conn.close();
                }
                
                
                

    return title;

}
}