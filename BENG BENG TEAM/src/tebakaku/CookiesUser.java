/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tebakaku;

/**
 *
 * @author Layat
 */
public class CookiesUser {
    private static String namaUser;
    private static int skorTebakAku,skorTebakGambar,skorTebakAngka;

    public static String getNamaUser() {
        return namaUser;
    }

    public static void setNamaUser(String namaUser) {
        CookiesUser.namaUser = namaUser;
    }

    public static int getSkorTebakAku() {
        return skorTebakAku;
    }

    public static void setSkorTebakAku(int skorTebakAku) {
        CookiesUser.skorTebakAku = skorTebakAku;
    }

    public static int getSkorTebakGambar() {
        return skorTebakGambar;
    }

    public static void setSkorTebakGambar(int skorTebakGambar) {
        CookiesUser.skorTebakGambar = skorTebakGambar;
    }

    public static int getSkorTebakAngka() {
        return skorTebakAngka;
    }

    public static void setSkorTebakAngka(int skorTebakAngka) {
        CookiesUser.skorTebakAngka = skorTebakAngka;
    }
}
