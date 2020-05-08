/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.*;
import java.util.*;
import javax.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MbahGenius
 */
public class menu_peminjam extends javax.swing.JFrame {

    /**
     * Creates new form menu_peminjam
     */
    private Connection db;
    public menu_peminjam() throws SQLException {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        db = (Connection) koneksi.koneksiDB();
        
        tgl_cari.setDateFormatString("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        
    Instant min = now.plusMonths(1)
            .atStartOfDay(ZoneId.systemDefault())
            .toInstant();
    tgl_cari.setSelectableDateRange(new Date(),Date.from(min) );
//        tableTampilData();
            tableTampilDataStatus();
    }
    
    private void tableTampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ruang");
        model.addColumn("jenis");
        model.addColumn("kapasitas");
        model.addColumn("08:00");
        model.addColumn("09:00");
        model.addColumn("10:00");
        model.addColumn("11:00");
        model.addColumn("12:00");
        model.addColumn("13:00");
        model.addColumn("14:00");
        model.addColumn("15:00");
        model.addColumn("16:00");
        model.addColumn("17:00");
        model.addColumn("18:00");
        model.addColumn("19:00");
        model.addColumn("20:00");
        String tglcari = ((JTextField)tgl_cari.getDateEditor().getUiComponent()).getText();
        String id_pem = user_session.getU_id();
        
        
        try {
            Statement tsql = db.createStatement();
            String sqlt="select id_ruangan from detail_ruangan where tanggal='"+tglcari+"'";
            ResultSet result=tsql.executeQuery(sqlt);
            
            
            
            result.next();
            if (result.getRow()>0) {
                Statement tsql2=db.createStatement();
                
                String sqls="select ruangan.nama_ruangan,ruangan.jenis_ruangan, ruangan.kapasitas, detail_ruangan.jam_8, detail_ruangan.jam_9, detail_ruangan.jam_10"
                    + ", detail_ruangan.jam_11, detail_ruangan.jam_12, detail_ruangan.jam_13, detail_ruangan.jam_14, detail_ruangan.jam_15, detail_ruangan.jam_16, detail_ruangan.jam_17"
                    + ", detail_ruangan.jam_18, detail_ruangan.jam_19, detail_ruangan.jam_20 from ruangan,detail_ruangan where ruangan.id_ruangan=detail_ruangan.id_ruangan AND detail_ruangan.tanggal= '"+tglcari+"' order by ruangan.jenis_ruangan desc";
                ResultSet res = tsql2.executeQuery(sqls);
                while(res.next()){
                   model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),
                    res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15),res.getString(16)});
                    
                }tabel_ruangan.setModel(model); 
            } else{
//                res.next();
//                Statement tsql2 = db.createStatement();
//                ResultSet res2 = tsql2.executeQuery(sqls);
                String sql1="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('01 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                String sql2="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('02 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                String sql3="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('03 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                String sql4="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('04 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                String sql5="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('05 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                String sql6="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('06 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                String sql7="insert into detail_ruangan(id_ruangan,jam_8,jam_9,jam_10,jam_11,jam_12,jam_13,jam_14,jam_15,jam_16,jam_17,jam_18,jam_19,jam_20,tanggal)"
                        + " values('07 ','-','-','-','-','-','-','-','-','-','-','-','-','-','"+tglcari+"')";
                
                
                tsql.addBatch(sql1);
                tsql.addBatch(sql2);
                tsql.addBatch(sql3);
                tsql.addBatch(sql4);
                tsql.addBatch(sql5);
                tsql.addBatch(sql6);
                tsql.addBatch(sql7);
                
                tsql.executeBatch();
//                res.next();
//                tsql.executeUpdate(""+sql1);
//                res.next();
//                tsql.executeUpdate(""+sql2);
                
                
                System.out.println(id_pem);
                tableTampilData();


            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    private void tableTampilDataStatus() {
        String id_pem = user_session.getU_id();
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("ruangan");
        model2.addColumn("mulai");
        model2.addColumn("berakhir");
        model2.addColumn("tanggal pengajuan");
        model2.addColumn("keperluan");
        model2.addColumn("status");
        
        
        
        try {
            Statement tsql3 = db.createStatement();
//            String sql= ;
            ResultSet resu=tsql3.executeQuery("select * from detail_peminjaman where id_peminjam = '"+id_pem+"'");
            
             while (resu.next()) {
                model2.addRow(new Object[]{resu.getString(9),resu.getString(3),resu.getString(4),resu.getString(5),resu.getString(10),resu.getString(11)});
            } tabel_status.setModel(model2);
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_status = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_ruangan = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        bt_refresh = new javax.swing.JButton();
        tgl_cari = new com.toedter.calendar.JDateChooser();
        bt_cari = new javax.swing.JButton();
        bt_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("DAFTAR RUANGAN");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("STATUS PEMINJAMAN");

        tabel_status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ruangan", "Mulai", "Berakhir", "Tanggal pengajuan", "Keperluan", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabel_status);
        if (tabel_status.getColumnModel().getColumnCount() > 0) {
            tabel_status.getColumnModel().getColumn(0).setResizable(false);
            tabel_status.getColumnModel().getColumn(1).setResizable(false);
            tabel_status.getColumnModel().getColumn(2).setResizable(false);
            tabel_status.getColumnModel().getColumn(3).setResizable(false);
            tabel_status.getColumnModel().getColumn(4).setResizable(false);
            tabel_status.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabel_ruangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUANG", "JENIS", "KAPASITAS", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_ruangan);
        if (tabel_ruangan.getColumnModel().getColumnCount() > 0) {
            tabel_ruangan.getColumnModel().getColumn(0).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(1).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(2).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(3).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(4).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(5).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(6).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(7).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(8).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(9).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(10).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(11).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(12).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(13).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(14).setResizable(false);
            tabel_ruangan.getColumnModel().getColumn(15).setResizable(false);
        }

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Pinjam ruangan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bt_refresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_refresh.setText("Refresh");
        bt_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_refresh)
                .addGap(70, 70, 70))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(bt_refresh))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        bt_cari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_cari.setText("Cari");
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        bt_keluar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt_keluar.setText("Keluar");
        bt_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tgl_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(276, 276, 276)
                        .addComponent(bt_keluar)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(bt_cari))
                        .addComponent(tgl_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_keluar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refreshActionPerformed
        // TODO add your handling code here:
        String id_pem = user_session.getU_id();
                System.out.println(id_pem);
        tableTampilData();
        tableTampilDataStatus();
    }//GEN-LAST:event_bt_refreshActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            detail_pinjaman dt = new detail_pinjaman();
            dt.show();
            
        } catch (SQLException ex) {
            Logger.getLogger(menu_peminjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        // TODO add your handling code here:
        tableTampilData();
    }//GEN-LAST:event_bt_cariActionPerformed

    private void bt_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_keluarActionPerformed
        // TODO add your handling code here:
        
        String pilihan[]={"Ya","Tidak"};
                //                JOptionPane.showMessageDialog(null, "Maaf password atau username anda salah");
                int opsi = JOptionPane.showOptionDialog(null, "Apakah anda yakin ingin keluar ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, pilihan, pilihan[0]);
                if(opsi == JOptionPane.YES_OPTION){
                    user_session.setU_id(null);
                    user_session.setU_level(null);
                    user_session.setU_pw(null);
                    this.dispose();
                }
        
    }//GEN-LAST:event_bt_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(menu_peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new menu_peminjam().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(menu_peminjam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_keluar;
    private javax.swing.JButton bt_refresh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_ruangan;
    private javax.swing.JTable tabel_status;
    private com.toedter.calendar.JDateChooser tgl_cari;
    // End of variables declaration//GEN-END:variables
}
