/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MbahGenius
 */
public class koneksi {
    private static Connection mysqlkoneksi;
    public static Connection koneksiDB() throws SQLException {
          if (mysqlkoneksi==null){
        new Driver();
           
        mysqlkoneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/tubes","root","");
        } return mysqlkoneksi;
    } 
    
}
