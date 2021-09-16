/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subhojit.attendance.biometric;
/**
 *
 * @author Hyrex
 */
import java.sql.*;
import javax.swing.*;
public class db {

    Connection conn=null;
    public static Connection java_db(){
        
        try{
            //Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:mysql://localhost:3306/std";
            //Connection conn = null; 
            Connection conn =DriverManager.getConnection(dbURL, "root", "");;
            //JOptionPane.showMessageDialog(null, "Connection to database is successful");
      
            return conn;
           
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}