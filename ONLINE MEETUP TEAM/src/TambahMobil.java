
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TambahMobil extends javax.swing.JFrame {

    /**
     * Creates new form TambahMobil
     */
    public TambahMobil() {
        initComponents();
        tablemobilTampilData();
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
        close = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        merkmbl = new javax.swing.JTextField();
        nopolisimbl = new javax.swing.JTextField();
        hargambl = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        cari = new javax.swing.JButton();
        carimobil = new javax.swing.JTextField();
        tahunmbl = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablemobil = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tipembl = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 247, 252));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setIcon(new javax.swing.ImageIcon("D:\\[TEL-U]\\[INFORMATICS]\\KULIAH\\[SMST 3]\\[PBO]\\rolinnn\\cl.PNG")); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 40, 40));

        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Data Mobil");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 38, 70, 22));

        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Merk Mobil");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 22));

        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Tipe Mobil");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 22));

        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Tahun Produksi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 22));

        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("No Polisi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 90, 22));

        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Harga Sewa");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 90, 22));

        merkmbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                merkmblComponentHidden(evt);
            }
        });
        jPanel1.add(merkmbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, 30));
        jPanel1.add(nopolisimbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 160, 30));

        hargambl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargamblActionPerformed(evt);
            }
        });
        jPanel1.add(hargambl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 160, 30));

        tambah.setBackground(new java.awt.Color(244, 247, 252));
        tambah.setForeground(new java.awt.Color(0, 153, 153));
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel1.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        edit.setBackground(new java.awt.Color(244, 247, 252));
        edit.setForeground(new java.awt.Color(0, 153, 153));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        hapus.setBackground(new java.awt.Color(244, 247, 252));
        hapus.setForeground(new java.awt.Color(0, 153, 153));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel1.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        refresh.setBackground(new java.awt.Color(244, 247, 252));
        refresh.setForeground(new java.awt.Color(0, 153, 153));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 80, -1));

        cari.setBackground(new java.awt.Color(244, 247, 252));
        cari.setForeground(new java.awt.Color(0, 153, 153));
        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 80, -1));
        jPanel1.add(carimobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 210, 23));

        tahunmbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2013", "2014", "2015", "2016", "2017", "2018" }));
        tahunmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunmblActionPerformed(evt);
            }
        });
        jPanel1.add(tahunmbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, 20));

        tablemobil.setBackground(new java.awt.Color(244, 247, 252));
        tablemobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Mobil", "Merk Mobil", "Tipe Mobil", "Tahun Produksi", "No Polisi", "Harga Sewa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablemobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablemobil);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 600, 90));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("French Script MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("CR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 80, 70));

        tipembl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matic", "Manual" }));
        tipembl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipemblActionPerformed(evt);
            }
        });
        jPanel1.add(tipembl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 50, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearMobil(){
        merkmbl.setText("");
        tipembl.setSelectedItem("");
        tahunmbl.setSelectedItem("");
        nopolisimbl.setText("");
        hargambl.setText("");
    }
    
    private void merkmblComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_merkmblComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_merkmblComponentHidden

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
            String merkM = merkmbl.getText();
            String tipeM = (String) tipembl.getSelectedItem();
            String tahunM = (String) tahunmbl.getSelectedItem();
            String noM = nopolisimbl.getText();
            int hargaM = Integer.parseInt(hargambl.getText());
            
            try {
                 Statement st = (Statement)koneksi.getConnection().createStatement();
                 st.execute("insert into tbl_mobil(merk, tipe, tahun, no_polisi, harga,status)values"
                         + "('" + merkM + "','" +tipeM+ "','" +tahunM+ "','"+ noM+ "','" +hargaM+ "','1')");
                 JOptionPane.showMessageDialog(this, "Data Mobil berhasil Ditambahkan");
                Statement stUpdate = (Statement)koneksi.getConnection().createStatement();
                 

                 
                 
                 clearMobil();
                 tablemobilTampilData();
                
            } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    
    }//GEN-LAST:event_tambahActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
      try{    
        Statement st = (Statement)koneksi.getConnection().createStatement();
              st.execute("update tbl_mobil set merk = '" + merkmbl.getText() + "', tipe ='" +tipembl.getSelectedItem()+ "', tahun='"+ tahunmbl.getSelectedItem()+ "', no_polisi = '" +nopolisimbl.getText()+ "', harga = '" +hargambl.getText() + "' where merk = '" + merkmbl.getText()+"'");
              JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            
              
              clearMobil();
              tablemobilTampilData();
              
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
       try{ 
            Statement st = (Statement)koneksi.getConnection().createStatement();
            st.execute("delete from tbl_mobil where merk = '" + merkmbl.getText()+"'");
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
 
            clearMobil();
            tablemobilTampilData();           
         }catch (Exception e) {
             JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        merkmbl.setText("");
        tipembl.setSelectedIndex(0);
        nopolisimbl.setText("");
        hargambl.setText("");
        carimobil.setText("");
        
        tablemobilTampilData();
   

    }//GEN-LAST:event_refreshActionPerformed

    private void tahunmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunmblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunmblActionPerformed

    private void hargamblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargamblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargamblActionPerformed

    private void tablemobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemobilMouseClicked
        int selectedRow = tablemobil.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)tablemobil.getModel();
        merkmbl.setText(model.getValueAt(selectedRow, 1).toString());
        tipembl.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
        tahunmbl.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
        nopolisimbl.setText(model.getValueAt(selectedRow, 4).toString());
        hargambl.setText(model.getValueAt(selectedRow, 5).toString());
        
    }//GEN-LAST:event_tablemobilMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Mobil");
        model.addColumn("Merk Mobil");
        model.addColumn("Tipe Mobil");
        model.addColumn("Tahun");
        model.addColumn("No Polisi");
        model.addColumn("Harga Sewa");
   
      try{
        String search = this.carimobil.getText();
        Statement stm = (Statement)koneksi.getConnection().createStatement();
        ResultSet res=stm.executeQuery("select * from tbl_mobil where tipe like '%"+search+"%'");
        
         while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }tablemobil.setModel(model);
     
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
            
    }//GEN-LAST:event_cariActionPerformed

    private void tipemblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipemblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipemblActionPerformed

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
            java.util.logging.Logger.getLogger(TambahMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahMobil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari;
    private javax.swing.JTextField carimobil;
    private javax.swing.JLabel close;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField hargambl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField merkmbl;
    private javax.swing.JTextField nopolisimbl;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tablemobil;
    private javax.swing.JComboBox<String> tahunmbl;
    private javax.swing.JButton tambah;
    private javax.swing.JComboBox<String> tipembl;
    // End of variables declaration//GEN-END:variables

  private void tablemobilTampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Mobil");
        model.addColumn("Merk Mobil");
        model.addColumn("Tipe Mobil");
        model.addColumn("Tahun");
        model.addColumn("No Polisi");
        model.addColumn("Harga Sewa");
        
        try{
            Statement st = (Statement)koneksi.getConnection().createStatement();
            ResultSet res = st.executeQuery("select * from tbl_mobil");
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }tablemobil.setModel(model);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
        
    }
}