/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

/**
 *
 * @author User
 */
public class koneksi {
    private static Connection koneksi;
    
    public static Connection getConnection() throws SQLException{
        if(koneksi == null){
            new Driver();
            
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/cr", "root","");
            
        }
        return koneksi;
    }
}

    

