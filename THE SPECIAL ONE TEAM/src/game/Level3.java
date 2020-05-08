/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Damagree
 */
public class Level3 extends javax.swing.JFrame {

     public java.sql.Statement st;
    private int score = 0;
    private String namapemain;
    private boolean status1 = false;
    private boolean status2 = false;
     private java.sql.Connection db;
     private ArrayList<String> listsoal = new ArrayList<>();
     private ArrayList<String> listjawaban = new ArrayList<>();
     int indexsoal = 0; 

    public String getNamapemain() {
        return namapemain;
    }

    public void setNamapemain(String namapemain) {
        this.namapemain = namapemain;
    }
    public Level3() throws SQLException {
        initComponents();
        db = Conn.koneksiDB();
        nameplayer.setVisible(false);
        skorplayer.setVisible(false);
        pointtujuan.setVisible(false);
        soalnya.setVisible(false);
        jawab.setVisible(false);
        answer.setVisible(false);
        skorakhir.setVisible(false);
        selamat.setVisible(false);
        backmenu.setVisible(false);
        generateSoal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        pointtujuan = new javax.swing.JLabel();
        skorplayer = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        answer = new javax.swing.JButton();
        soalnya = new javax.swing.JLabel();
        jawab = new javax.swing.JTextField();
        play = new javax.swing.JButton();
        good = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        selamat = new javax.swing.JLabel();
        skorakhir = new javax.swing.JLabel();
        backmenu = new javax.swing.JButton();
        nameplayer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pointtujuan.setFont(new java.awt.Font("VAGRounded BT", 0, 18)); // NOI18N
        pointtujuan.setText("Expert");
        getContentPane().add(pointtujuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        skorplayer.setFont(new java.awt.Font("Fira Sans Black", 3, 36)); // NOI18N
        skorplayer.setText("SKOR  : 0");
        getContentPane().add(skorplayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        answer.setText("NEXT");
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });

        soalnya.setFont(new java.awt.Font("VAGRounded BT", 0, 14)); // NOI18N
        soalnya.setForeground(new java.awt.Color(255, 255, 255));
        soalnya.setText("Ada berapa ruanga 'A' di gedung Fakultas Ilmu Terapan Tel-U?");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(soalnya)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jawab, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(answer)
                        .addGap(60, 60, 60))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soalnya)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jawab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 660, 130));

        play.setText("PLAY");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 309, -1, -1));

        good.setFont(new java.awt.Font("Fira Sans SemiBold", 1, 48)); // NOI18N
        good.setText("Your name?");
        getContentPane().add(good, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 268, 325, -1));

        selamat.setFont(new java.awt.Font("Altair", 3, 48)); // NOI18N
        selamat.setText("Selamat!");
        getContentPane().add(selamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 230, -1));

        skorakhir.setFont(new java.awt.Font("Trajan Pro 3", 1, 48)); // NOI18N
        skorakhir.setText(".");
        getContentPane().add(skorakhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 450, -1));

        backmenu.setText("BACK TO MENU");
        backmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backmenuActionPerformed(evt);
            }
        });
        getContentPane().add(backmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 341, -1, -1));

        nameplayer.setFont(new java.awt.Font("Fira Sans Black", 0, 24)); // NOI18N
        nameplayer.setForeground(new java.awt.Color(255, 255, 255));
        nameplayer.setText("NAMA");
        getContentPane().add(nameplayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/savana.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 10, 850, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
           String jawaban = jawab.getText();
        if (listjawaban.get(indexsoal).equals(jawaban)){
            score+=100;
            indexsoal++;
            tampilSoal();
            
        } else {
            indexsoal++;
            tampilSoal();
        }
        jawab.setText("");
//        if(status1 == false && status2 == false){
//            if(jawab.getText().equalsIgnoreCase("7")){
//                JOptionPane.showMessageDialog(null, "BENAR");
//                poin+=10;
//                tambahskor();
//                point.setText("POIN  : "+poin);
//                skor.setText("SKOR   : "+score);
//                jawab.setText("");
//                pointtujuan.setText("2");
//                soalnya.setText("Nama lain Danau Galau Tel-U adalah ...");
//                status1 =true;
//
//            }else if(!jawab.getText().equalsIgnoreCase("7")){
//                JOptionPane.showMessageDialog(null, "SALAH");
//                poin -=10;
//                point.setText("POIN  : "+poin);
//                if(poin <= -50){
//                    JOptionPane.showMessageDialog(null, "GAME OVER");
//                    new MainMenu().setVisible(true);
//                    this.setVisible(false);
//                }
//            }
//        }
//
//        else if(status1 == true && status2 == false){
//            if(jawab.getText().equalsIgnoreCase("Situ Tekno")){
//                JOptionPane.showMessageDialog(null, "BENAR");
//                poin+=20;
//                tambahskor();
//                point.setText("POIN  : "+poin);
//                skor.setText("SKOR   : "+score);
//                jawab.setText("");
//                pointtujuan.setText("3");
//                soalnya.setText("Berapa ruangan multimedia di Gedung Tokong Nanas Tel-U?");
//                status2 =true;
//
//            }else if(!jawab.getText().equalsIgnoreCase("Situ Tekno")){
//                JOptionPane.showMessageDialog(null, "SALAH");
//                poin -=20;
//                point.setText("POIN  : "+poin);
//                if(poin <= -50){
//                    JOptionPane.showMessageDialog(null, "GAME OVER");
//                    new MainMenu().setVisible(true);
//                    this.setVisible(false);
//                }
//            }
//        }
//
//        else if(status2 == true && status1 == true){
//            if(jawab.getText().equalsIgnoreCase("8")){
//                JOptionPane.showMessageDialog(null, "BENAR");
//                poin+=30;
//                tambahskor();
//                point.setText("POIN  : "+poin);
//                skor.setText("SKOR   : "+score);
//                jawab.setText("");
//
//                skorakhir.setText("SKOR ANDA "+score);
//
//                namanya.setVisible(false);
//                skor.setVisible(false);
//                pointtujuan.setVisible(false);
//                point.setVisible(false);
//             
//                soalnya.setVisible(false);
//                jawab.setVisible(false);
//                serang.setVisible(false);
//                skorakhir.setVisible(true);
//                selamat.setVisible(true);
//                jButton1.setVisible(true);
//                
//                try {
//                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/high score tubes", "root", "");
//                    cn.createStatement().executeUpdate("insert into highscore3 value('"
//                        + getNamapemain()+"','"
//                        + score+"')");
//                } catch (SQLException ex) {
//                    System.out.println(ex);
//                }
//                
//            }else if(jawab.getText().equalsIgnoreCase("8")){
//                JOptionPane.showMessageDialog(null, "SALAH");
//                poin -=30;
//                point.setText("POIN  : "+poin);
//                if(poin <= -50){
//                    JOptionPane.showMessageDialog(null, "GAME OVER");
//                    new MainMenu().setVisible(true);
//                    this.setVisible(false);
//                }
//            }
//
//        }
    }//GEN-LAST:event_answerActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        Cookies.setName(name.getText());
        tampilSoal();
