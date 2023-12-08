package frontend;

import backend.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FrmTransaksi extends javax.swing.JFrame {

   
    public FrmTransaksi() {
        initComponents();
        tampilkanData();
        tampilkanCmbKategori();
        kosongkanForm();
    }
    
    public void kosongkanForm() {
        txtId.setText("0");
        txtTglBayar.setText("");
        txtJmlTiket.setText("0");
        txtHrgTiket.setText("0");
        txtTotalBayar.setText("0");
        cmbReservasi.setSelectedIndex(0);        
    }
    
    public void tampilkanData() {
        String[] kolom = {"ID Transaksi", "Tanggal Bayar", "Jumlah Tiket", 
            "Harga Tiket", "Total Bayar", "Reservasi"};
        ArrayList<Transaksi> list = new Transaksi().getAll();
        Object rowData[] = new Object[7];
        
        tblTransaksi.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Transaksi t : list) {
            rowData[0] = t.getIdtransaksi();
            rowData[1] = t.getTanggalbayar();
            rowData[2] = t.getJumlahtiket();
            rowData[3] = t.getHargatiket();
            rowData[4] = t.getTotalbayar();
            rowData[5] = t.getReservasi().getTanggalpesan();
            
            ((DefaultTableModel)tblTransaksi.getModel()).addRow(rowData);
        }
    }
    
    public void cari(String keyword) {
        String[] kolom = {"ID Transaksi", "Tanggal Bayar", "Jumlah Tiket", 
            "Harga Tiket", "Total Bayar", "Reservasi"};
        ArrayList<Transaksi> list = new Transaksi().search(keyword);
        Object rowData[] = new Object[7];
        
        tblTransaksi.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Transaksi t : list) {
            rowData[0] = t.getIdtransaksi();
            rowData[1] = t.getTanggalbayar();
            rowData[2] = t.getJumlahtiket();
            rowData[3] = t.getHargatiket();
            rowData[4] = t.getTotalbayar();
            rowData[5] = t.getReservasi().getTanggalpesan();
            
            ((DefaultTableModel)tblTransaksi.getModel()).addRow(rowData);
        }
    }
    
    public void tampilkanCmbKategori() {
        cmbReservasi.setModel(new DefaultComboBoxModel(new Reservasi().getAll().toArray()));
    }

 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cmbReservasi = new javax.swing.JComboBox<>();
        txtTglBayar = new javax.swing.JTextField();
        txtJmlTiket = new javax.swing.JTextField();
        txtHrgTiket = new javax.swing.JTextField();
        txtTotalBayar = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnTambahBaru = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnKereta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnPenumpang = new javax.swing.JButton();
        btnTiket = new javax.swing.JButton();
        btnReservasi = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTransaksi.setBackground(new java.awt.Color(5, 157, 192));
        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaksi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 442, 514, 97));

        jLabel1.setText("ID Transaksi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 73, -1, -1));

        jLabel3.setText("Reservasi");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 278, -1, -1));

        jLabel4.setText("Tanggal Bayar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 111, -1, -1));

        jLabel5.setText("Jumlah Tiket");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 149, -1, -1));

        jLabel6.setText("Harga Tiket");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 190, -1, -1));

        jLabel7.setText("Total Bayar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 237, -1, -1));

        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 70, 70, -1));

        cmbReservasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbReservasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 275, 143, -1));
        getContentPane().add(txtTglBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 108, 143, -1));

        txtJmlTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlTiketActionPerformed(evt);
            }
        });
        getContentPane().add(txtJmlTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 146, 70, -1));
        getContentPane().add(txtHrgTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 184, 70, -1));
        getContentPane().add(txtTotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 231, 70, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 341, -1, -1));

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambahBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 382, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 382, -1, -1));

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 383, 241, -1));

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 382, 62, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("DATA TRANSAKSI");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 20, -1, -1));

        btnKereta.setBackground(new java.awt.Color(5, 157, 192));
        btnKereta.setForeground(new java.awt.Color(255, 255, 255));
        btnKereta.setText("Bus");
        btnKereta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeretaActionPerformed(evt);
            }
        });
        getContentPane().add(btnKereta, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, 89, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DASHBOARD");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 20, -1, -1));

        btnPenumpang.setBackground(new java.awt.Color(5, 157, 192));
        btnPenumpang.setForeground(new java.awt.Color(255, 255, 255));
        btnPenumpang.setText("Penumpang");
        btnPenumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenumpangActionPerformed(evt);
            }
        });
        getContentPane().add(btnPenumpang, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 111, -1, -1));

        btnTiket.setBackground(new java.awt.Color(5, 157, 192));
        btnTiket.setForeground(new java.awt.Color(255, 255, 255));
        btnTiket.setText("Tiket");
        btnTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiketActionPerformed(evt);
            }
        });
        getContentPane().add(btnTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 152, 89, -1));

        btnReservasi.setBackground(new java.awt.Color(5, 157, 192));
        btnReservasi.setForeground(new java.awt.Color(255, 255, 255));
        btnReservasi.setText("Reservasi");
        btnReservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasiActionPerformed(evt);
            }
        });
        getContentPane().add(btnReservasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 193, 89, -1));

        btnTransaksi.setBackground(new java.awt.Color(5, 157, 192));
        btnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaksi.setText("Transaksi");
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 234, 89, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 295, 89, -1));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Transaksi transaksi = new Transaksi();
        transaksi.setIdtransaksi(Integer.parseInt(txtId.getText()));
        transaksi.setTanggalbayar(txtTglBayar.getText());
        transaksi.setJumlahtiket(Integer.parseInt(txtJmlTiket.getText()));
        transaksi.setHargatiket(Integer.parseInt(txtHrgTiket.getText()));
        transaksi.setTotalbayar(Integer.parseInt(txtTotalBayar.getText()));
        transaksi.setReservasi((Reservasi)cmbReservasi.getSelectedItem());
        transaksi.save();
        
        txtId.setText(Integer.toString(transaksi.getIdtransaksi()));
        
        tampilkanData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblTransaksi.getModel();
        int row = tblTransaksi.getSelectedRow();
        
        Transaksi transaksi = new Transaksi().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        transaksi.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblTransaksi.getModel();
        int row = tblTransaksi.getSelectedRow();
        Transaksi transaksi = new Transaksi();
        
        transaksi = transaksi.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        
        txtId.setText(String.valueOf(transaksi.getIdtransaksi()));
        txtTglBayar.setText(transaksi.getTanggalbayar());
        txtJmlTiket.setText(String.valueOf(transaksi.getJumlahtiket()));
        txtHrgTiket.setText(String.valueOf(transaksi.getHargatiket()));
        txtTotalBayar.setText(String.valueOf(transaksi.getTotalbayar()));
        cmbReservasi.getModel().setSelectedItem(transaksi.getReservasi().getTanggalpesan());
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtJmlTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlTiketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJmlTiketActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKereta;
    private javax.swing.JButton btnPenumpang;
    private javax.swing.JButton btnReservasi;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JButton btnTiket;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JComboBox<String> cmbReservasi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHrgTiket;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJmlTiket;
    private javax.swing.JTextField txtTglBayar;
    private javax.swing.JTextField txtTotalBayar;
    // End of variables declaration//GEN-END:variables
}