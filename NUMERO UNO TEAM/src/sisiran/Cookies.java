/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisiran;


/**
 *
 * @author Acer
 */
public class Cookies {
    private static String id;
    private static String nama;
    private static int role;
    private static Boolean status = false;
    
    public static void create(String newId, String newNama, int newRole) {
        id = newId;
        nama = newNama;
        role = newRole;
        status = true;
    }
    
    public static void destroy() {
        id = null;
        nama = null;
        role = 0;
        status = false;
    }
    
    public static Boolean status() {
        return status;
    }

    public static String getId() {
        return id;
    }

    public static String getNama() {
        return nama;
    }

    public static int getRole() {
        return role;
    }
    
    
}
