/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psb;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author SBDBAC
 */
public class UpdateDataDiri extends javax.swing.JFrame {
private Connection dbConnection;
    private koneksi db = new koneksi();
    String nisn;
    String namaUpdate,tempatlahirUpdate,jenisKelaminUpdate,noHpUpdate,image;
    Date tglLahirUpdate;
    String bb,tb,gd;
    String namaSekolah, alamatSekolah;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
    /**
     * Creates new form InputNilai
     */
    public UpdateDataDiri() {
        initComponents();
        loadData();
//        cek();
//        setRadioButtonUpdate();
        data_update_jasmani();
        data_update_siswa();
        data_update_sekolah();
        System.out.println(UserDataDiri.getImage());
        jXDatePicker1.setFormats("yyyy-MM-dd");
        
    }
    
    private void load_image(){
        JFileChooser j = new JFileChooser(UserDataDiri.getImage());
        j.showOpenDialog(null);
        File f = j.getSelectedFile();
        String lokasi = UserDataDiri.getImage();
        ImageIcon icon = new ImageIcon(lokasi);
        inigambar.setIcon(icon);
    }
    public void cek(){
        try{
            if(UserSession.getNama().equalsIgnoreCase(null) || UserSession.getNisn().equalsIgnoreCase(null) || UserSession.getU_id().equals(null)){
            this.dispose();
            
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"login dulu "+ e);
        }
    }
    public void setRadioButtonUpdate(){
        if (jenisKelaminUpdate == "laki-laki") {
           rMale.setSelected(true);
        }else{
           rfemale.setSelected(true);
        }
    }
    
