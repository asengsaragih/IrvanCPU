/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tebakaku;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Febby Dahlan
 */
public class TebakGambar extends javax.swing.JFrame {

    /**
     * Creates new form TebakTumbuhan
     */
    private Connection connection;
    private int indexSoal, skorUser,counter;
    private ArrayList<ImageIcon> soalQuiz = new ArrayList<ImageIcon>();
    private ArrayList<String> jawabanQuiz = new ArrayList<String>();
    private ArrayList<String> pilihanJawaban = new ArrayList<String>();
    private Timer timer = new Timer();

    public TebakGambar() {
        initComponents();
        // Koneksi Ke database
        connection = Config.databaseConnection();
        // Mengatur Jframe menjadi ke tengah
        this.setLocationRelativeTo(null);
        // Generate soal dari database
        generateSoal();
        // Tampil soal
        tampilSoal();
        // Timer Game
        timerGame();
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
        jLabel1 = new javax.swing.JLabel();
        textWaktu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Close = new javax.swing.JLabel();
        Mini = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textSkor = new javax.swing.JLabel();
        gambarSoal = new javax.swing.JLabel();
        btnPilihanA = new javax.swing.JLabel();
        btnPilihanB = new javax.swing.JLabel();
        btnPilihanC = new javax.swing.JLabel();
        btnPilihanD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(137, 196, 244));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Waktu :");

        textWaktu.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        textWaktu.setText("0");

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel2.setText("Tebak Gambar");

