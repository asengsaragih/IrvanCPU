package tubes;

import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    private static java.sql.Connection koneksi; 
    public static java.sql.Connection getKoneksi() throws SQLException {
        if (koneksi == null) {
            try {                              
                String db = "jdbc:mysql://localhost:3306/parkirdatabase";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(db, user, pass);
            }catch (SQLException e) {
                System.out.println("Koneksi Gagal!");
            }
        } return koneksi;
    }
}