    public void data_update_siswa(){
        try{
            String sql = "SELECT * FROM siswa_baru_data_diri WHERE nisn = '" + UserSession.getNisn() +"'";
            Statement st = db.getConnection().createStatement();
            ResultSet rsUpdate = st.executeQuery(sql);
            while (rsUpdate.next()) {
//                namaUpdate,tempatlahirUpdate,tglLahirUpdate,jenisKelaminUpdate,noHpUpdate,image;
                nisn = rsUpdate.getString("nisn");
                namaUpdate = rsUpdate.getString("nama_lengkap");
                tempatlahirUpdate = rsUpdate.getString("tempat_lahir");
                tglLahirUpdate = rsUpdate.getDate("tanggal_lahir");
                jenisKelaminUpdate = rsUpdate.getString("jenis_kelamin");
                noHpUpdate = rsUpdate.getString("No_hp");
                image = rsUpdate.getString("image");
                
//                u_id = rsLogin.getString("id_user");
//                System.out.println("data didapatkan");
            }
            rsUpdate.last(); //mengecek jumlah baris pada hasil query
            if (rsUpdate.getRow()==1){
                UserDataDiri.setNisn(nisn);
                UserDataDiri.setNama(namaUpdate);
                UserDataDiri.setTempatlahir(tempatlahirUpdate);
                UserDataDiri.setTgl_lahir(tglLahirUpdate);
                UserDataDiri.setJenis_kelamin(jenisKelaminUpdate);
                UserDataDiri.setNo_hp(noHpUpdate);
                UserDataDiri.setImage(image);
                
//             
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        txtnama.setText(UserDataDiri.getNama());
        txttl.setText(UserDataDiri.getTempatlahir());
        txtnisn.setText(UserSession.getNisn());
        jXDatePicker1.setDate(UserDataDiri.getTgl_lahir());
        txtnohp.setText(noHpUpdate);
        String lokasi = UserDataDiri.getImage();
        ImageIcon icon = new ImageIcon(lokasi);
        inigambar.setIcon(icon);
    }
    
    private void data_update_jasmani(){
        
        try{
            String sql = "SELECT * FROM siswa_baru_ket_jasmani WHERE nisn = '" + UserSession.getNisn() +"'";
            Statement st = db.getConnection().createStatement();
            ResultSet rsUpdate = st.executeQuery(sql);
            while (rsUpdate.next()) {
//                namaUpdate,tempatlahirUpdate,tglLahirUpdate,jenisKelaminUpdate,noHpUpdate,image;
                bb = rsUpdate.getString("berat");
                tb = rsUpdate.getString("tinggi");
                gd = rsUpdate.getString("gol_darah");
//                u_id = rsLogin.getString("id_user");
//                System.out.println("data didapatkan");
            }
            rsUpdate.last(); //mengecek jumlah baris pada hasil query
            if (rsUpdate.getRow()==1){
                UserDataJasmani.setBb(bb);
                UserDataJasmani.setTb(tb);
                UserDataJasmani.setTb(tb);
                
//             
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        txtbb.setText(bb);
        txttb.setText(tb);
        txtgd.setText(gd);
   
    }
    
    private void data_update_sekolah(){
        try{
            String sql = "SELECT * FROM siswa_baru_ket_pend_sblmnya WHERE nisn = '" + UserSession.getNisn() +"'";
            Statement st = db.getConnection().createStatement();
            ResultSet rsUpdate = st.executeQuery(sql);
            while (rsUpdate.next()) {
//                namaUpdate,tempatlahirUpdate,tglLahirUpdate,jenisKelaminUpdate,noHpUpdate,image;
                namaSekolah = rsUpdate.getString("asal_sekolah");
                alamatSekolah = rsUpdate.getString("alamat_sekolah");
            }
            rsUpdate.last(); //mengecek jumlah baris pada hasil query
            if (rsUpdate.getRow()==1){
                UserDataSekolah.setNamaSekolah(namaSekolah);
                UserDataSekolah.setAlamatSekolah(alamatSekolah);
//             
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        txtnamasekolah.setText(namaSekolah);
        txtalamat.setText(alamatSekolah);
    }
    public void loadData(){
       db.dbConnection();
        try{
            String sql = "SELECT * FROM siswa_baru WHERE id_user = '" + UserSession.getU_id() +"'";
            Statement st = db.getConnection().createStatement();
            ResultSet rsLogin = st.executeQuery(sql);
            while (rsLogin.next()) {
                nisn = rsLogin.getString("nisn");
//                u_id = rsLogin.getString("id_user");
//                System.out.println("data didapatkan");
            }
            rsLogin.last(); //mengecek jumlah baris pada hasil query
            if (rsLogin.getRow()==1){
                UserSession.setNisn(nisn);
//                System.out.println("data di set");
            }else{
                System.out.println("data tidak di set ");
            }
            
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnisn = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txttl = new javax.swing.JTextField();
        rMale = new javax.swing.JRadioButton();
        rfemale = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        txtnohp = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtbb = new javax.swing.JTextField();
        txtgd = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txttb = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtnamasekolah = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        inigambar = new javax.swing.JLabel();
        txtLokasiFIle = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 171, 233));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PSB ( Penerimaan Siswa Baru ) SMA N 2 BACK-END");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(470, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 146, 213));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("A. Data Pribadi Siswa ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 146, 213));
        jLabel1.setText("NISN");

        jPanel4.setBackground(new java.awt.Color(0, 146, 213));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("B. Keterengan Jasmani");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 146, 213));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Upload Foto");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setText("*Ket.foto formal dengan ketentuan 3x4 dengan  background berwarna merah");

        jPanel5.setBackground(new java.awt.Color(0, 146, 213));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("C. Keterangan Pendidikan Sebelumnya");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 146, 213));
        jLabel8.setText("Nama Siswa Baru");