        Close.setBackground(new java.awt.Color(255, 255, 255));
        Close.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Close.setText("x");
        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
        });

        Mini.setBackground(new java.awt.Color(255, 255, 255));
        Mini.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        Mini.setText("-");
        Mini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MiniMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(128, 128, 128)
                .addComponent(Mini)
                .addGap(18, 18, 18)
                .addComponent(Close)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Mini, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Skor :");

        textSkor.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        textSkor.setText("0");

        gambarSoal.setBackground(new java.awt.Color(255, 255, 255));
        gambarSoal.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        gambarSoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambarSoal.setText("Soal");

        btnPilihanA.setBackground(new java.awt.Color(255, 255, 0));
        btnPilihanA.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnPilihanA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPilihanA.setText("Pilihan A");
        btnPilihanA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihanA.setOpaque(true);
        btnPilihanA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilihanAMouseClicked(evt);
            }
        });

        btnPilihanB.setBackground(new java.awt.Color(255, 255, 0));
        btnPilihanB.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnPilihanB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPilihanB.setText("Pilihan B");
        btnPilihanB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihanB.setOpaque(true);
        btnPilihanB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilihanBMouseClicked(evt);
            }
        });

        btnPilihanC.setBackground(new java.awt.Color(255, 255, 0));
        btnPilihanC.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnPilihanC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPilihanC.setText("Pilihan C");
        btnPilihanC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihanC.setOpaque(true);
        btnPilihanC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilihanCMouseClicked(evt);
            }
        });

        btnPilihanD.setBackground(new java.awt.Color(255, 255, 0));
        btnPilihanD.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        btnPilihanD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPilihanD.setText("Pilihan D");
        btnPilihanD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihanD.setOpaque(true);
        btnPilihanD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilihanDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textWaktu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSkor)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gambarSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(btnPilihanA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPilihanB, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPilihanC, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPilihanD, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textWaktu)
                    .addComponent(jLabel3)
                    .addComponent(textSkor))
                .addGap(18, 18, 18)
                .addComponent(gambarSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPilihanA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihanB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihanC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilihanD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        //untuk menutup/meng-close landing page
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void MiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MiniMouseClicked
        // TODO add your handling code here:
        //untuk me-minimize landing page
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MiniMouseClicked

    private void timerGame(){
        // Timer Soal
        counter = 180;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                textWaktu.setText(Integer.toString(counter));
                counter--;
                if(counter == -1){
                    JOptionPane.showMessageDialog(rootPane, "Waktu Habis");
                    timer.cancel();
                    new MainMenu().setVisible(true);
                    setVisible(false);
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }
    private void generateSoal(){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quiz_tebak_gambar ORDER BY RAND() LIMIT 5");
            while(resultSet.next()){
                soalQuiz.add(new ImageIcon(resultSet.getString("soal_quiz")));
                jawabanQuiz.add(resultSet.getString("jawaban_quiz"));
                pilihanJawaban.add(resultSet.getString("pilihan_quiz"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void tampilSoal(){
        try{
            ImageIcon soalSekarang = this.soalQuiz.get(indexSoal);
//            gambarSoal.setText("<html>"+soalSekarang+"</html>");
            String pilihan = this.pilihanJawaban.get(indexSoal);
            String[] jawaban = pilihan.split(",");
            btnPilihanA.setText(jawaban[0]);
            btnPilihanB.setText(jawaban[1]);
            btnPilihanC.setText(jawaban[2]);
            btnPilihanD.setText(jawaban[3]);  
            
            // Tampil Gambar Soal
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT soal_quiz FROM quiz_tebak_gambar");
            resultSet.next();
            ImageIcon imageIcon = soalSekarang;
            Image settings = imageIcon.getImage();
            Image imageScaled = settings.getScaledInstance(gambarSoal.getWidth(), gambarSoal.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon settingsImage = new ImageIcon(imageScaled);
            gambarSoal.setIcon(settingsImage);
            
        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void getButtonJawaban(String btn){
        try{
            String jawabanUser = btn;
            String jawabanBenar = jawabanQuiz.get(indexSoal);
            if(jawabanUser.equalsIgnoreCase(jawabanBenar)){
                skorUser += 10;
                indexSoal++;
                tampilSoal();
                textSkor.setText(""+skorUser);
            }else{
                indexSoal++;
                tampilSoal();
            }
            if(indexSoal == soalQuiz.size()){
                if(CookiesUser.getSkorTebakAku() < skorUser){
                    Statement statement = connection.createStatement();
                    statement.execute("UPDATE temp_name SET skor_tebak_gambar = '"+skorUser+"' WHERE nameUser = '"+CookiesUser.getNamaUser()+"'");
                }
                JOptionPane.showMessageDialog(this, "Yeahh selamat, skor kamu : "+skorUser);
                timer.cancel();
                new MainMenu().setVisible(true);
                this.setVisible(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void btnPilihanAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilihanAMouseClicked
        // TODO add your handling code here:
        getButtonJawaban(btnPilihanA.getText());
    }//GEN-LAST:event_btnPilihanAMouseClicked

    private void btnPilihanBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilihanBMouseClicked
        // TODO add your handling code here:
        getButtonJawaban(btnPilihanB.getText());
    }//GEN-LAST:event_btnPilihanBMouseClicked

    private void btnPilihanCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilihanCMouseClicked
        // TODO add your handling code here:
        getButtonJawaban(btnPilihanC.getText());
    }//GEN-LAST:event_btnPilihanCMouseClicked

    private void btnPilihanDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilihanDMouseClicked
        // TODO add your handling code here:
        getButtonJawaban(btnPilihanD.getText());
    }//GEN-LAST:event_btnPilihanDMouseClicked

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
            java.util.logging.Logger.getLogger(TebakGambar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TebakGambar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TebakGambar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TebakGambar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TebakGambar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Close;
    private javax.swing.JLabel Mini;
    private javax.swing.JLabel btnPilihanA;
    private javax.swing.JLabel btnPilihanB;
    private javax.swing.JLabel btnPilihanC;
    private javax.swing.JLabel btnPilihanD;
    private javax.swing.JLabel gambarSoal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel textSkor;
    private javax.swing.JLabel textWaktu;
    // End of variables declaration//GEN-END:variables
}
