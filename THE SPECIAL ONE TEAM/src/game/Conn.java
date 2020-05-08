/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Huznul Abdi
 */
public class Conn {
    private static Connection mysqlkoneksi;
    public static Connection koneksiDB() throws SQLException { 
        if (mysqlkoneksi == null){
            try {
                
            String DB = "jdbc:mysql://localhost/quiz";
            String user = "root";
            String pass = "";
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           mysqlkoneksi = (Connection) DriverManager.getConnection(DB, user, pass);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "koneksi gagal");
        }
        }return mysqlkoneksi;
    }
}
