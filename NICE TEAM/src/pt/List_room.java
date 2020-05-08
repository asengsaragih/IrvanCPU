    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt;


import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ButtonGroup;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author 
 */
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSheetConditionalFormatting;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class List_room extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    public List_room() {
        initComponents();
        get();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_room = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        NomorKamar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        standar = new javax.swing.JRadioButton();
        dobel = new javax.swing.JRadioButton();
        superior = new javax.swing.JRadioButton();
        UPDATE = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        searchupdate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(226, 106, 106));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Perpetua", 1, 48)); // NOI18N
        jLabel5.setText("ROOM");

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_Home_40px_1.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(316, 316, 316)
                .addComponent(home)
                .addGap(47, 47, 47))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5))
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        tabel_room.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor kamar", "Tipe kamar"
            }
        ));
        jScrollPane1.setViewportView(tabel_room);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 390, 320));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 110, 30));

        jPanel1.setBackground(new java.awt.Color(226, 106, 106));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("NOMOR KAMAR");

        NomorKamar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("TIPE KAMAR ");

        standar.setBackground(new java.awt.Color(226, 106, 106));
        buttonGroup1.add(standar);
        standar.setText("STANDAR");
        standar.setToolTipText("");
        standar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standarActionPerformed(evt);
            }
        });

        dobel.setBackground(new java.awt.Color(226, 106, 106));
        buttonGroup1.add(dobel);
        dobel.setText("DOUBLE");
        dobel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobelActionPerformed(evt);
            }
        });

        superior.setBackground(new java.awt.Color(226, 106, 106));
        buttonGroup1.add(superior);
        superior.setSelected(true);
        superior.setText("SUPERRIOR");
        superior.setActionCommand("SUPERIOR");
        superior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superiorActionPerformed(evt);
            }
        });

        UPDATE.setBackground(new java.awt.Color(255, 255, 255));
        UPDATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UPDATE.setForeground(new java.awt.Color(226, 106, 106));
        UPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/icons8_Plus_48px_1.png"))); // NOI18N
        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(NomorKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(standar)
                        .addGap(35, 35, 35)
                        .addComponent(dobel)
                        .addGap(37, 37, 37)
                        .addComponent(superior)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(UPDATE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(NomorKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(standar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(superior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 390, 440));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("LIST UPDATE");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 220, 30));
        jPanel10.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 450, 10));

        searchupdate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel10.add(searchupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 140, 30));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 836, 611);
    }// </editor-fold>//GEN-END:initComponents

    private void standarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_standarActionPerformed

    private void dobelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobelActionPerformed

    private void superiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_superiorActionPerformed
private void get(){
    
     // TODO add your handling code here:
        try {
            DefaultTableModel md = new DefaultTableModel( new String [] {"Nomor kamar", "Tipe kamar"}, 0);
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost/rumah_sakit";
            String user = "root";
            String pas =  "";
            Connection con = DriverManager.getConnection(url, user, pas);
            Statement stm = con.createStatement();   
            ResultSet rs = stm.executeQuery("select*from room order by nomor_kamar asc");
            while(rs.next()){
               md.addRow(new Object[]{rs.getString(1),rs.getString(2)});
              
            }
           
           tabel_room.setModel(md);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Terjadi Kelasahan !!!");
        }
}
    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost/rumah_sakit";
            String user = "root";
            String pas =  "";
            Connection con = DriverManager.getConnection(url, user, pas);
           Statement stm = con.createStatement();
           String jenis;
           int harga;
            if (standar.isSelected()) {
                jenis="standar";
                harga = 300000;
                
            }else if(dobel.isSelected()){
                jenis="doubel";
                 harga = 500000;
            }else{
                jenis="superrior";
                 harga = 700000;
            }
            
         int selected = tabel_room.getSelectedRow();
          if(selected==-1){
              JOptionPane.showMessageDialog(null,"tidak ada baris yang dipilih");
              return;
          }  
            stm.executeUpdate("UPDATE room SET nomor_kamar='"+NomorKamar.getText()+"',jenis_kamar='"+jenis+"',harga='"+harga+"' WHERE nomor_kamar='"+tabel_room.getValueAt(selected, 0)+"'");
            get();
            JOptionPane.showMessageDialog(null,"kamar sudah ");
           
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nomor kamar sudah tidak dapat pakai lagi");
        }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
           FileOutputStream fileOut = null;
        try {
            TableModel tableModel = tabel_room.getModel();
            List<String> header = new ArrayList<String>();
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                header.add(tableModel.getColumnName(i));
            }
            List<List<Object>> data = new ArrayList<List<Object>>();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                List<Object> row = new ArrayList<Object>();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    row.add(tableModel.getValueAt(i, j));
                }
                data.add(row);
            }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet();
            HSSFRow rowHeader = sheet.createRow(0);
            for (int i = 0; i < header.size(); i++) {
                HSSFCell rowCell = rowHeader.createCell(i);
                rowCell.setCellValue(header.get(i));
            }
            for (int i = 0; i < data.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                List<Object> dataRow = data.get(i);
                for (int j = 0; j < dataRow.size(); j++) {
                    HSSFCell cell = row.createCell(j);
                    cell.setCellValue(dataRow.get(j).toString());
                }
            }
            String tempFile = "D:\\ datakamar.xls ";
            File fileTemp = new File(tempFile);
            if (fileTemp.exists()) {
                fileTemp.delete();
            }
            fileOut = new FileOutputStream(tempFile);
            workbook.write(fileOut);
            fileOut.close();
            Desktop.getDesktop().open(new File(tempFile));
        } catch (IOException ex) {
            Logger.getLogger(List_room.class.getName()).log(Level.SEVERE, null, ex);
       
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(List_room.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
       dispose();
        new awal().setVisible(true);
    }//GEN-LAST:event_homeMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                try {
                            String search = this.searchupdate.getText();
            DefaultTableModel md = new DefaultTableModel( new String[]{"Nomor kamar", "Tipe kamar"},0);
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost/rumah_sakit";
            String user = "root";
            String pas =  "";
            Connection con = DriverManager.getConnection(url, user, pas);
            Statement stm = con.createStatement();   
            ResultSet rs = stm.executeQuery("select*from room where nomor_kamar like '%"+search+"%'order by nomor_kamar asc");
            while(rs.next()){
               md.addRow(new Object[]{rs.getString(1),rs.getString(2)});
              
            }
           
           tabel_room.setModel(md);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Terjadi Kelasahan !!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(List_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_room().setVisible(true);
            }
        });
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField NomorKamar;
    private javax.swing.JButton UPDATE;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JRadioButton dobel;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField searchupdate;
    public javax.swing.JRadioButton standar;
    private javax.swing.JRadioButton superior;
    private javax.swing.JTable tabel_room;
    // End of variables declaration//GEN-END:variables
   
  

   
            
}
