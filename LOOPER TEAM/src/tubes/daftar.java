/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.*;
import java.util.*;
import java.sql.*;
import javax.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MbahGenius
 */
public class daftar extends javax.swing.JFrame {

    /**
     * Creates new form daftar
     */
    private Connection db;
    public daftar() throws SQLException {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        ImageIcon settingImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Sign Up.png")));
        Image login = settingImage.getImage();
        Image imageScaled = login.getScaledInstance(lb_daftar.getWidth(), lb_daftar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon settingsImage = new ImageIcon(imageScaled);
        lb_daftar.setIcon(settingsImage);
        
         this.bt_daftar.setFont(new Font("Forte", Font.PLAIN, 33)); 
        this.bt_daftar.setForeground(Color.YELLOW);
        this.bt_daftar.setOpaque(false);
        this.bt_daftar.setContentAreaFilled(false);
        this.bt_daftar.setBorderPainted(false);
        this.bt_daftar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
         this.bt_login.setFont(new Font("Forte", Font.PLAIN, 33)); 
        this.bt_login.setForeground(Color.YELLOW);
        this.bt_login.setOpaque(false);
        this.bt_login.setContentAreaFilled(false);
        this.bt_login.setBorderPainted(false);
        this.bt_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        fd_id.setOpaque(false);
        fd_id.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        fd_nama.setOpaque(false);
        fd_nama.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        fd_pw.setOpaque(false);
        fd_pw.setBackground(new java.awt.Color(255, 255, 255, 0));
        
        db = (Connection) koneksi.koneksiDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_login = new javax.swing.JButton();
        bt_daftar = new javax.swing.JButton();
        fd_nama = new javax.swing.JTextField();
        fd_id = new javax.swing.JTextField();
        fd_pw = new javax.swing.JPasswordField();
        lb_daftar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_login.setLabel("");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 240, 60));

        bt_daftar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_daftar.setLabel("");
        bt_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_daftarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 250, 60));

        fd_nama.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fd_nama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(fd_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 430, 70));

        fd_id.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fd_id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(fd_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 430, 70));

        fd_pw.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fd_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(fd_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 430, 70));

        lb_daftar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lb_daftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/Sign Up.png"))); // NOI18N
        getContentPane().add(lb_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_daftarActionPerformed
        // TODO add your handling code here:
        String id = fd_id.getText();
        String pw = fd_pw.getText();
        String nama= fd_nama.getText();
        String u_id = null,u_pw = null, u_level = null;
        try {
             Statement tsql = db.createStatement();
             
            tsql.execute("insert into user(id_user,pw_user,nama_user,jabatan_user,status_user,level) values"
                    + "('" + id + "','" + pw + "','" + nama+ "','" + "mahasiswa','sudah', 'peminjam')");
            
            JOptionPane.showMessageDialog(this, "Data peminjaman berhasil ditambah");
            
                    user_session.setU_id(u_id);
                    user_session.setU_pw(u_pw);
                    user_session.setU_level(u_level);
            fd_id.setText("");
            fd_pw.setText("");
            fd_nama.setText("");
            
            menu_peminjam pm = new menu_peminjam();
            pm.show();
            this.dispose();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
           
        }
    }//GEN-LAST:event_bt_daftarActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
       login log = null;
        try {
            log = new login();
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
       log.show();
       this.dispose();
    }//GEN-LAST:event_bt_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new daftar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_daftar;
    private javax.swing.JButton bt_login;
    private javax.swing.JTextField fd_id;
    private javax.swing.JTextField fd_nama;
    private javax.swing.JPasswordField fd_pw;
    private javax.swing.JLabel lb_daftar;
    // End of variables declaration//GEN-END:variables
}