//setNamapemain(name.getText());
        nameplayer.setText(Cookies.getName());
        nameplayer.setVisible(true);
        skorplayer.setVisible(true);
        pointtujuan.setVisible(true);
        soalnya.setVisible(true);
        jawab.setVisible(true);
        answer.setVisible(true);
        play.setVisible(false);
        name.setVisible(false);
        good.setVisible(false);
    }//GEN-LAST:event_playActionPerformed

    private void backmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backmenuActionPerformed
        new MainMenu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backmenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answer;
    private javax.swing.JButton backmenu;
    private javax.swing.JLabel good;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jawab;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameplayer;
    private javax.swing.JButton play;
    private javax.swing.JLabel pointtujuan;
    private javax.swing.JLabel selamat;
    private javax.swing.JLabel skorakhir;
    private javax.swing.JLabel skorplayer;
    private javax.swing.JLabel soalnya;
    // End of variables declaration//GEN-END:variables

    private void generateSoal() {
    try {
            java.sql.Statement soal = db.createStatement();
            ResultSet hasil = soal.executeQuery("select * from question where level = 3 order by RAND() limit 10");
            while(hasil.next()){
                listsoal.add(hasil.getString("soal"));
                listjawaban.add(hasil.getString("jawaban"));
            }
} catch (Exception e){
        System.out.println("GS : "+e);
}    
    }

    private void tampilSoal() {
    String soalskrg = listsoal.get(indexsoal);
    if (indexsoal == listsoal.size()-1) {
        nameplayer.setText(Cookies.getName());  
        nameplayer.setVisible(true);
        skorakhir.setText("Skor anda"+Integer.toString(+score));
        selamat.setVisible(true);
        skorakhir.setVisible(true);
        skorplayer.setVisible(false);
        backmenu.setVisible(true);
        answer.setVisible(false);
        try {
            java.sql.Statement stmt = db.createStatement();
            stmt.execute("insert into user(name) values('"+Cookies.getName()+"')", java.sql.Statement.RETURN_GENERATED_KEYS);
            ResultSet id = stmt.getGeneratedKeys();
            id.next();
            int iduser = id.getInt(1);
            stmt.execute("insert into score(id_user,score,level) Values("+iduser+","+score+",3)");
        } catch (Exception e){
            
        }
    } else {
        soalnya.setText(soalskrg);
        skorplayer.setText(Integer.toString(score));
        
    }
    }
}
