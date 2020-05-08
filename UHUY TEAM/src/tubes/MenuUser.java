/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuUser extends javax.swing.JFrame {
    Connection con;
    int masuk, bulan=1 , total=0 , kurang=0, index=0;
    ArrayList<String> ket = new ArrayList<>();
    ArrayList<Integer> nominal = new ArrayList<>();
    String keterangan;
    /**
     * Creates new form MenuUser
     */
    public MenuUser() {
        initComponents();
        Koneksi koneksi = new Koneksi();
        con = koneksi.Connect();
        DataTanggung();
//      Nama();
    }
//    public void Nama(){
//        JOptionPane.showMessageDialog(rootPane, IdenitasSiswa.getNama());
//        txtnama.setText(IdenitasSiswa.getNama());
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JButton();
        btnPesan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setForeground(new java.awt.Color(255, 204, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 320));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setText("Menu Siswa");

        btnDaftar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDaftar.setText("Daftar Tagihan");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });

        btnPesan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesan.setText("Pesan ke-Admin");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCetak.setText("Cetak Data Tagihan");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnKeluar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("Layanan Pembayaran Tanggungan Sekolah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(btnDaftar)
                .addGap(18, 18, 18)
                .addComponent(btnPesan)
                .addGap(18, 18, 18)
                .addComponent(btnCetak)
                .addGap(18, 18, 18)
                .addComponent(btnKeluar)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void DataTanggung(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM tanggungan";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = total+rs.getInt("nominal");
                ket.add(index, rs.getString("keteranganTanggungan"));
                nominal.add(index, rs.getInt("nominal"));
//                keterangan = rs.getString("keteranganTanggungan");
                index++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
    DaftarTagihan move;
        try {
            move = new DaftarTagihan();
            move.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDaftarActionPerformed

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        try {
            PesanUser move = new PesanUser();
            move.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPesanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
//        IdenitasSiswa ident = new IdenitasSiswa();
        
        try {  
           // JOptionPane.showMessageDialog(rootPane, ket.size());
            Statement st = con.createStatement();
            String sql = "SELECT * FROM siswa WHERE nis = "+IdenitasSiswa.getId();
//            String sql2 = "SELECT * FROM tanggungan";
            ResultSet rs = st.executeQuery(sql);
//            ResultSet rs2 = st.executeQuery(sql2);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Data_"+IdenitasSiswa.getNama()+".pdf"));
            doc.open();
            
            while (rs.next()) {
                doc.add(new Paragraph("==============================================================="));
                doc.add(new Paragraph("                       Data Pembayaran SISWA"));
                doc.add(new Paragraph("==============================================================="));
                doc.add(new Paragraph("     Nama \t: "+rs.getString("nama")));
                doc.add(new Paragraph("     Kelas \t: "+rs.getString("kelas")));
                doc.add(new Paragraph("     Jenis Kelamin \t: "+rs.getString("gender")));
                doc.add(new Paragraph("     Alamat \t: "+rs.getString("alamat")));
                doc.add(new Paragraph("     "));
                doc.add(new Paragraph("     "));
                
                kurang = rs.getInt("Tanggungan");

            }
                doc.add(new Paragraph("     Data Tagihan : "));
                doc.add(new Paragraph("--------------------------------------------------------------------"));
                
                for (int i = 0; i < ket.size(); i++) {
                doc.add(new Paragraph("|     Bulan ke-"+(i+1)+"                                           |"));
                doc.add(new Paragraph("      Keterangan = "+ket.get(i)));
                doc.add(new Paragraph("|                                     Nominal = "+nominal.get(i)+" |"));                
                }
                doc.add(new Paragraph("--------------------------------------------------------------------"));
                
                masuk = total-kurang;
                doc.add(new Paragraph("     Total yang harus dibayar = Rp. "+total));
                doc.add(new Paragraph("     Uang Masuk = Rp. "+masuk));
                doc.add(new Paragraph("     Kekurangan = Rp. "+kurang));
                
            
            doc.close();
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil di cetak. ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
       Login move = new Login();
       move.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
