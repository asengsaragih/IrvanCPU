/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lynn
 */
public class InputNilaiPenyeleksian extends javax.swing.JFrame {
    private Connection dbConnection;
    private koneksi db = new koneksi();
    /**
     * Creates new form InputNilaiPenyeleksian
     */
    public InputNilaiPenyeleksian() {
        initComponents();
        load_comboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIpa = new javax.swing.JButton();
        txtBahasaIpa = new javax.swing.JTextField();
        txtInggrisIpa = new javax.swing.JTextField();
        txtIpaIpa = new javax.swing.JTextField();
        txtMatematikaIpa = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBahasaIPS = new javax.swing.JTextField();
        txtInggrisIps = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIpaIps = new javax.swing.JTextField();
        txtiMatematikaIps = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Simpan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtBahasaBahasa = new javax.swing.JTextField();
        txtInggrisBahasa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtIpaBahasa = new javax.swing.JTextField();
        txtiMatematikaBahasa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnSimpanBahasa = new javax.swing.JButton();
        cboTA = new javax.swing.JComboBox();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tahun Ajaran");

        jLabel2.setText("Nilai Bahasa");

        jLabel3.setText("Nilai Inggris");

        jLabel4.setText("Nilai IPA");

        jLabel5.setText("Nilai Matematika ");

        btnIpa.setText("Simpan");
        btnIpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIpaActionPerformed(evt);
            }
        });

        btnKembali.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(0, 114, 178));
        btnKembali.setText("Kembali");
        btnKembali.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnKembali.setBorderPainted(false);
        btnKembali.setContentAreaFilled(false);
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBahasaIpa)
                            .addComponent(txtInggrisIpa)
                            .addComponent(txtIpaIpa)
                            .addComponent(txtMatematikaIpa, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIpa)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBahasaIpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInggrisIpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIpaIpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatematikaIpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIpa)
                    .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("IPA", jPanel1);

        jLabel10.setText("Nilai Bahasa");

        txtInggrisIps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInggrisIpsActionPerformed(evt);
            }
        });

        jLabel11.setText("Nilai Inggris");

        jLabel12.setText("Nilai IPA");

        jLabel13.setText("Nilai Matematika ");

        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBahasaIPS)
                            .addComponent(txtInggrisIps)
                            .addComponent(txtIpaIps)
                            .addComponent(txtiMatematikaIps, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Simpan)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBahasaIPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtInggrisIps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtIpaIps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtiMatematikaIps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(Simpan)
                .addContainerGap())
        );

        jTabbedPane1.addTab("IPS", jPanel2);

        jLabel14.setText("Nilai Bahasa");

        txtInggrisBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInggrisBahasaActionPerformed(evt);
            }
        });

        jLabel15.setText("Nilai Inggris");

        jLabel16.setText("Nilai IPA");

        jLabel17.setText("Nilai Matematika ");

        btnSimpanBahasa.setText("Simpan");
        btnSimpanBahasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanBahasaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBahasaBahasa)
                            .addComponent(txtInggrisBahasa)
                            .addComponent(txtIpaBahasa)
                            .addComponent(txtiMatematikaBahasa, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpanBahasa)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtBahasaBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtInggrisBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtIpaBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtiMatematikaBahasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnSimpanBahasa)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bahasa", jPanel4);

        cboTA.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        cboTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTA, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void load_comboBox(){
        int x = 2018; int y =2019; int loop = 1;
         
        cboTA.addItem("2018 / 2019");
        cboTA.addItem("2019 / 2020");
        cboTA.addItem("2020 / 2021");
        cboTA.addItem("2021 / 2022");
        
        
    }
    private void cboTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTAActionPerformed

    }//GEN-LAST:event_cboTAActionPerformed

    private void txtInggrisIpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInggrisIpsActionPerformed
        
    }//GEN-LAST:event_txtInggrisIpsActionPerformed

    private void txtInggrisBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInggrisBahasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInggrisBahasaActionPerformed
    
    
    private void btnIpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIpaActionPerformed
        db.dbConnection();
        String BahasaIpa = txtBahasaIpa.getText();
        String InggrisIpa = txtInggrisIpa.getText();
        String MatematikaIpa = txtMatematikaIpa.getText();
        String IpaIpa = txtIpaIpa.getText();
        String jurusan = "ipa";
        
        
        
         try{
             String cekSql = "SELECT jurusan, tahunAjaran from nilai_minimal_ipa WHERE jurusan = '"+ jurusan +"' AND tahunAjaran = '"+cboTA.getSelectedItem()+"'";
             Statement stCek = db.getConnection().createStatement();
             ResultSet rsCek = stCek.executeQuery(cekSql);
             
             rsCek.last(); //mengecek jumlah baris pada hasil query   
             if (rsCek.getRow() == 0 ) {
                  String sql = "INSERT INTO nilai_minimal_ipa (id_user,tahunAjaran,jurusan,bahasa,inggris,matematika,ipa) "
                        + "VALUES ('"+UserSession.getU_id()+ "','"+ cboTA.getSelectedItem()+"','"+ jurusan +"','"+ BahasaIpa +"','"+ InggrisIpa +"','"+ MatematikaIpa +"','"+ IpaIpa +"')";
                    Statement st = db.getConnection().createStatement();
                    st.execute(sql);
             }else{
                 JOptionPane.showMessageDialog(null, "anda sudah menginputnya");
             }
             
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIpaActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        // TODO add your handling code here:
        db.dbConnection();
        String BahasaIps = txtBahasaIPS.getText();
        String InggrisIps = txtInggrisIps.getText();
        String MatematikaIps = txtiMatematikaIps.getText();
        String IpaIps = txtIpaIps.getText();
        String jurusan = "ips";
        
        
        
         try{
             String cekSql = "SELECT jurusan, tahunAjaran from nilai_minimal_ips WHERE jurusan = '"+ jurusan +"' AND tahunAjaran = '"+cboTA.getSelectedItem()+"'";
             Statement stCek = db.getConnection().createStatement();
             ResultSet rsCek = stCek.executeQuery(cekSql);
             
             rsCek.last(); //mengecek jumlah baris pada hasil query   
             if (rsCek.getRow() == 0 ) {
                  String sql = "INSERT INTO nilai_minimal_ips (id_user,tahunAjaran,jurusan,bahasa,inggris,matematika,ipa) "
                        + "VALUES ('"+UserSession.getU_id()+ "','"+ cboTA.getSelectedItem()+"','"+ jurusan +"','"+ BahasaIps +"','"+ InggrisIps +"','"+ MatematikaIps +"','"+ IpaIps +"')";
                    Statement st = db.getConnection().createStatement();
                    st.execute(sql);
             }else{
                 JOptionPane.showMessageDialog(null, "anda sudah menginputnya");
             }
             
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void btnSimpanBahasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanBahasaActionPerformed
        // TODO add your handling code here:
         db.dbConnection();
        String BahasaBhs = txtBahasaBahasa.getText();
        String InggrisBhs = txtInggrisBahasa.getText();
        String MatematikaBhs = txtiMatematikaBahasa.getText();
        String IpaBhs = txtIpaBahasa.getText();
        String jurusan = "bahasa";
        
        
        
         try{
             String cekSql = "SELECT jurusan, tahunAjaran from nilai_minimal WHERE jurusan = '"+ jurusan +"' AND tahunAjaran = '"+cboTA.getSelectedItem()+"'";
             Statement stCek = db.getConnection().createStatement();
             ResultSet rsCek = stCek.executeQuery(cekSql);
             
             rsCek.last(); //mengecek jumlah baris pada hasil query   
             if (rsCek.getRow() == 0 ) {
                  String sql = "INSERT INTO nilai_minimal (id_user,tahunAjaran,jurusan,bahasa,inggris,matematika,ipa) "
                        + "VALUES ('"+UserSession.getU_id()+ "','"+ cboTA.getSelectedItem()+"','"+ jurusan +"','"+ BahasaBhs +"','"+ InggrisBhs +"','"+ MatematikaBhs +"','"+ IpaBhs +"')";
                    Statement st = db.getConnection().createStatement();
                    st.execute(sql);
             }else{
                 JOptionPane.showMessageDialog(null, "anda sudah menginputnya");
             }
             
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }//GEN-LAST:event_btnSimpanBahasaActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        this.hide();
        HomeAdmin back = new HomeAdmin();
        back.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(InputNilaiPenyeleksian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputNilaiPenyeleksian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputNilaiPenyeleksian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputNilaiPenyeleksian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputNilaiPenyeleksian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Simpan;
    private javax.swing.JButton btnIpa;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpanBahasa;
    private javax.swing.JComboBox cboTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBahasaBahasa;
    private javax.swing.JTextField txtBahasaIPS;
    private javax.swing.JTextField txtBahasaIpa;
    private javax.swing.JTextField txtInggrisBahasa;
    private javax.swing.JTextField txtInggrisIpa;
    private javax.swing.JTextField txtInggrisIps;
    private javax.swing.JTextField txtIpaBahasa;
    private javax.swing.JTextField txtIpaIpa;
    private javax.swing.JTextField txtIpaIps;
    private javax.swing.JTextField txtMatematikaIpa;
    private javax.swing.JTextField txtiMatematikaBahasa;
    private javax.swing.JTextField txtiMatematikaIps;
    // End of variables declaration//GEN-END:variables
}
