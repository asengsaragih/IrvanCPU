/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentrust;

import java.awt.Color;
import javax.swing.JPanel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hisyam Fadhil
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    private Connection db;

    public MainMenu() throws SQLException {
        initComponents();
        db = config.koneksiDB();

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(homePane);
        mainPanel.repaint();
        mainPanel.revalidate();

        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        lbl_date.setText(sdf.format(cal.getTime()));

        getoutBarang();
        getinBarang();
        getidBarang();
        getidKonsumen();
        tampilTemp();
        otoIdKonsumen();
        otoIdTransaksi();
        getidDistributor();
        getidGudang();
        otoIdBarang();
        otoinIdTransaksi();
        getIdAdmin();
        txt_Adm.setText(SessionCookies.getNmAdm());

    }

    public MainMenu(ArrayList<String> e) {
        initComponents();
//        mainPanel.removeAll();
//        mainPanel.repaint();
//        mainPanel.revalidate();
//
//        txt_barang.setText(e.get(0));
//        txt_harga.setText(e.get(1));
//        mainPanel.add(outBarangPane);
//        mainPanel.repaint();
//        mainPanel.revalidate();

        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd/MM/yyy");
        lbl_date.setText(sdf.format(cal.getTime()));
    }

    private void getIdAdmin(){
        txt_admin.setText(SessionCookies.getIdAdm());
    }
    
    private void getidDistributor() {
        try {
            Connection conn = (Connection) config.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT id_distributor , nm_distributor from tbl_distributor");
            while (rs.next()) {
                cb_distributor.addItem(rs.getString("id_distributor" ) + "-" + rs.getString("nm_distributor"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void getidBarang() {
        try {
            Connection conn = (Connection) config.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT id_barang, nm_barang from tbl_barang");
            while (rs.next()) {
                cb_idBarang.addItem(rs.getString("id_barang" ) + "-" + rs.getString("nm_barang"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
    }

    private void getidKonsumen(){
        try {
            Connection conn = (Connection) config.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT id_konsumen, nm_konsumen FROM tbl_konsumen");
            while (rs.next()) {
                cb_konsumen.addItem(rs.getString("id_konsumen" ) + "-" + rs.getString("nm_konsumen"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }

    private void getidGudang() {
        try {
            Connection conn = (Connection) config.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT id_gudang from tbl_gudang");
            while (rs.next()) {
                cb_gudang.addItem(rs.getString("id_gudang"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void otoIdKonsumen() {
        try {
            String sql = "select * from tbl_konsumen order by id_konsumen desc";
            java.sql.Connection con = (Connection) config.koneksiDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("id_konsumen").substring(2);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txt_idKonsumen.setText("KN" + Nol + AN);
            } else {
                txt_idKonsumen.setText("Gagal");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void otoIdTransaksi() {
        try {
            String sql = "select * from tbl_transaksi order by id_transaksi desc";
            java.sql.Connection con = (Connection) config.koneksiDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String nofak = rs.getString("id_transaksi").substring(3);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txt_transaksi.setText("TRX" + Nol + AN);
            } else {
                txt_transaksi.setText("TRX0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void otoinIdTransaksi(){
        try {
            String sql = "select * from tbl_detailbeli order by id_detbeli desc";
            java.sql.Connection con = (Connection) config.koneksiDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("id_detbeli").substring(3);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txt_inTransaksi.setText("TRI" + Nol + AN);
            } else {
                txt_inTransaksi.setText("TRI0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        
    }

    private void otoIdDistributor() {
        try {
            String sql = "select * from tbl_distributor order by id_distributor desc";
            java.sql.Connection con = (Connection) config.koneksiDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("id_distributor").substring(2);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txt_idDistributor.setText("DS" + Nol + AN);
            } else {
                txt_idDistributor.setText("DS0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void otoIdBarang() {
        try {
            String sql = "select * from tbl_barang order by id_barang desc";
            java.sql.Connection con = (Connection) config.koneksiDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("id_barang").substring(2);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txt_inIdBarang.setText("BR" + Nol + AN);
            } else {
                txt_inIdBarang.setText("BR001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void clearDistributorText() {
        txt_nmDistributor.setText("");
        txt_almtDistributor.setText("");
        txt_noTelpDistributor.setText("");
    }

    public void getoutBarang() throws SQLException {
        String query = "SELECT SUM(qty) FROM tbl_detailtransaksi";
        java.sql.Connection conn = (Connection) config.koneksiDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(query);
        pst.executeQuery(query);
        ResultSet result = pst.executeQuery();
        result.next();

        if (result.getString(1) == null) {
            lbl_show.setText("0");
        } else {
            lbl_showout.setText(result.getString(1));
        }
    }

    public void getinBarang() throws SQLException {
        String query = "SELECT SUM(qty) FROM tbl_detailbeli";
        java.sql.Connection conn = (Connection) config.koneksiDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(query);
        pst.executeQuery(query);
        ResultSet result = pst.executeQuery();
        result.next();

        if (result.getString(1) == null) {
            lbl_show.setText("0");
        } else {
            lbl_show.setText(result.getString(1));
        }

    }

    private void clearKonsumenText() {
        txt_nmKonsumen.setText("");
        txt_almtKonsumen.setText("");
        txt_noTelpKonsumen.setText("");
    }

    private void jumlahTotal() {
        int qty;
        int hrgSatuan;
        int total;

        String result;

        qty = Integer.valueOf(txt_qty.getText());
        hrgSatuan = Integer.valueOf(txt_harga.getText());
        total = hrgSatuan * qty;

        result = String.valueOf(total);

        txt_totHarga.setText(result);
    }

    private void loadDataKonsumen() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID KONSUMEN");
        model.addColumn("NAMA KONSUMEN");
        model.addColumn("ALAMAT KONSUMEN");
        model.addColumn("NO TELP");

        try {
            String query = "SELECT * FROM tbl_konsumen";
            java.sql.Connection conn = (Connection) config.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(query);

            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            tbl_konsumen.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void loadDataDistributor() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID DISTRIBUTOR");
        model.addColumn("NAMA DISTRIBUTOR");
        model.addColumn("ALAMAT DISTRIBUTOR");
        model.addColumn("NO TELP");

        try {
            String query = "SELECT * FROM tbl_distributor";
            java.sql.Connection conn = (Connection) config.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(query);

            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            tbl_distributor.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    DefaultTableModel model;

    private void tempOutBarang() throws SQLException {
        model = new DefaultTableModel();
        tbl_tempOutBarang.setModel(model);
        model.addColumn("ID TRANSAKSI");
        model.addColumn("ID BARANG");
        model.addColumn("QUANTITY");
        model.addColumn("HARGA SATUAN");

    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(51, 102, 255));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(51, 153, 255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_beranda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ind_beranda = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_distributor = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ind_distributor = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btn_konsumen = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ind_konsumen = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btn_inBarang = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ind_inBarang = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn_outBarang = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ind_outBarang = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_Adm = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        distributorPane = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_distributor = new javax.swing.JTable();
        btn_delete = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btn_updateDistributor = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Label_IDDistributor = new javax.swing.JLabel();
        txt_idDistributor = new javax.swing.JTextField();
        txt_nmDistributor = new javax.swing.JTextField();
        Label_NamaDistributor = new javax.swing.JLabel();
        txt_almtDistributor = new javax.swing.JTextField();
        Label_AlamatDistributor = new javax.swing.JLabel();
        txt_noTelpDistributor = new javax.swing.JTextField();
        Label_NoTelp = new javax.swing.JLabel();
        btn_insertDistributor = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        homePane = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbl_show = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lbl_showout = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_showPem = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_showReq = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        konsumenPane = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_konsumen = new javax.swing.JTable();
        btn_delete1 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btn_update1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Label_IDDistributor1 = new javax.swing.JLabel();
        txt_idKonsumen = new javax.swing.JTextField();
        txt_nmKonsumen = new javax.swing.JTextField();
        Label_NamaDistributor1 = new javax.swing.JLabel();
        txt_almtKonsumen = new javax.swing.JTextField();
        Label_AlamatDistributor1 = new javax.swing.JLabel();
        txt_noTelpKonsumen = new javax.swing.JTextField();
        Label_NoTelp1 = new javax.swing.JLabel();
        btn_insertKonsumen = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        inBarangPane = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Label_IDDistributor2 = new javax.swing.JLabel();
        txt_inTransaksi = new javax.swing.JTextField();
        Label_NamaDistributor2 = new javax.swing.JLabel();
        Label_AlamatDistributor2 = new javax.swing.JLabel();
        Label_NoTelp2 = new javax.swing.JLabel();
        btn_insertBarang = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_hrgBarang = new javax.swing.JTextField();
        Label_AlamatDistributor3 = new javax.swing.JLabel();
        txt_stokBarang = new javax.swing.JTextField();
        Label_NamaDistributor3 = new javax.swing.JLabel();
        txt_nmBarang = new javax.swing.JTextField();
        Label_IDDistributor3 = new javax.swing.JLabel();
        cb_gudang = new javax.swing.JComboBox();
        cb_distributor = new javax.swing.JComboBox();
        txt_inIdBarang = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        cb_jsBarang = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_shwoTransaksi = new javax.swing.JTable();
        btn_delete2 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        outBarangPane = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        Label_IDDistributor4 = new javax.swing.JLabel();
        txt_transaksi = new javax.swing.JTextField();
        Label_NamaDistributor4 = new javax.swing.JLabel();
        Label_AlamatDistributor4 = new javax.swing.JLabel();
        btn_addData = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        Label_AlamatDistributor5 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        Label_NamaDistributor5 = new javax.swing.JLabel();
        Label_IDDistributor5 = new javax.swing.JLabel();
        txt_admin = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txt_totHarga = new javax.swing.JTextField();
        cb_idBarang = new javax.swing.JComboBox();
        cb_konsumen = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_tempOutBarang = new javax.swing.JTable();
        btn_delete3 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btn_update3 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        btn_save = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        reqPane = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_date = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        parent.setBackground(new java.awt.Color(255, 255, 255));

        sidepane.setBackground(new java.awt.Color(51, 153, 255));

        btn_beranda.setBackground(new java.awt.Color(51, 153, 255));
        btn_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_berandaMousePressed(evt);
            }
        });
        btn_beranda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Home_32px.png"))); // NOI18N
        btn_beranda.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        ind_beranda.setBackground(new java.awt.Color(255, 255, 255));
        ind_beranda.setEnabled(false);
        ind_beranda.setOpaque(false);

        javax.swing.GroupLayout ind_berandaLayout = new javax.swing.GroupLayout(ind_beranda);
        ind_beranda.setLayout(ind_berandaLayout);
        ind_berandaLayout.setHorizontalGroup(
            ind_berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ind_berandaLayout.setVerticalGroup(
            ind_berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btn_beranda.add(ind_beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, -1));

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Beranda");
        btn_beranda.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 30));

        jLabel3.setFont(new java.awt.Font("Open Sans ExtraBold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TRUST");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("INVENT");

        jLabel5.setFont(new java.awt.Font("Open Sans", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Your Trusted Inventory");

        btn_distributor.setBackground(new java.awt.Color(51, 153, 255));
        btn_distributor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_distributorMousePressed(evt);
            }
        });
        btn_distributor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/People_32px.png"))); // NOI18N
        btn_distributor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        ind_distributor.setBackground(new java.awt.Color(255, 255, 255));
        ind_distributor.setEnabled(false);
        ind_distributor.setOpaque(false);

        javax.swing.GroupLayout ind_distributorLayout = new javax.swing.GroupLayout(ind_distributor);
        ind_distributor.setLayout(ind_distributorLayout);
        ind_distributorLayout.setHorizontalGroup(
            ind_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ind_distributorLayout.setVerticalGroup(
            ind_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btn_distributor.add(ind_distributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, -1));

        jLabel17.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Distributor");
        btn_distributor.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 30));

        btn_konsumen.setBackground(new java.awt.Color(51, 153, 255));
        btn_konsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_konsumenMousePressed(evt);
            }
        });
        btn_konsumen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/User Groups_32px.png"))); // NOI18N
        btn_konsumen.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        ind_konsumen.setBackground(new java.awt.Color(255, 255, 255));
        ind_konsumen.setEnabled(false);
        ind_konsumen.setOpaque(false);

        javax.swing.GroupLayout ind_konsumenLayout = new javax.swing.GroupLayout(ind_konsumen);
        ind_konsumen.setLayout(ind_konsumenLayout);
        ind_konsumenLayout.setHorizontalGroup(
            ind_konsumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ind_konsumenLayout.setVerticalGroup(
            ind_konsumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btn_konsumen.add(ind_konsumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, -1));

        jLabel18.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Konsumen");
        btn_konsumen.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 30));

        btn_inBarang.setBackground(new java.awt.Color(51, 153, 255));
        btn_inBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_inBarangMousePressed(evt);
            }
        });
        btn_inBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Import_32px.png"))); // NOI18N
        btn_inBarang.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        ind_inBarang.setBackground(new java.awt.Color(255, 255, 255));
        ind_inBarang.setEnabled(false);
        ind_inBarang.setOpaque(false);

        javax.swing.GroupLayout ind_inBarangLayout = new javax.swing.GroupLayout(ind_inBarang);
        ind_inBarang.setLayout(ind_inBarangLayout);
        ind_inBarangLayout.setHorizontalGroup(
            ind_inBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ind_inBarangLayout.setVerticalGroup(
            ind_inBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btn_inBarang.add(ind_inBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, -1));

        jLabel19.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Barang Masuk");
        btn_inBarang.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 30));

        btn_outBarang.setBackground(new java.awt.Color(51, 153, 255));
        btn_outBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_outBarangMousePressed(evt);
            }
        });
        btn_outBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Export_32px.png"))); // NOI18N
        btn_outBarang.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        ind_outBarang.setBackground(new java.awt.Color(255, 255, 255));
        ind_outBarang.setEnabled(false);
        ind_outBarang.setOpaque(false);

        javax.swing.GroupLayout ind_outBarangLayout = new javax.swing.GroupLayout(ind_outBarang);
        ind_outBarang.setLayout(ind_outBarangLayout);
        ind_outBarangLayout.setHorizontalGroup(
            ind_outBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ind_outBarangLayout.setVerticalGroup(
            ind_outBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        btn_outBarang.add(ind_outBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, -1));

        jLabel20.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Barang Keluar");
        btn_outBarang.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, 30));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Male User_96px_white.png"))); // NOI18N

        txt_Adm.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        txt_Adm.setForeground(new java.awt.Color(255, 255, 255));
        txt_Adm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Adm.setText("Nama Admin");

        jLabel23.setFont(new java.awt.Font("Open Sans Light", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Admin");

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_beranda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_distributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_konsumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_inBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_outBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sidepaneLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5)))
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Adm)
                            .addComponent(jLabel23))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txt_Adm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)))
                .addGap(18, 18, 18)
                .addComponent(btn_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_distributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_konsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_inBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_outBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Delete_32px.png"))); // NOI18N
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        distributorPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel12.setText("DISTRIBUTOR");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_distributor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Distributor", "Nama_Distributor", "Alamat_Distributor", "No_Telp"
            }
        ));
        tbl_distributor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_distributorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_distributor);

        btn_delete.setBackground(new java.awt.Color(51, 153, 255));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_deleteMousePressed(evt);
            }
        });
        btn_delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("DELETE");
        btn_delete.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Trash Can_32px.png"))); // NOI18N
        btn_delete.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        btn_updateDistributor.setBackground(new java.awt.Color(51, 153, 255));
        btn_updateDistributor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_updateDistributorMousePressed(evt);
            }
        });
        btn_updateDistributor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("UPDATE");
        btn_updateDistributor.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Edit File_32px.png"))); // NOI18N
        btn_updateDistributor.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 153, 255)));

        Label_IDDistributor.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_IDDistributor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_IDDistributor.setText("ID DISTRIBUTOR");

        txt_idDistributor.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_idDistributor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_idDistributor.setEnabled(false);

        txt_nmDistributor.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_nmDistributor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_NamaDistributor.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NamaDistributor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NamaDistributor.setText("NAMA DISTRIBUTOR");

        txt_almtDistributor.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_almtDistributor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_AlamatDistributor.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_AlamatDistributor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AlamatDistributor.setText("ALAMAT DISTRIBUTOR");

        txt_noTelpDistributor.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_noTelpDistributor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_NoTelp.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NoTelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NoTelp.setText("NO TELP");

        btn_insertDistributor.setBackground(new java.awt.Color(51, 153, 255));
        btn_insertDistributor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_insertDistributorMousePressed(evt);
            }
        });
        btn_insertDistributor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("INSERT");
        btn_insertDistributor.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 95, 32));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Add New_32px.png"))); // NOI18N
        btn_insertDistributor.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_insertDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_AlamatDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NamaDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_IDDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_noTelpDistributor)
                            .addComponent(txt_idDistributor)
                            .addComponent(txt_nmDistributor)
                            .addComponent(txt_almtDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_idDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(Label_IDDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nmDistributor)
                    .addComponent(Label_NamaDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_almtDistributor)
                    .addComponent(Label_AlamatDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_noTelpDistributor)
                    .addComponent(Label_NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_insertDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(663, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_updateDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_updateDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout distributorPaneLayout = new javax.swing.GroupLayout(distributorPane);
        distributorPane.setLayout(distributorPaneLayout);
        distributorPaneLayout.setHorizontalGroup(
            distributorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(distributorPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(distributorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(distributorPaneLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        distributorPaneLayout.setVerticalGroup(
            distributorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(distributorPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(distributorPane, "card3");

        homePane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel11.setText("BERANDA");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lbl_show.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        lbl_show.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_show, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jLabel31.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Jumlah Barang Masuk");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        lbl_showout.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        lbl_showout.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_showout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showout, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jLabel32.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Jumlah Barang Keluar");

        jLabel55.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Pemasukan");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        lbl_showPem.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        lbl_showPem.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_showPem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showPem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        lbl_showReq.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        lbl_showReq.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_showReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_showReq, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jLabel56.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText(" Request Barang");

        javax.swing.GroupLayout homePaneLayout = new javax.swing.GroupLayout(homePane);
        homePane.setLayout(homePaneLayout);
        homePaneLayout.setHorizontalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        homePaneLayout.setVerticalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(40, 40, 40)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePaneLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(605, Short.MAX_VALUE))
        );

        mainPanel.add(homePane, "card2");

        konsumenPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel13.setText("KONSUMEN");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_konsumen.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        tbl_konsumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Konsumen", "Nama_Konsumen", "Alamat_Konsumen", "No_Telp"
            }
        ));
        tbl_konsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_konsumenMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_konsumen);

        btn_delete1.setBackground(new java.awt.Color(51, 153, 255));
        btn_delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_delete1MousePressed(evt);
            }
        });
        btn_delete1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("DELETE");
        btn_delete1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Trash Can_32px.png"))); // NOI18N
        btn_delete1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        btn_update1.setBackground(new java.awt.Color(51, 153, 255));
        btn_update1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_update1MousePressed(evt);
            }
        });
        btn_update1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("UPDATE");
        btn_update1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Edit File_32px.png"))); // NOI18N
        btn_update1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 153, 255)));

        Label_IDDistributor1.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_IDDistributor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_IDDistributor1.setText("ID KONSUMEN");

        txt_idKonsumen.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_idKonsumen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_idKonsumen.setEnabled(false);

        txt_nmKonsumen.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_nmKonsumen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_NamaDistributor1.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NamaDistributor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NamaDistributor1.setText("NAMA KONSUMEN");

        txt_almtKonsumen.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_almtKonsumen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_AlamatDistributor1.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_AlamatDistributor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AlamatDistributor1.setText("ALAMAT KONSUMEN");

        txt_noTelpKonsumen.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_noTelpKonsumen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_NoTelp1.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NoTelp1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NoTelp1.setText("NO TELP");

        btn_insertKonsumen.setBackground(new java.awt.Color(51, 153, 255));
        btn_insertKonsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_insertKonsumenMousePressed(evt);
            }
        });
        btn_insertKonsumen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("INSERT");
        btn_insertKonsumen.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 95, 32));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Add New_32px.png"))); // NOI18N
        btn_insertKonsumen.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_insertKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_AlamatDistributor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NoTelp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NamaDistributor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_IDDistributor1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_noTelpKonsumen)
                            .addComponent(txt_idKonsumen)
                            .addComponent(txt_nmKonsumen)
                            .addComponent(txt_almtKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_idKonsumen, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(Label_IDDistributor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nmKonsumen)
                    .addComponent(Label_NamaDistributor1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_almtKonsumen)
                    .addComponent(Label_AlamatDistributor1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_noTelpKonsumen)
                    .addComponent(Label_NoTelp1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_insertKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_update1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1004, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout konsumenPaneLayout = new javax.swing.GroupLayout(konsumenPane);
        konsumenPane.setLayout(konsumenPaneLayout);
        konsumenPaneLayout.setHorizontalGroup(
            konsumenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(konsumenPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(konsumenPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        konsumenPaneLayout.setVerticalGroup(
            konsumenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(konsumenPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        mainPanel.add(konsumenPane, "card4");

        inBarangPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel14.setText("BARANG MASUK");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 153, 255)));

        Label_IDDistributor2.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_IDDistributor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_IDDistributor2.setText("ID TRANSAKSI");

        txt_inTransaksi.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_inTransaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_inTransaksi.setEnabled(false);

        Label_NamaDistributor2.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NamaDistributor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NamaDistributor2.setText("ID BARANG");

        Label_AlamatDistributor2.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_AlamatDistributor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AlamatDistributor2.setText("ID DISTRIBUTOR");

        Label_NoTelp2.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NoTelp2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NoTelp2.setText("PILIH GUDANG");

        btn_insertBarang.setBackground(new java.awt.Color(51, 153, 255));
        btn_insertBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_insertBarangMousePressed(evt);
            }
        });
        btn_insertBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("TAMBAH");
        btn_insertBarang.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 95, 32));

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Add New_32px.png"))); // NOI18N
        btn_insertBarang.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

        txt_hrgBarang.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_hrgBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_AlamatDistributor3.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_AlamatDistributor3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AlamatDistributor3.setText("HARGA SATUAN");

        txt_stokBarang.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_stokBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_NamaDistributor3.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NamaDistributor3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NamaDistributor3.setText("STOK BARANG");

        txt_nmBarang.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_nmBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_IDDistributor3.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_IDDistributor3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_IDDistributor3.setText("NAMA BARANG");

        cb_gudang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Gudang" }));

        cb_distributor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Distributor" }));

        txt_inIdBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 153, 255)));

        jLabel57.setText("JENIS BARANG");

        cb_jsBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Jenis Barang", "Minuman", "Makanan" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_AlamatDistributor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_NoTelp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_NamaDistributor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_IDDistributor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_inTransaksi)
                    .addComponent(cb_gudang, 0, 454, Short.MAX_VALUE)
                    .addComponent(cb_distributor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_inIdBarang)
                    .addComponent(cb_jsBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_AlamatDistributor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NamaDistributor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_IDDistributor3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nmBarang)
                            .addComponent(txt_stokBarang)
                            .addComponent(txt_hrgBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_insertBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_inTransaksi)
                            .addComponent(Label_IDDistributor2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_NamaDistributor2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(txt_inIdBarang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_AlamatDistributor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_distributor, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addComponent(Label_AlamatDistributor3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_hrgBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nmBarang)
                            .addComponent(Label_IDDistributor3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_stokBarang)
                            .addComponent(Label_NamaDistributor3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_NoTelp2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_gudang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_jsBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_insertBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        tbl_shwoTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_transaksi", "id_barang", "id_distributor", "gudang", "jenis_barang", "nm_barang", "stok_barang", "harga"
            }
        ));
        jScrollPane3.setViewportView(tbl_shwoTransaksi);

        btn_delete2.setBackground(new java.awt.Color(51, 153, 255));
        btn_delete2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("DELETE");
        btn_delete2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Trash Can_32px.png"))); // NOI18N
        btn_delete2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        javax.swing.GroupLayout inBarangPaneLayout = new javax.swing.GroupLayout(inBarangPane);
        inBarangPane.setLayout(inBarangPaneLayout);
        inBarangPaneLayout.setHorizontalGroup(
            inBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inBarangPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_delete2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        inBarangPaneLayout.setVerticalGroup(
            inBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inBarangPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        mainPanel.add(inBarangPane, "card5");

        outBarangPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel15.setText("BARANG KELUAR");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(51, 153, 255)));

        Label_IDDistributor4.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_IDDistributor4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_IDDistributor4.setText("ID TRANSAKSI");

        txt_transaksi.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_transaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_transaksi.setEnabled(false);

        Label_NamaDistributor4.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NamaDistributor4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NamaDistributor4.setText("ID ADMIN");

        Label_AlamatDistributor4.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_AlamatDistributor4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AlamatDistributor4.setText("ID KONSUMEN");

        btn_addData.setBackground(new java.awt.Color(51, 153, 255));
        btn_addData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_addDataMousePressed(evt);
            }
        });
        btn_addData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("ADD");
        btn_addData.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 95, 32));

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Add New_32px.png"))); // NOI18N
        btn_addData.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

        txt_harga.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_harga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hargaKeyPressed(evt);
            }
        });

        Label_AlamatDistributor5.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_AlamatDistributor5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AlamatDistributor5.setText("HARGA SATUAN");

        txt_qty.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_qty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));

        Label_NamaDistributor5.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_NamaDistributor5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_NamaDistributor5.setText("QUANTITY");

        Label_IDDistributor5.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        Label_IDDistributor5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_IDDistributor5.setText("ID BARANG");

        txt_admin.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txt_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_admin.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("TOTAL HARGA");

        txt_totHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 153, 255)));
        txt_totHarga.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_totHargaInputMethodTextChanged(evt);
            }
        });

        cb_idBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Baeang" }));
        cb_idBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idBarangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_addData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_AlamatDistributor4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NamaDistributor4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_IDDistributor4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_konsumen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_AlamatDistributor5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_NamaDistributor5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_IDDistributor5, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_qty)
                            .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addComponent(txt_totHarga)
                            .addComponent(cb_idBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cb_konsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_IDDistributor4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_NamaDistributor4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_AlamatDistributor4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_IDDistributor5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_qty, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(Label_NamaDistributor5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_harga)
                            .addComponent(Label_AlamatDistributor5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_totHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btn_addData, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        tbl_tempOutBarang.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        tbl_tempOutBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_TRANSAKSI", "ID_BARANG", "QUANTITY", "HARGA_SATUAN"
            }
        ));
        jScrollPane4.setViewportView(tbl_tempOutBarang);

        btn_delete3.setBackground(new java.awt.Color(51, 153, 255));
        btn_delete3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setText("DELETE");
        btn_delete3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Trash Can_32px.png"))); // NOI18N
        btn_delete3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        btn_update3.setBackground(new java.awt.Color(51, 153, 255));
        btn_update3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("UPDATE");
        btn_update3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Edit File_32px.png"))); // NOI18N
        btn_update3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        btn_save.setBackground(new java.awt.Color(51, 153, 255));
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_saveMousePressed(evt);
            }
        });
        btn_save.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("SAVE");
        btn_save.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 13, 95, 32));

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Edit File_32px.png"))); // NOI18N
        btn_save.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 37, -1));

        javax.swing.GroupLayout outBarangPaneLayout = new javax.swing.GroupLayout(outBarangPane);
        outBarangPane.setLayout(outBarangPaneLayout);
        outBarangPaneLayout.setHorizontalGroup(
            outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outBarangPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outBarangPaneLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outBarangPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(outBarangPaneLayout.createSequentialGroup()
                                .addComponent(btn_delete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_update3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4)))
                        .addGap(60, 60, 60))))
        );
        outBarangPaneLayout.setVerticalGroup(
            outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outBarangPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outBarangPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_delete3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        mainPanel.add(outBarangPane, "card6");

        reqPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel24.setText("REQUEST BARANG");

        javax.swing.GroupLayout reqPaneLayout = new javax.swing.GroupLayout(reqPane);
        reqPane.setLayout(reqPaneLayout);
        reqPaneLayout.setHorizontalGroup(
            reqPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reqPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(939, Short.MAX_VALUE))
        );
        reqPaneLayout.setVerticalGroup(
            reqPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reqPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(785, Short.MAX_VALUE))
        );

        mainPanel.add(reqPane, "card7");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_date.setFont(new java.awt.Font("Open Sans SemiBold", 0, 14)); // NOI18N
        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_date.setText("Date");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intentrust/Icon/Calendar_32px.png"))); // NOI18N

        javax.swing.GroupLayout parentLayout = new javax.swing.GroupLayout(parent);
        parent.setLayout(parentLayout);
        parentLayout.setHorizontalGroup(
            parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentLayout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentLayout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        parentLayout.setVerticalGroup(
            parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(parentLayout.createSequentialGroup()
                .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(parentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(parentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //SIDE PANE_BERANDA
    private void btn_berandaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_berandaMousePressed
        // TODO add your handling code here:
        setColor(btn_beranda);
        resetColor(btn_distributor);
        resetColor(btn_konsumen);
        resetColor(btn_inBarang);
        resetColor(btn_outBarang);

        ind_beranda.setOpaque(true);
        ind_distributor.setOpaque(false);
        ind_konsumen.setOpaque(false);
        ind_inBarang.setOpaque(false);
        ind_outBarang.setOpaque(false);

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(homePane);
        mainPanel.repaint();
        mainPanel.revalidate();


    }//GEN-LAST:event_btn_berandaMousePressed
    //SIDE PANE_DISTRIBUTOR
    private void btn_distributorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_distributorMousePressed
        // TODO add your handling code here:
        setColor(btn_distributor);
        resetColor(btn_beranda);
        resetColor(btn_konsumen);
        resetColor(btn_inBarang);
        resetColor(btn_outBarang);

        ind_beranda.setOpaque(false);
        ind_distributor.setOpaque(true);
        ind_konsumen.setOpaque(false);
        ind_inBarang.setOpaque(false);
        ind_outBarang.setOpaque(false);

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(distributorPane);
        mainPanel.repaint();
        mainPanel.revalidate();

        otoIdDistributor();
        try {
            loadDataDistributor();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_distributorMousePressed
    //SIDE PANE_KONSUMEN
    private void btn_konsumenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_konsumenMousePressed
        // TODO add your handling code here:
        setColor(btn_konsumen);
        resetColor(btn_beranda);
        resetColor(btn_distributor);
        resetColor(btn_inBarang);
        resetColor(btn_outBarang);

        ind_beranda.setOpaque(false);
        ind_distributor.setOpaque(false);
        ind_konsumen.setOpaque(true);
        ind_inBarang.setOpaque(false);
        ind_outBarang.setOpaque(false);

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(konsumenPane);
        mainPanel.repaint();
        mainPanel.revalidate();
        try {
            loadDataKonsumen();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_konsumenMousePressed

    private void btn_inBarangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inBarangMousePressed
        // TODO add your handling code here:
        setColor(btn_inBarang);
        resetColor(btn_beranda);
        resetColor(btn_distributor);
        resetColor(btn_konsumen);
        resetColor(btn_outBarang);

        ind_beranda.setOpaque(false);
        ind_distributor.setOpaque(false);
        ind_konsumen.setOpaque(false);
        ind_inBarang.setOpaque(true);
        ind_outBarang.setOpaque(false);

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(inBarangPane);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btn_inBarangMousePressed

    private void btn_outBarangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_outBarangMousePressed
        // TODO add your handling code here:
        setColor(btn_outBarang);
        resetColor(btn_beranda);
        resetColor(btn_distributor);
        resetColor(btn_konsumen);
        resetColor(btn_inBarang);

        ind_beranda.setOpaque(false);
        ind_distributor.setOpaque(false);
        ind_konsumen.setOpaque(false);
        ind_inBarang.setOpaque(false);
        ind_outBarang.setOpaque(true);

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(outBarangPane);
        mainPanel.repaint();
        mainPanel.revalidate();

        try {
            tempOutBarang();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_outBarangMousePressed


    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_btn_exitMousePressed

    private void btn_saveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMousePressed
        // TODO add your handling code here:

        String idKonsumen[] = cb_konsumen.getSelectedItem().toString().split("-");
        try {
            String qry = "INSERT INTO tbl_transaksi VALUES('" + txt_transaksi.getText() + "','"
                    + idKonsumen[0] + "','"
                    + txt_admin.getText() + "','" + lbl_date.getText() + "','" + txt_totHarga.getText() + "')";
            java.sql.Connection conn = (Connection) config.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(qry);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btn_saveMousePressed

    private void btn_insertDistributorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertDistributorMousePressed
        // TODO add your handling code here:
        try {
            String query = "INSERT INTO tbl_distributor VALUES ('"
                    + txt_idDistributor.getText() + "','"
                    + txt_nmDistributor.getText() + "','"
                    + txt_almtDistributor.getText() + "','"
                    + txt_noTelpDistributor.getText() + "')";
            java.sql.Connection conn = (Connection) config.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Saved!");
            clearDistributorText();
            otoIdDistributor();
            loadDataDistributor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_insertDistributorMousePressed

    private void btn_insertKonsumenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertKonsumenMousePressed
        // TODO add your handling code here:
        try {
            String query = "INSERT INTO tbl_konsumen VALUES('" + txt_idKonsumen.getText() + "','"
                    + txt_nmKonsumen.getText() + "','"
                    + txt_almtKonsumen.getText() + "','"
                    + txt_noTelpKonsumen.getText() + "')";
            java.sql.Connection conn = (Connection) config.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Saved!");
            clearKonsumenText();
            otoIdKonsumen();
            loadDataKonsumen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_insertKonsumenMousePressed

    private int tambahTotal(int tot) {
        int h = 0;
        h = h + tot;
        return h;
    }

    private void btn_addDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addDataMousePressed
        // TODO add your handling code here:
        int c = Integer.parseInt(txt_harga.getText());
        jTextField1.setText(String.valueOf(tambahTotal(c)));

        String idTrans = txt_transaksi.getText();
        String idBarang = cb_idBarang.getSelectedItem().toString();
        String barang[] = idBarang.split("-");
        String qty = txt_qty.getText();
        String hrg = txt_harga.getText();
        String st[] = {idTrans, barang[0], qty, hrg};
        model.addRow(st);
        int harga = 0;
        int Index = 0;
//        if(model.getRowCount() > 0){
        for (int i = 0; i < model.getRowCount(); i++){
        harga += Integer.parseInt(model.getValueAt(i, 3).toString());
            System.out.println(model.getRowCount());
        Index++;
        }
        
        try {
            int rows = tbl_tempOutBarang.getRowCount();
            for (int row = 0; row < rows; row++) {
                String idTransaksi = (String) tbl_tempOutBarang.getValueAt(row, 0);
                String idBarangs = (String) tbl_tempOutBarang.getValueAt(row, 1);
                String Qty = (String) tbl_tempOutBarang.getValueAt(row, 2);
                String Hrg = (String) tbl_tempOutBarang.getValueAt(row, 3);
                String query = "INSERT INTO tbl_detailtransaksi(id_transaksi , id_barang , qty , harga_satuan) VALUES ('" + idTransaksi + "' , '" + idBarangs + "' , '" + Qty + "' , '" + Hrg + "')";
                java.sql.Connection conn = (Connection) config.koneksiDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(query);
                pst.execute();
                System.out.println(pst);
                JOptionPane.showMessageDialog(this, "DATA SAVED TO DETAIL TRANSACTION");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
//        }else {
//            harga = Integer.parseInt(model.getValueAt(0, 3).toString());
//        }

        try {
            tempOutBarang();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_totHarga.setText(Integer.toString(harga));
       
        
//        jumlahTotal();
    }//GEN-LAST:event_btn_addDataMousePressed

    private void txt_totHargaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_totHargaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totHargaInputMethodTextChanged

    private void txt_hargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hargaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_hargaKeyPressed

    private void btn_deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMousePressed
        // TODO add your handling code here:
        try {
            Statement tsql = db.createStatement();
            tsql.execute("delete from tbl_distributor where id_distributor = '" + txt_idDistributor.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data Deleted!");

            clearDistributorText();
            otoIdDistributor();
            loadDataDistributor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btn_deleteMousePressed

    private void tbl_distributorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_distributorMousePressed
        // TODO add your handling code here:
        int baris = tbl_distributor.rowAtPoint(evt.getPoint());
        String id_distributor = tbl_distributor.getValueAt(baris, 0).toString();
        txt_idDistributor.setText(id_distributor);
        String nm_distributor = tbl_distributor.getValueAt(baris, 1).toString();
        txt_nmDistributor.setText(nm_distributor);
        String almt_distributor = tbl_distributor.getValueAt(baris, 2).toString();
        txt_almtDistributor.setText(almt_distributor);
        String no_telp = tbl_distributor.getValueAt(baris, 3).toString();
        txt_noTelpDistributor.setText(no_telp);
    }//GEN-LAST:event_tbl_distributorMousePressed

    private void btn_update1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update1MousePressed
        // TODO add your handling code here:
        try {
            Statement tsql = db.createStatement();
            tsql.execute("update tbl_konsumen set id_konsumen = '" + txt_idKonsumen.getText() + "', nm_konsumen = '" + txt_nmKonsumen.getText()
                    + "', almt_konsumen = '" + txt_almtKonsumen.getText() + "', no_telp = '" + txt_noTelpKonsumen.getText() + "' where id_konsumen = '" + txt_idKonsumen.getText() + "'");
            JOptionPane.showMessageDialog(null, "Update Success!");

            clearKonsumenText();
            otoIdKonsumen();
            loadDataKonsumen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btn_update1MousePressed

    private void btn_updateDistributorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateDistributorMousePressed
        // TODO add your handling code here:
        try {
            Statement tsql = db.createStatement();
            tsql.execute("update tbl_distributor set id_distributor = '" + txt_idDistributor.getText() + "', nm_distributor = '" + txt_nmDistributor.getText()
                    + "', almt_distributor = '" + txt_almtDistributor.getText() + "', no_telp = '" + txt_noTelpDistributor.getText() + "' where id_distributor = '" + txt_idDistributor.getText() + "'");
            JOptionPane.showMessageDialog(null, "Update Success!");

            clearDistributorText();
            otoIdDistributor();
            loadDataDistributor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btn_updateDistributorMousePressed

    private void tbl_konsumenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_konsumenMousePressed
        // TODO add your handling code here:
        int baris = tbl_konsumen.rowAtPoint(evt.getPoint());
        String id_konsumen = tbl_konsumen.getValueAt(baris, 0).toString();
        txt_idKonsumen.setText(id_konsumen);
        String nm_konsumen = tbl_konsumen.getValueAt(baris, 1).toString();
        txt_nmKonsumen.setText(nm_konsumen);
        String almt_konsumen = tbl_konsumen.getValueAt(baris, 2).toString();
        txt_almtKonsumen.setText(almt_konsumen);
        String no_telp = tbl_konsumen.getValueAt(baris, 3).toString();
        txt_noTelpKonsumen.setText(no_telp);
    }//GEN-LAST:event_tbl_konsumenMousePressed

    private void btn_delete1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete1MousePressed
        // TODO add your handling code here:
        try {
            Statement tsql = db.createStatement();
            tsql.execute("delete from tbl_konsumen where id_konsumen = '" + txt_idKonsumen.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data Deleted!");

            clearKonsumenText();
            otoIdKonsumen();
            loadDataKonsumen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btn_delete1MousePressed

    private void cb_idBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idBarangItemStateChanged
        // TODO add your handling code here:
        String barang[] = cb_idBarang.getSelectedItem().toString().split("-");
        String query = "SELECT harga FROM tbl_barang WHERE id_barang ='" + barang[0] + "'";

        try {
            java.sql.Connection con = (Connection) config.koneksiDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(query);
            rs.next();
            txt_harga.setText(Integer.toString(rs.getInt("harga")));
            
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb_idBarangItemStateChanged

    private void tampilTemp(){
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("ID TRANSAKSI");
        mdl.addColumn("ID BARANG");
        mdl.addColumn("ID DISTRIBUTOR");
        mdl.addColumn("ID GUDANG");
        mdl.addColumn("JENIS BARANG");
        mdl.addColumn("NAMA BARANG");
        mdl.addColumn("STOK BARANG");
        mdl.addColumn("HARGA SATUAN");
        try{
        String queryTrans = "SELECT tbl_detailbeli.id_detbeli , tbl_barang.id_barang , "
                +           "tbl_barang.nm_barang , "
                +           "tbl_barang.harga , "
                +           "tbl_barang.jenis_barang , "
                +           "tbl_barang.stok_barang ,"
                +           "tbl_distributor.id_distributor , "
                +           "tbl_distributor.nm_distributor , "
                +           "tbl_gudang.id_gudang FROM tbl_barang , tbl_distributor , tbl_gudang , tbl_detailbeli WHERE tbl_detailbeli.status='0' "
                +           "AND tbl_detailbeli.id_barang=tbl_barang.id_barang "
                +           "AND tbl_detailbeli.id_gudang=tbl_gudang.id_gudang "
                +           "AND tbl_detailbeli.id_distributor = tbl_distributor.id_distributor";
        java.sql.Connection conn = (Connection) config.koneksiDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(queryTrans);
        java.sql.ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            mdl.addRow(new Object[]{rs.getString("id_detbeli") , 
                                    rs.getString("id_barang") , 
                                    rs.getString("id_distributor") , 
                                    rs.getString("id_gudang") , 
                                    rs.getString("jenis_barang") , 
                                    rs.getString("nm_barang") ,
                                    rs.getString("stok_barang") , 
                                    rs.getString("harga")});
        }
        tbl_shwoTransaksi.setModel(mdl);
            System.out.println(rs.getRow());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void btn_insertBarangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertBarangMousePressed
        // TODO add your handling code here:
        
        try{
            String idTrs = txt_inTransaksi.getText();
            String idBrg = txt_inIdBarang.getText();
            String idDst[] = cb_distributor.getSelectedItem().toString().split("-");
            String idGdn = cb_gudang.getSelectedItem().toString();
            String jnBrg = cb_jsBarang.getSelectedItem().toString();
            String stBrg = txt_stokBarang.getText();
            String hrBrg = txt_hrgBarang.getText();
            String name = txt_nmBarang.getText();
            String queryC = "SELECT id_barang,nm_barang FROM tbl_barang WHERE nm_barang ='" + name + "'";
            java.sql.Connection conn = (Connection) config.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(queryC);
            java.sql.ResultSet rs = pst.executeQuery();
            rs.next();
            
            if (rs.getRow() > 0) {
                String queryU = "UPDATE tbl_barang SET stok_barang = stok_barang +" + txt_stokBarang.getText();
                java.sql.Connection connU = (Connection) config.koneksiDB();
                java.sql.PreparedStatement pstU = connU.prepareStatement(queryU);
                pstU.execute();
                String queryIns = "INSERT INTO tbl_detailbeli(id_detbeli , id_barang , id_distributor , id_gudang , qty , harga , status) VALUES ('" + idTrs + "','" + 
                                                                           rs.getString("id_barang") +"','" + 
                                                                           idDst[0] +"','"+ 
                                                                           idGdn +"','"+ 
                                                                           stBrg +"','"+ 
                                                                           hrBrg + "', 0)";
                java.sql.Connection connIns = (Connection) config.koneksiDB();
                java.sql.PreparedStatement pstIns = connIns.prepareStatement(queryIns);
                pstIns.execute();
            } else {
                String queryInsert = "INSERT INTO tbl_barang VALUES('" + idBrg + "','" + 
                                                                          name + "','" + 
                                                                          jnBrg + "','" + 
                                                                          stBrg + "','" + 
                                                                          idDst[0] + "','" + 
                                                                          idGdn + "','" +
                                                                          hrBrg + "')";
                java.sql.Connection connInsert = (Connection) config.koneksiDB();
                java.sql.PreparedStatement pstInsert = connInsert.prepareStatement(queryInsert);
                pstInsert.execute();
                String querydet = "INSERT INTO tbl_detailbeli(id_detbeli , id_barang , id_distributor , id_gudang , qty , harga , status) VALUES('" + idTrs + "' , '" +
                                                                          idBrg + "' , '" +
                                                                          idDst[0] + "','" +
                                                                          idGdn + "','" +
                                                                          stBrg + "','" +
                                                                          hrBrg + "',0)";
                java.sql.Connection connIns = (Connection) config.koneksiDB();
                java.sql.PreparedStatement pstIns = connIns.prepareStatement(querydet);
                pstIns.execute();                
           }
            tampilTemp();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_insertBarangMousePressed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_AlamatDistributor;
    private javax.swing.JLabel Label_AlamatDistributor1;
    private javax.swing.JLabel Label_AlamatDistributor2;
    private javax.swing.JLabel Label_AlamatDistributor3;
    private javax.swing.JLabel Label_AlamatDistributor4;
    private javax.swing.JLabel Label_AlamatDistributor5;
    private javax.swing.JLabel Label_IDDistributor;
    private javax.swing.JLabel Label_IDDistributor1;
    private javax.swing.JLabel Label_IDDistributor2;
    private javax.swing.JLabel Label_IDDistributor3;
    private javax.swing.JLabel Label_IDDistributor4;
    private javax.swing.JLabel Label_IDDistributor5;
    private javax.swing.JLabel Label_NamaDistributor;
    private javax.swing.JLabel Label_NamaDistributor1;
    private javax.swing.JLabel Label_NamaDistributor2;
    private javax.swing.JLabel Label_NamaDistributor3;
    private javax.swing.JLabel Label_NamaDistributor4;
    private javax.swing.JLabel Label_NamaDistributor5;
    private javax.swing.JLabel Label_NoTelp;
    private javax.swing.JLabel Label_NoTelp1;
    private javax.swing.JLabel Label_NoTelp2;
    private javax.swing.JPanel btn_addData;
    private javax.swing.JPanel btn_beranda;
    private javax.swing.JPanel btn_delete;
    private javax.swing.JPanel btn_delete1;
    private javax.swing.JPanel btn_delete2;
    private javax.swing.JPanel btn_delete3;
    private javax.swing.JPanel btn_distributor;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JPanel btn_inBarang;
    private javax.swing.JPanel btn_insertBarang;
    private javax.swing.JPanel btn_insertDistributor;
    private javax.swing.JPanel btn_insertKonsumen;
    private javax.swing.JPanel btn_konsumen;
    private javax.swing.JPanel btn_outBarang;
    private javax.swing.JPanel btn_save;
    private javax.swing.JPanel btn_update1;
    private javax.swing.JPanel btn_update3;
    private javax.swing.JPanel btn_updateDistributor;
    private javax.swing.JComboBox cb_distributor;
    private javax.swing.JComboBox cb_gudang;
    private javax.swing.JComboBox cb_idBarang;
    private javax.swing.JComboBox cb_jsBarang;
    private javax.swing.JComboBox cb_konsumen;
    private javax.swing.JPanel distributorPane;
    private javax.swing.JPanel homePane;
    private javax.swing.JPanel inBarangPane;
    private javax.swing.JPanel ind_beranda;
    private javax.swing.JPanel ind_distributor;
    private javax.swing.JPanel ind_inBarang;
    private javax.swing.JPanel ind_konsumen;
    private javax.swing.JPanel ind_outBarang;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel konsumenPane;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_show;
    private javax.swing.JLabel lbl_showPem;
    private javax.swing.JLabel lbl_showReq;
    private javax.swing.JLabel lbl_showout;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel outBarangPane;
    private javax.swing.JPanel parent;
    private javax.swing.JPanel reqPane;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTable tbl_distributor;
    private javax.swing.JTable tbl_konsumen;
    private javax.swing.JTable tbl_shwoTransaksi;
    private javax.swing.JTable tbl_tempOutBarang;
    private javax.swing.JLabel txt_Adm;
    private javax.swing.JTextField txt_admin;
    private javax.swing.JTextField txt_almtDistributor;
    private javax.swing.JTextField txt_almtKonsumen;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_hrgBarang;
    private javax.swing.JTextField txt_idDistributor;
    private javax.swing.JTextField txt_idKonsumen;
    private javax.swing.JTextField txt_inIdBarang;
    public javax.swing.JTextField txt_inTransaksi;
    private javax.swing.JTextField txt_nmBarang;
    private javax.swing.JTextField txt_nmDistributor;
    private javax.swing.JTextField txt_nmKonsumen;
    private javax.swing.JTextField txt_noTelpDistributor;
    private javax.swing.JTextField txt_noTelpKonsumen;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_stokBarang;
    private javax.swing.JTextField txt_totHarga;
    private javax.swing.JTextField txt_transaksi;
    // End of variables declaration//GEN-END:variables
}