        Edit.setBackground(new java.awt.Color(0, 146, 213));
        Edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Edit");
        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 146, 213));
        jLabel15.setText("Jenis Kelamin");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 146, 213));
        jLabel16.setText("TTL");

        rMale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rMale.setForeground(new java.awt.Color(0, 146, 213));
        rMale.setText("Laki-laki");

        rfemale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rfemale.setForeground(new java.awt.Color(0, 146, 213));
        rfemale.setText("Perempuan");
        rfemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfemaleActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 146, 213));
        jLabel17.setText("No HP");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 146, 213));
        jLabel18.setText("Berat Badan");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 146, 213));
        jLabel19.setText("Tinggi Badan");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 146, 213));
        jLabel20.setText("Golongan Darah");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 146, 213));
        jLabel21.setText("Asal Sekolah");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 146, 213));
        jLabel22.setText("Alamat Sekolah");

        jPanel6.setBackground(new java.awt.Color(0, 146, 213));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("D. Upload Foto");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 146, 213));
        jLabel24.setText("KG");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 146, 213));
        jLabel25.setText("CM");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inigambar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inigambar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txttb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(txtbb, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgd))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel17))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtnama, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                                    .addComponent(txtnisn)
                                                    .addComponent(txttl)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(rMale)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rfemale)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22))
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnamasekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 231, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLokasiFIle))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Edit)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rMale)
                    .addComponent(rfemale))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txttb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtgd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtnamasekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLokasiFIle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rfemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rfemaleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFileChooser j = new JFileChooser("C:Users\\Lynn\\Downloads\\cpy-saofb\\TUBES\\PSB\\image");
        
        j.showOpenDialog(null);
        File f = j.getSelectedFile();
       
        String lokasi = f.getAbsolutePath();
        ImageIcon icon = new ImageIcon(lokasi);
        txtLokasiFIle.setText(lokasi);
        inigambar.setIcon(icon);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    String getGender()
    {
    if(rMale.isSelected())
    {
        return "laki-laki";
    }
    else if(rfemale.isSelected())
    {
        return "perempuan";
    }
    else
    {
        return null;
    }
    }
    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
//        String namaUpdate,tempatlahirUpdate,jenisKelaminUpdate,noHpUpdate,image;
         try{
//            inputan data diri
            if(nisn.isEmpty() || namaUpdate.isEmpty() || tempatlahirUpdate.isEmpty() || noHpUpdate.isEmpty()){
                JOptionPane.showMessageDialog(null, "data di data diri ada yang kosong");
            }else{
                try{
                    String sql = "UPDATE siswa_baru_data_diri SET nama_lengkap = '"+txtnama.getText()+"', tempat_lahir = '"+txttl.getText()+"'"
                            + ", tanggal_lahir = '"+sdf.format(tglLahirUpdate)+"', jenis_kelamin = '"+getGender()+"', no_hp = '"+txtnohp.getText()+"', image = '"+txtLokasiFIle.getText()+"'  "
                            + "WHERE nisn = '"+txtnisn.getText()+"'";
                    Statement st = db.getConnection().createStatement();
                    st.execute(sql);
//                    System.out.println("terupdate kamu bangsad");
//                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
//          update data jasmani
            if(tb.isEmpty() || bb.isEmpty() || gd.isEmpty() ){
                JOptionPane.showMessageDialog(null, "data di data diri ada yang kosong");
            }else{
                try{
                    String sql = "UPDATE siswa_baru_ket_jasmani SET berat = '"+txtbb.getText()+"', tinggi = '"+txttb.getText()+"'"
                            + ", gol_darah = '"+txtgd.getText()+"' "
                            + "WHERE nisn = '"+txtnisn.getText()+"'";
                    Statement st = db.getConnection().createStatement();
                    st.execute(sql);
//                    System.out.println("terupdate kamu bangsad");
//                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            
            if(namaSekolah.isEmpty() ||alamatSekolah.isEmpty()){
                JOptionPane.showMessageDialog(null, "data di data diri ada yang kosong");
            }else{
                try{
                    String sql = "UPDATE siswa_baru_ket_pend_sblmnya SET asal_sekolah = '"+txtnamasekolah.getText()+"', alamat_sekolah = '"+txtalamat.getText()+"'"
                            + "WHERE nisn = '"+txtnisn.getText()+"'";
                    Statement st = db.getConnection().createStatement();
                    st.execute(sql);
//                    System.out.println("terupdate kamu bangsad");
//                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         
         new PSBHome2().setVisible(true);
         this.dispose();
            
    }//GEN-LAST:event_EditActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jXDatePicker1ActionPerformed
   
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
            java.util.logging.Logger.getLogger(UpdateDataDiri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDataDiri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDataDiri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDataDiri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDataDiri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JLabel inigambar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JRadioButton rMale;
    private javax.swing.JRadioButton rfemale;
    private javax.swing.JTextField txtLokasiFIle;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtbb;
    private javax.swing.JTextField txtgd;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnamasekolah;
    private javax.swing.JTextField txtnisn;
    private javax.swing.JTextField txtnohp;
    private javax.swing.JTextField txttb;
    private javax.swing.JTextField txttl;
    // End of variables declaration//GEN-END:variables
}
