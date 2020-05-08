/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psb;

/**
 *
 * @author Lynn
 */
public class UserSession {
    private static String u_id;
    private static String nama;
    private static String nisn;
    private static String namaSekolah;
    private static String jurusan;

    public static String getJurusan() {
        return jurusan;
    }

    public static void setJurusan(String jurusan) {
        UserSession.jurusan = jurusan;
    }
    
    

    public static String getNamaSekolah() {
        return namaSekolah;
    }

    public static void setNamaSekolah(String namaSekolah) {
        UserSession.namaSekolah = namaSekolah;
    }

    public static String getNisn() {
        return nisn;
    }

    public static void setNisn(String nisn) {
        UserSession.nisn = nisn;
    }
    

    public static  String getU_id() {
        return u_id;
    }

    public static void setU_id(String u_id) {
        UserSession.u_id = u_id;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        UserSession.nama = nama;
    }

 
    
    
}
