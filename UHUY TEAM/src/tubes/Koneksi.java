/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Iski
 */
public class Koneksi {
    Connection con;
    
    public Connection Connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/layananspp","root", "");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
        return con;
        
    }
}
