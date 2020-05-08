/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package small;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yulio
 */
public class StatusBayar extends javax.swing.JFrame {
private Connection db;

 
    public StatusBayar()throws SQLException {
        initComponents();
        db = Koneksi.koneksiDB();
        tableTampilData();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnkembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpembayaran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txttahap3 = new javax.swing.JTextField();
        txttahap2 = new javax.swing.JTextField();
        txttahap1 = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblstatus = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblidpemilik = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblnamatoko = new javax.swing.JLabel();
        lblnamapemilik = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbljangkawaktu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        lbltglmasuk = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbltglkeluar = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblsisa = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 153));

        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });

        tblpembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id pemilik", "Nama Pemilik", "Nama Toko", "Jangka Waktu", "Total", "Tahap 1", "Tahap 2", "Tahap 3", "Status", "Tgl Masuk", "Sisa Bayar", "Tgl Keluar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpembayaran);
        if (tblpembayaran.getColumnModel().getColumnCount() > 0) {
            tblpembayaran.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setText("Tahap 1");

        jLabel6.setText("Tahap 2");

        jLabel7.setText("Tahap 3");

        jLabel9.setText("Status");

        txttahap3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahap3KeyReleased(evt);
            }
        });

        txttahap2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahap2KeyReleased(evt);
            }
        });

        txttahap1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahap1KeyReleased(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        lblstatus.setText("status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnreset)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnedit))
                        .addComponent(txttahap1)
                        .addComponent(txttahap2)
                        .addComponent(txttahap3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addComponent(jSeparator2))
                    .addComponent(lblstatus))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txttahap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttahap2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttahap3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblstatus))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnedit)
                    .addComponent(btnreset))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        lblidpemilik.setText("id");

        jLabel3.setText("Nama Pemilik");

        jLabel4.setText("Nama Toko");

        lblnamatoko.setText("toko");

        lblnamapemilik.setText("nama");

        jLabel2.setText("Id Pemilik");

        jLabel1.setText("Total");

        lbltotal.setText("total");

        jLabel10.setText("Jangka Waktu");

        lbljangkawaktu.setText("jangka waktu");

        jLabel11.setText("tahun");

        jLabel12.setText("Rp");

        jLabel8.setText("Tgl Masuk");

        lbltglmasuk.setText("tgl");

        jLabel14.setText("Tgl Keluar");

        lbltglkeluar.setText("tgl");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnamapemilik)
                            .addComponent(lblnamatoko)
                            .addComponent(lblidpemilik)
                            .addComponent(lbltotal)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbljangkawaktu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltglmasuk)
                                    .addComponent(jLabel11)
                                    .addComponent(lbltglkeluar))))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblidpemilik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblnamapemilik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblnamatoko))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbltotal)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbljangkawaktu)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbltglmasuk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbltglkeluar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 51));
        jLabel21.setText("Pembayaran");

        lblsisa.setText("sisa");
        lblsisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblsisaKeyReleased(evt);
            }
        });

        jLabel13.setText("Sisa Pembayaran");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblsisa)
                .addGap(179, 179, 179))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnkembali)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblsisa)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnkembali)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1003, 797));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        try {
           // TODO add your handling code here:
           this.dispose();
           Mainmenu mm = new Mainmenu();
           mm.setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(Mainmenu.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnkembaliActionPerformed
    private void clearForm(){
    
}
    private void tblpembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpembayaranMouseClicked
        // TODO add your handling code here:
        int baris = tblpembayaran.rowAtPoint(evt.getPoint());
        String id_pemilik = tblpembayaran.getValueAt(baris, 0).toString();
        lblidpemilik.setText(id_pemilik);
        
        String nama_pemilik = tblpembayaran.getValueAt(baris, 1).toString();
        lblnamapemilik.setText(nama_pemilik);
        
        String nama_toko = tblpembayaran.getValueAt(baris, 2).toString();
        lblnamatoko.setText(nama_toko);
        
        String jangka_waktu = tblpembayaran.getValueAt(baris, 3).toString();
        lbljangkawaktu.setText(jangka_waktu);
        
        String total = tblpembayaran.getValueAt(baris, 4).toString();
        lbltotal.setText(total);
        
        String tgl_masuk = tblpembayaran.getValueAt(baris, 5).toString();
        lbltglmasuk.setText(tgl_masuk);
        
        String tgl_keluar = tblpembayaran.getValueAt(baris, 6).toString();
        lbltglkeluar.setText(tgl_keluar);
        
        String tahap1 = tblpembayaran.getValueAt(baris, 7).toString();
        txttahap1.setText(tahap1);
        
        String tahap2 = tblpembayaran.getValueAt(baris, 8).toString();
        txttahap2.setText(tahap2);
        
        String tahap3 = tblpembayaran.getValueAt(baris, 9).toString();
        txttahap3.setText(tahap3);
        
         String status = tblpembayaran.getValueAt(baris, 10).toString();
        lblstatus.setText(status);
        
        String sisa = tblpembayaran.getValueAt(baris, 11).toString();
        lblsisa.setText(sisa);
        
        
    }//GEN-LAST:event_tblpembayaranMouseClicked

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        lblidpemilik.setText("");
        lblnamapemilik.setText("");
        lblnamatoko.setText("");
        lbljangkawaktu.setText("");
        lbltotal.setText("");
        lbltglmasuk.setText("");
        lbltglkeluar.setText("");
        txttahap1.setText("");
        txttahap2.setText("");
        txttahap3.setText("");
        lblstatus.setText("");
        lblsisa.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
         try {
            Statement tsql = db.createStatement();
            tsql.execute("UPDATE registrasi SET "
                    + "tahap1 = '"+txttahap1.getText()+
                    "', tahap2 = '"+txttahap2.getText()+
                    "', tahap3 = '"+txttahap3.getText()+
                    "', sisa_bayar = '"+lblsisa.getText()+
                    "', status = '"+lblstatus.getText()+
                     "' "+"WHERE id_pemilik='"+lblidpemilik.getText()+"'");
            
            JOptionPane.showMessageDialog(this,"Data berhasil diupdate");
        
            clearForm();
            tableTampilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }          
                        
    }//GEN-LAST:event_btneditActionPerformed

    private void lblsisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblsisaKeyReleased
        // TODO add your handling code here:
        int total = Integer.parseInt(lbltotal.getText());
        int tahap1 = Integer.parseInt(txttahap1.getText());
        int tahap2 = Integer.parseInt(txttahap2.getText());
        int tahap3 = Integer.parseInt(txttahap3.getText());
        int sisa;
        sisa = total-tahap1-tahap2-tahap3;
        String total_harga = Integer.toString(sisa);
        lblsisa.setText(Integer.toString(sisa));
    }//GEN-LAST:event_lblsisaKeyReleased

    private void txttahap1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahap1KeyReleased
        // TODO add your handling code here:
        int total = Integer.parseInt(lbltotal.getText());
        int tahap1 = Integer.parseInt(txttahap1.getText());
        int tahap2 = Integer.parseInt(txttahap2.getText());
        int tahap3 = Integer.parseInt(txttahap3.getText());
        int sisa;
        sisa = total-tahap1-tahap2-tahap3;
        String total_harga = Integer.toString(sisa);
        lblsisa.setText(Integer.toString(sisa));
        if (sisa==0) {
            lblstatus.setText("Lunas");
        }else{
            lblstatus.setText("Belum Lunas");
        }
    }//GEN-LAST:event_txttahap1KeyReleased

    private void txttahap2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahap2KeyReleased
        // TODO add your handling code here:
        int total = Integer.parseInt(lbltotal.getText());
        int tahap1 = Integer.parseInt(txttahap1.getText());
        int tahap2 = Integer.parseInt(txttahap2.getText());
        int tahap3 = Integer.parseInt(txttahap3.getText());
        int sisa;
        sisa = total-tahap1-tahap2-tahap3;
        String total_harga = Integer.toString(sisa);
        lblsisa.setText(Integer.toString(sisa));
        if (sisa==0) {
            lblstatus.setText("Lunas");
        }else{
            lblstatus.setText("Belum Lunas");
        }
    }//GEN-LAST:event_txttahap2KeyReleased

    private void txttahap3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahap3KeyReleased
        // TODO add your handling code here:
        int total = Integer.parseInt(lbltotal.getText());
        int tahap1 = Integer.parseInt(txttahap1.getText());
        int tahap2 = Integer.parseInt(txttahap2.getText());
        int tahap3 = Integer.parseInt(txttahap3.getText());
        int sisa;
        sisa = total-tahap1-tahap2-tahap3;
        String total_harga = Integer.toString(sisa);
        lblsisa.setText(Integer.toString(sisa));
        if (sisa==0) {
            lblstatus.setText("Lunas");
        }else{
            lblstatus.setText("Belum Lunas");
        }
    }//GEN-LAST:event_txttahap3KeyReleased

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
            java.util.logging.Logger.getLogger(StatusBayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusBayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusBayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusBayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StatusBayar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StatusBayar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     private void tableTampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Pemilik");
        model.addColumn("Nama Pemilik");
        model.addColumn("Nama Toko");
        model.addColumn("Jangka Waktu");
        model.addColumn("Total");
        model.addColumn("Tgl Masuk");
        model.addColumn("Tgl Keluar");
        model.addColumn("Tahap 1");
        model.addColumn("Tahap 2");
        model.addColumn("Tahap 3");
        model.addColumn("Status");
        model.addColumn("Sisa Bayar");
        
        try {
            Statement tsql = db.createStatement();
            ResultSet res = tsql.executeQuery("select id_pemilik, nama_pemilik, nama_toko,jangka_waktu, total, tgl_masuk,tgl_keluar, tahap1, tahap2, tahap3, status, sisa_bayar from registrasi order by id_pemilik asc");
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12)});
            }
         tblpembayaran.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnreset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblidpemilik;
    private javax.swing.JLabel lbljangkawaktu;
    private javax.swing.JLabel lblnamapemilik;
    private javax.swing.JLabel lblnamatoko;
    private javax.swing.JLabel lblsisa;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JLabel lbltglkeluar;
    private javax.swing.JLabel lbltglmasuk;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tblpembayaran;
    private javax.swing.JTextField txttahap1;
    private javax.swing.JTextField txttahap2;
    private javax.swing.JTextField txttahap3;
    // End of variables declaration//GEN-END:variables
}
