/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author Acer
 */
class Cookies {
    private static int idUser;
    private static String nama;
    private static String alamat;
    private static int role;
    private static String notelp;
    private static Boolean status = false;
    
    public static void create(int newId,  String newNama, String newAlamat, String newNotelp) {
        idUser = newId;
        alamat = newAlamat;
        nama = newNama;
        
        notelp = newNotelp;
        status = true;
    }

    public static String getNotelp() {
        return notelp;
    }

    public static void setNotelp(String notelp) {
        Cookies.notelp = notelp;
    }
    

    
    public static void destroy() {
        idUser = 0;
        nama = null;
        alamat = null;
        role = 0;
        status = false;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Cookies.idUser = idUser;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Cookies.nama = nama;
    }

    public static String getAlamat() {
        return alamat;
    }

    public static void setAlamat(String alamat) {
        Cookies.alamat = alamat;
    }

    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        Cookies.role = role;
    }

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        Cookies.status = status;
    }

    }
    
    
    
    

