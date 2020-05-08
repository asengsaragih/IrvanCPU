/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentrust;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Hisyam Fadhil
 */
public class config {
    private static Connection mysqlconfig;
    private static com.mysql.jdbc.Connection mysqlkoneksi;
    public static com.mysql.jdbc.Connection koneksiDB() throws SQLException {
        if (mysqlkoneksi == null) {
            try {
                String DB = "jdbc:mysql://localhost/db_inventrust";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkoneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB, user, pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            }
        } return mysqlkoneksi;
    }    
}
