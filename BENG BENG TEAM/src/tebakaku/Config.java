/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tebakaku;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Febby Dahlan
 */
public class Config {
    private static Connection mysqlConnect;
    public static Connection databaseConnection()
    {
        if(mysqlConnect == null)
        {
            try
            {
                String database = "jdbc:mysql://localhost/tebak-aku";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlConnect = DriverManager.getConnection(database,user,pass);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Failed to Connect Database");
            }
        }
        return mysqlConnect;
    }
}
