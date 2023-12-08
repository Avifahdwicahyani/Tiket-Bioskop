package frontend;
import backend.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class FrmReservasi extends javax.swing.JFrame {

   
    public FrmReservasi() {
        initComponents();
        tampilkanData();
        kosongkanForm();
        tampilkanCmbKategori();
    }

    public void kosongkanForm(){
        txtIdReservasi.setText("0");
        cmbPenumpang.setSelectedIndex(0);
        cmbBus.setSelectedIndex(0);
        txtTglBerangkat.setText("");
        txtTglPesan.setText("");
    }
    
    public void tampilkanData(){
        String[] kolom = {"ID", "Penumpang", "Bus", "Tanggal Berangkat", "Tanggal Pesan"};
        ArrayList<Reservasi> list = new Reservasi().getAll();
        Object rowData[] = new Object[5];
        
        tblReservasi.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(int i = 0; i < list.size(); i++){
            rowData[0] = list.get(i).getIdreservasi();
            rowData[1] = list.get(i).getPenumpang().getNamapenumpang();
            rowData[2] = list.get(i).getBus().getNamabus();
            rowData[3] = list.get(i).getTanggalberangkat();
            rowData[4] = list.get(i).getTanggalpesan();
            
            ((DefaultTableModel)tblReservasi.getModel()).addRow(rowData);
        }
    }
       
    public void cari(String keyword) {
        String[] kolom = {"ID", "Penumpang", "Bus", "Tanggal Berangkat", "Tanggal Pesan"};
        ArrayList<Reservasi> list = new Reservasi().search(keyword);
        Object rowData[] = new Object[5];
        
        tblReservasi.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(int i = 0; i < list.size(); i++){
            rowData[0] = list.get(i).getIdreservasi();
            rowData[1] = list.get(i).getPenumpang().getNamapenumpang();
            rowData[2] = list.get(i).getBus().getNamabus();
            rowData[3] = list.get(i).getTanggalberangkat();
            rowData[4] = list.get(i).getTanggalpesan();
            
            ((DefaultTableModel)tblReservasi.getModel()).addRow(rowData);
        }
    }
    
    public void tampilkanCmbKategori() {
        cmbPenumpang.setModel(new DefaultComboBoxModel(new Penumpang().getAll().toArray()));
        cmbBus.setModel(new DefaultComboBoxModel(new Bus().getAll().toArray()));
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
        txtIdReservasi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTglBerangkat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTglPesan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnTambahBaru = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservasi = new javax.swing.JTable();
        detailPenumpang = new javax.swing.JLabel();
        detailKereta = new javax.swing.JLabel();
        cmbPenumpang = new javax.swing.JComboBox<>();
        cmbBus = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnKereta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnPenumpang = new javax.swing.JButton();
        btnTiket = new javax.swing.JButton();
        btnReservasi = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID Reservasi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 94, -1, -1));

        txtIdReservasi.setEditable(false);
        txtIdReservasi.setEnabled(false);
        getContentPane().add(txtIdReservasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 91, 66, -1));

        jLabel2.setText("Nama Penumpang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 132, -1, -1));

        jLabel3.setText("Bus");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 170, -1, -1));

        jLabel4.setText("Tanggal Berangkat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 208, -1, -1));
        getContentPane().add(txtTglBerangkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 205, 187, -1));

        jLabel5.setText("Tanggal Pesan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 246, -1, -1));
        getContentPane().add(txtTglPesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 243, 187, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 302, -1, -1));

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambahBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 302, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 302, -1, -1));

        tblReservasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblReservasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReservasi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 354, 566, 142));

        detailPenumpang.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(detailPenumpang, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 49, -1, -1));

        detailKereta.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(detailKereta, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 55, -1, -1));

        cmbPenumpang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbPenumpang, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 129, 187, -1));

        cmbBus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 167, 187, -1));
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 303, 203, -1));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 302, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("DATA RESERVASI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 26, -1, -1));

        btnKereta.setBackground(new java.awt.Color(5, 157, 192));
        btnKereta.setForeground(new java.awt.Color(255, 255, 255));
        btnKereta.setText("Bus");
        btnKereta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeretaActionPerformed(evt);
            }
        });
        getContentPane().add(btnKereta, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 76, 89, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("DASHBOARD");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 26, -1, -1));

        btnPenumpang.setBackground(new java.awt.Color(5, 157, 192));
        btnPenumpang.setForeground(new java.awt.Color(255, 255, 255));
        btnPenumpang.setText("Penumpang");
        btnPenumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenumpangActionPerformed(evt);
            }
        });
        getContentPane().add(btnPenumpang, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 117, -1, -1));

        btnTiket.setBackground(new java.awt.Color(5, 157, 192));
        btnTiket.setForeground(new java.awt.Color(255, 255, 255));
        btnTiket.setText("Tiket");
        btnTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiketActionPerformed(evt);
            }
        });
        getContentPane().add(btnTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 158, 89, -1));

        btnReservasi.setBackground(new java.awt.Color(5, 157, 192));
        btnReservasi.setForeground(new java.awt.Color(255, 255, 255));
        btnReservasi.setText("Reservasi");
        btnReservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasiActionPerformed(evt);
            }
        });
        getContentPane().add(btnReservasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 199, 89, -1));

        btnTransaksi.setBackground(new java.awt.Color(5, 157, 192));
        btnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaksi.setText("Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 240, 89, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 291, 89, -1));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Reservasi rs = new Reservasi();
        rs.setIdreservasi(Integer.parseInt(txtIdReservasi.getText()));
        rs.setPenumpang((Penumpang)cmbPenumpang.getSelectedItem());
        rs.setBus((Bus)cmbBus.getSelectedItem());
        rs.setTanggalberangkat(txtTglBerangkat.getText());
        rs.setTanggalpesan(txtTglPesan.getText());
        rs.save();
        
        txtIdReservasi.setText(Integer.toString(rs.getIdreservasi()));
        
        tampilkanData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblReservasi.getModel();
        int row = tblReservasi.getSelectedRow();
        
        Reservasi rs = new Reservasi().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        rs.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblReservasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservasiMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblReservasi.getModel();
        int row = tblReservasi.getSelectedRow();    
        Reservasi rs = new Reservasi();
        
        rs = rs.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        
        txtIdReservasi.setText(String.valueOf(rs.getIdreservasi()));
        cmbPenumpang.getModel().setSelectedItem(rs.getPenumpang().getNamapenumpang());
        cmbBus.getModel().setSelectedItem(rs.getBus().getNamabus());
        txtTglBerangkat.setText(rs.getTanggalberangkat());
        txtTglPesan.setText(rs.getTanggalpesan());
    }//GEN-LAST:event_tblReservasiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cari(txtCari.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnKeretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeretaActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBus().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnKeretaActionPerformed

    private void btnPenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenumpangActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPenumpang().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnPenumpangActionPerformed

    private void btnTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiketActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTiket().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnTiketActionPerformed

    private void btnReservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasiActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReservasi().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnReservasiActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTransaksi().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
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
            java.util.logging.Logger.getLogger(FrmReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReservasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKereta;
    private javax.swing.JButton btnPenumpang;
    private javax.swing.JButton btnReservasi;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JButton btnTiket;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JComboBox<String> cmbBus;
    private javax.swing.JComboBox<String> cmbPenumpang;
    private javax.swing.JLabel detailKereta;
    private javax.swing.JLabel detailPenumpang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReservasi;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdReservasi;
    private javax.swing.JTextField txtTglBerangkat;
    private javax.swing.JTextField txtTglPesan;
    // End of variables declaration//GEN-END:variables
}
