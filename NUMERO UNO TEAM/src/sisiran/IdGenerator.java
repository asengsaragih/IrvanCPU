/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisiran;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 *
 * @author Acer
 */
public class IdGenerator {
    private String prefix;
    private String table;

    public IdGenerator(String prefix, String table) {
        this.prefix = prefix;
        this.table = table;
    }
    
    public String generate() throws SQLException {
        int nomorUrut = 0;
        String hasil = "";
        Connection db = new Koneksi().configDB();
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_"+table+" FROM "+table+" ORDER BY id_"+table+" DESC LIMIT 1");
            rs.next();
            if (rs.getRow() > 0) {
                String id = rs.getString(1);
                nomorUrut = Integer.parseInt(substring(id, 3, 10));
                nomorUrut++;

                hasil = prefix + String.format("%07d", nomorUrut);
            } else {
                hasil = prefix+"0000001";
                
            }
        }catch(Exception e) {
            System.out.println("Id Generator error : "+e);
        }
        return hasil;
    }
}
