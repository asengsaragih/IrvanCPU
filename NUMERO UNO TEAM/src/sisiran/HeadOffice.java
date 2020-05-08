/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisiran;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author IRREGULER
 */
public class HeadOffice extends javax.swing.JFrame {

    /**
     * Creates new form HeadOffice
     */
    Connection db;
    public HeadOffice() throws SQLException {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        
        db = new Koneksi().configDB();
        
        generateId();
    }
    
    private void generateId() throws SQLException {
        String idMenu = new IdGenerator("MNU","menu").generate();
        idproduk.setText(idMenu);
        
        String kodeVoucher = new IdGenerator("VCR","voucher").generate();
        kodevoucher.setText(kodeVoucher);
        // menampilkan produk pada combobox stok
        tampilProduk();
    }
    
    private void tampilProduk() {
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu ORDER BY nama");
            while(rs.next()){
                namastokproduk.addItem(rs.getString("nama")+"-"+rs.getString("id_menu"));
            }
        } catch (Exception e) {
        }
    }
    
    private void kosongkanForm() throws SQLException {
        // mengosongkan form produk
        idproduk.setText("");
        namaproduk.setText("");
        jenisproduk.setSelectedIndex(0);
        hargaproduk.setText("");
        
        // mengosongkan form stok
        namastokproduk.setSelectedIndex(0);
        stokproduk.setText("");
        
        // mengosongkan form voucher
        stokvoucher.setText("");
        potongan.setText("");
        
        // generate Id terbaru
        generateId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputdata = new javax.swing.JLabel();
        datatransaksi = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        tambahproduk = new javax.swing.JLabel();
        tambahvoucher = new javax.swing.JLabel();
        tambahstok = new javax.swing.JLabel();
        dataproduk = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idproduk = new javax.swing.JTextField();
        namaproduk = new javax.swing.JTextField();
        hargaproduk = new javax.swing.JTextField();
        jenisproduk = new javax.swing.JComboBox<>();
        namastokproduk = new javax.swing.JComboBox<>();
        kodevoucher = new javax.swing.JTextField();
        stokvoucher = new javax.swing.JTextField();
        potongan = new javax.swing.JTextField();
        stokproduk = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        inputdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(inputdata);
        inputdata.setBounds(40, 30, 175, 28);

        datatransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datatransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatransaksiMouseClicked(evt);
            }
        });
        getContentPane().add(datatransaksi);
        datatransaksi.setBounds(40, 80, 180, 20);

        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(150, 270, 60, 20);

        tambahproduk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahprodukMouseClicked(evt);
            }
        });
        getContentPane().add(tambahproduk);
        tambahproduk.setBounds(290, 270, 80, 25);

        tambahvoucher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahvoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahvoucherMouseClicked(evt);
            }
        });
        getContentPane().add(tambahvoucher);
        tambahvoucher.setBounds(290, 543, 80, 25);

        tambahstok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahstok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahstokMouseClicked(evt);
            }
        });
        getContentPane().add(tambahstok);
        tambahstok.setBounds(640, 365, 88, 25);

        dataproduk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataprodukMouseClicked(evt);
            }
        });
        getContentPane().add(dataproduk);
        dataproduk.setBounds(40, 125, 180, 25);

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 175, 180, 20);

        idproduk.setBorder(null);
        idproduk.setEnabled(false);
        getContentPane().add(idproduk);
        idproduk.setBounds(479, 80, 125, 20);

        namaproduk.setBorder(null);
        getContentPane().add(namaproduk);
        namaproduk.setBounds(480, 130, 125, 20);

        hargaproduk.setBorder(null);
        getContentPane().add(hargaproduk);
        hargaproduk.setBounds(480, 225, 125, 20);

        jenisproduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman" }));
        jenisproduk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jenisproduk);
        jenisproduk.setBounds(470, 173, 145, 30);

        getContentPane().add(namastokproduk);
        namastokproduk.setBounds(825, 260, 143, 30);

        kodevoucher.setBorder(null);
        kodevoucher.setEnabled(false);
        getContentPane().add(kodevoucher);
        kodevoucher.setBounds(480, 390, 123, 25);

        stokvoucher.setBorder(null);
        getContentPane().add(stokvoucher);
        stokvoucher.setBounds(480, 441, 123, 23);

        potongan.setBorder(null);
        getContentPane().add(potongan);
        potongan.setBounds(480, 491, 123, 23);

        stokproduk.setBorder(null);
        getContentPane().add(stokproduk);
        stokproduk.setBounds(835, 312, 123, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Desain Head Office.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void datatransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatransaksiMouseClicked
        this.dispose();
        try {
            new DataTransaksi().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HeadOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datatransaksiMouseClicked

    private void dataprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataprodukMouseClicked
        this.dispose();
        try {
            new DataProduk().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HeadOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dataprodukMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        try {
            new DataVoucher().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HeadOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tambahprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahprodukMouseClicked
        String idMenu = idproduk.getText();
        String nama = namaproduk.getText();
        String jenis = jenisproduk.getSelectedItem().toString();
        
        try {
            int harga = Integer.parseInt(hargaproduk.getText());
            try {
                Statement stmt = db.createStatement();
                stmt.execute("INSERT INTO menu(id_menu, nama, harga, jenis, stok) VALUES"
                        + "('"+idMenu+"','"+nama+"','"+harga+"','"+jenis+"',0)");
                JOptionPane.showMessageDialog(this, "Data Produk berhasil ditambahkan!");
                kosongkanForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan : "+e.getLocalizedMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harap isi harga dengan angka!");
        }
    }//GEN-LAST:event_tambahprodukMouseClicked

    private void tambahstokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahstokMouseClicked
        String selectedMenu = namastokproduk.getSelectedItem().toString();
        String [] menu = selectedMenu.split("-");
        String idMenu = menu[1];
        try {
            int stok = Integer.parseInt(stokproduk.getText());
            try {
                Statement stmt = db.createStatement();
                stmt.execute("UPDATE menu SET stok=stok+"+stok+" WHERE id_menu='"+idMenu+"'");
                JOptionPane.showMessageDialog(this, "Stok berhasil ditambahkan!");
                kosongkanForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan : "+e.getLocalizedMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harap masukan angka pada kolom stok");
        }
    }//GEN-LAST:event_tambahstokMouseClicked

    private void tambahvoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahvoucherMouseClicked
        String idvoucher = kodevoucher.getText();
        try {
            int stok = Integer.parseInt(stokvoucher.getText());
            int discount = Integer.parseInt(potongan.getText());
            try {
                Statement stmt = db.createStatement();
                stmt.execute("INSERT INTO voucher(id_voucher, stok_voucher, potongan) VALUES"
                        + "('"+idvoucher+"',"+stok+","+discount+")");
                JOptionPane.showMessageDialog(this, "Data voucher berhasil ditambahkan!");
                kosongkanForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan : "+e.getLocalizedMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harap isi stok / potongan dengan angka!");
        }
    }//GEN-LAST:event_tambahvoucherMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Cookies.destroy();
        new Welcome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(HeadOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeadOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeadOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeadOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HeadOffice().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HeadOffice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dataproduk;
    private javax.swing.JLabel datatransaksi;
    private javax.swing.JTextField hargaproduk;
    private javax.swing.JTextField idproduk;
    private javax.swing.JLabel inputdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jenisproduk;
    private javax.swing.JTextField kodevoucher;
    private javax.swing.JLabel logout;
    private javax.swing.JTextField namaproduk;
    private javax.swing.JComboBox<String> namastokproduk;
    private javax.swing.JTextField potongan;
    private javax.swing.JTextField stokproduk;
    private javax.swing.JTextField stokvoucher;
    private javax.swing.JLabel tambahproduk;
    private javax.swing.JLabel tambahstok;
    private javax.swing.JLabel tambahvoucher;
    // End of variables declaration//GEN-END:variables
}