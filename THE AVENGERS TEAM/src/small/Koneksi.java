/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package small;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author yulio
 */
public class Koneksi {
    private static Connection mysqlkoneksi;
    public static Connection koneksiDB() throws SQLException{
        if (mysqlkoneksi==null) {
            try{
                String DB="jdbc:mysql://localhost:3306/small";
                String user="root";
                String pass="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkoneksi = (Connection) DriverManager.getConnection(DB,user,pass);
            }catch (Exception c){
                JOptionPane.showMessageDialog(null, "koneksi gagal");
            }
           
        }
         return mysqlkoneksi;
    }
    
}
