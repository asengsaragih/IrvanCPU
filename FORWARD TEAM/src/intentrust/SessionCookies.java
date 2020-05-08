/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentrust;

/**
 *
 * @author Hisyam Fadhil
 */
public class SessionCookies {
    private static String idAdm , nmAdm;

    public static String getIdAdm() {
        return idAdm;
    }

    public static void setIdAdm(String idAdm) {
        SessionCookies.idAdm = idAdm;
    }

    public static String getNmAdm() {
        return nmAdm;
    }

    public static void setNmAdm(String nmAdm) {
        SessionCookies.nmAdm = nmAdm;
    }
    
}
