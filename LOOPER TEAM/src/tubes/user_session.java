/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author MbahGenius
 */
public class user_session {
    private static String u_id;
    private static String u_pw;
    private static String u_level;

    public user_session() {
    }

    public static String getU_id() {
        return u_id;
    }

    public static void setU_id(String u_id) {
        user_session.u_id = u_id;
    }

    public static String getU_pw() {
        return u_pw;
    }

    public static void setU_pw(String u_pw) {
        user_session.u_pw = u_pw;
    }

    public static String getU_level() {
        return u_level;
    }

    public static void setU_level(String u_level) {
        user_session.u_level = u_level;
    }
    
    
    
}
