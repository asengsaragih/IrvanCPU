/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Panjie Pahlevie
 */
public class Pesanan extends javax.swing.JFrame {

    /**
     * Creates new form Pesanan
     */
    private Connection db;
    String Nama,Alamat,Date;
    int TotalMakanan, Delivery, Pajak, Total;
    public Pesanan() throws SQLException {
        initComponents();
        db =  Koneksi.configDB();
        tableTampilData();
        alamat();
        nama();
        totalMakanan();
        delivery();
        pajak();
        date();
        total();
    }
    private void tableTampilData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Banyak");
        model.addColumn("Harga");
        model.addColumn("Total");
        int idUser = Cookies.getIdUser();
        
        try {
            Statement stmt = db.createStatement();
             ResultSet res = stmt.executeQuery("select transaksi.idtrx, inputmenu.nama, "
                     + "transaksi.banyak, inputmenu.harga, transaksi.subtotal from transaksi,inputmenu "
                     + "WHERE transaksi.idMenu=inputmenu.idMenu AND transaksi.idUser = "+idUser+" AND status=0");

            while(res.next()){
                model.addRow(new Object[]{res.getInt("idtrx"),res.getString("nama"),res.getInt("banyak")
                            ,res.getInt("harga"), res.getInt("subtotal")});
            }table.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void alamat(){
         try {
            Statement stmt=db.createStatement();
            ResultSet res = stmt.executeQuery("select alamat from user where idUser ="+Cookies.getIdUser());
            res.next();
            alamat.setText(res.getString("alamat"));
            Alamat = res.getString("alamat");
            
        } catch (Exception e) {

        }
    }
    
    private void nama(){
         try {
            Statement stmt=db.createStatement();
            ResultSet res = stmt.executeQuery("select nama from user where idUser ="+Cookies.getIdUser());
            res.next();
            customer.setText(res.getString("nama"));
            Nama = res.getString("nama");
        } catch (Exception e) {

        }
    }
    
    private void totalMakanan(){
         try {
            Statement stmt=db.createStatement();
            ResultSet res = stmt.executeQuery("select SUM(subtotal) as total from transaksi where idUser ="+Cookies.getIdUser()+" AND status=0");
            res.next();
            totalMakanan.setText(Integer.toString(res.getInt("total")));
            TotalMakanan = res.getInt("total");
        } catch (Exception e) {

        }
    }
    
    private void delivery(){
         try {
            Statement stmt=db.createStatement();
            ResultSet res = stmt.executeQuery("select SUM(subtotal) as total from transaksi where idUser ="+Cookies.getIdUser()+" AND status=0");
            res.next();
            int rumus = (int) (res.getInt("total")*0.2);        
            deliv.setText(Integer.toString(rumus));
            Delivery = rumus;
        } catch (Exception e) {

        }
    }
    
    private void pajak(){
         try {
            Statement stmt=db.createStatement();
            ResultSet res = stmt.executeQuery("select SUM(subtotal) as total from transaksi where idUser ="+Cookies.getIdUser()+" AND status=0");
            res.next();
            int rumuss = (int) (res.getInt("total")*0.1);        
            pajak.setText(Integer.toString(rumuss));
            Pajak = rumuss;
        } catch (Exception e) {

        }
    }
    
    private void date(){
         try {
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            Date datee = new Date();
            String tanggalPesanan = dateformat.format(datee);
            date.setText(tanggalPesanan);
            Date = tanggalPesanan;
        } catch (Exception e) {

        }
    }
    
    private void total(){
        try {
            int totall =TotalMakanan+Delivery+Pajak;
            total.setText(Integer.toString(totall));
            Total=totall;
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customer = new javax.swing.JLabel();
        totalMakanan = new javax.swing.JLabel();
        pajak = new javax.swing.JLabel();
        deliv = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        metode = new javax.swing.JComboBox<>();
        kirim = new javax.swing.JButton();
        logout1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("McDun-Delivery");

        alamat.setText("jLabel2");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Pesanan", "Banyak", "Harga", "Total"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel3.setText("Alamat ");

        jLabel4.setText("Harga Makanan");

        jLabel5.setText("Harga Delivery");

        jLabel6.setText("Pajak");

        jLabel2.setText("Atas Nama : ");

        customer.setText("jLabel7");

        totalMakanan.setText("jLabel2");

        pajak.setText("jLabel2");

        deliv.setText("jLabel2");

        date.setText("jLabel7");

        jLabel7.setText("Metode Pembayaran ");

        metode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Transfer" }));
        metode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodeActionPerformed(evt);
            }
        });

        kirim.setText("Konfiirmasi Pesanan");
        kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimActionPerformed(evt);
            }
        });

        logout1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        logout1.setText("Logout");
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal Pesanan");

        jLabel9.setText("Total");

        total.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(kirim)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deliv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pajak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(metode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 262, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logout1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(alamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logout1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(alamat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalMakanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(deliv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pajak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(total))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(metode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kirim)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void metodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodeActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logout1ActionPerformed

    private void kirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimActionPerformed
        // TODO add your handling code here:
        try {
            Statement stmt = db.createStatement();
            
            String Metode = metode.getSelectedItem().toString();
            
            stmt.execute("INSERT INTO pesanan (tgl,totalMakanan,hargaDelivery,pajak,total,metode) "
                    + "VALUES('"+Date+"',"+TotalMakanan+","+Delivery+","+Pajak+","+Total+",'"+Metode+"')");
            
            ResultSet res = stmt.executeQuery("select idPesanan from pesanan order by idPesanan desc");
            res.next();
            int idpes = res.getInt("idPesanan");
            
            stmt.execute("update transaksi set idPesanan="+idpes+", status=1");
            JOptionPane.showMessageDialog(this, "Pesanan Akan Di Proses!");
            this.dispose();
            new status().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_kirimActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pesanan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel customer;
    private javax.swing.JLabel date;
    private javax.swing.JLabel deliv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kirim;
    private javax.swing.JButton logout1;
    private javax.swing.JComboBox<String> metode;
    private javax.swing.JLabel pajak;
    private javax.swing.JTable table;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalMakanan;
    // End of variables declaration//GEN-END:variables
}
