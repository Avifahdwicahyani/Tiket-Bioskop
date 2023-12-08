package backend;

import java.util.ArrayList;
import java.sql.*;

public class Transaksi {
    private int idtransaksi;
    private String tanggalbayar;
    private int jumlahtiket;
    private int hargatiket;
    private int totalbayar;
    private Reservasi reservasi = new Reservasi();

    public int getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public Reservasi getReservasi() {
        return reservasi;
    }

    public void setReservasi(Reservasi reservasi) {
        this.reservasi = reservasi;
    }
    
    public String getTanggalbayar() {
        return tanggalbayar;
    }

    public void setTanggalbayar(String tanggalbayar) {
        this.tanggalbayar = tanggalbayar;
    }

    public int getJumlahtiket() {
        return jumlahtiket;
    }

    public void setJumlahtiket(int jumlahtiket) {
        this.jumlahtiket = jumlahtiket;
    }

    public int getHargatiket() {
        return hargatiket;
    }

    public void setHargatiket(int hargatiket) {
        this.hargatiket = hargatiket;
    }

    public int getTotalbayar() {
        return totalbayar;
    }

    public void setTotalbayar(int totalbayar) {
        this.totalbayar = totalbayar;
    }
    
    public Transaksi() {
        
    }
    
    public Transaksi(String tanggalbayar, int jumlahtiket, int hargatiket, 
            int totalbayar, Reservasi reservasi) {
        this.tanggalbayar = tanggalbayar;
        this.jumlahtiket = jumlahtiket;
        this.hargatiket = hargatiket;
        this.totalbayar = totalbayar;
        this.reservasi = reservasi;
    }
    
    public Transaksi getById(int id) {
        Transaksi transaksi = new Transaksi();   
        ResultSet rs = DBHelper.selectQuery(" SELECT "
                        + "     t.idtransaksi AS idtransaksi, "
                        + "     t.tanggalbayar AS tanggalbayar, "
                        + "     t.jumlahtiket AS jumlahtiket, "
                        + "     t.hargatiket AS hargatiket, "
                        + "     t.totalbayar AS totalbayar, "
                        + "     r.idreservasi AS idreservasi, "
                        + "     r.idpenumpang AS idpenumpang, "
                        + "     r.idbus AS idbus, "
                        + "     r.tanggalberangkat AS tanggalberangkat, "
                        + "     r.tanggalpesan AS tanggalpesan "
                        + "     FROM transaksi t "
                        + "     LEFT JOIN reservasi r ON r.idreservasi = t.idreservasi "
                        + "     WHERE t.idtransaksi = '" + id + "'");
        try {
            while(rs.next()){
                transaksi = new Transaksi();
                transaksi.setIdtransaksi(rs.getInt("idtransaksi"));
                transaksi.setTanggalbayar(rs.getString("tanggalbayar"));
                transaksi.setJumlahtiket(rs.getInt("jumlahtiket"));
                transaksi.setHargatiket(rs.getInt("hargatiket"));
                transaksi.setTotalbayar(rs.getInt("totalbayar"));
                transaksi.getReservasi().setIdreservasi(rs.getInt("idreservasi"));
                transaksi.getReservasi().getPenumpang().setIdpenumpang(rs.getInt("idpenumpang"));
                transaksi.getReservasi().getBus().setIdbus(rs.getInt("idbus"));
                transaksi.getReservasi().setTanggalberangkat(rs.getString("tanggalberangkat"));
                transaksi.getReservasi().setTanggalpesan(rs.getString("tanggalpesan"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return transaksi;
    }

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery(" SELECT "
                        + "     t.idtransaksi AS idtransaksi, "
                        + "     t.tanggalbayar AS tanggalbayar, "
                        + "     t.jumlahtiket AS jumlahtiket, "
                        + "     t.hargatiket AS hargatiket, "
                        + "     t.totalbayar AS totalbayar, "
                        + "     r.idreservasi AS idreservasi, "
                        + "     r.idpenumpang AS idpenumpang, "
                        + "     r.idbus AS idbus, "
                        + "     r.tanggalberangkat AS tanggalberangkat, "
                        + "     r.tanggalpesan AS tanggalpesan "
                        + "     FROM transaksi t "
                        + "     LEFT JOIN reservasi r ON r.idreservasi = t.idreservasi ");
        
        try {
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdtransaksi(rs.getInt("idtransaksi"));
                transaksi.setTanggalbayar(rs.getString("tanggalbayar"));
                transaksi.setJumlahtiket(rs.getInt("jumlahtiket"));
                transaksi.setHargatiket(rs.getInt("hargatiket"));
                transaksi.setTotalbayar(rs.getInt("totalbayar"));
                transaksi.getReservasi().setIdreservasi(rs.getInt("idreservasi"));
                transaksi.getReservasi().getPenumpang().setIdpenumpang(rs.getInt("idpenumpang"));
                transaksi.getReservasi().getBus().setIdbus(rs.getInt("idbus"));
                transaksi.getReservasi().setTanggalberangkat(rs.getString("tanggalberangkat"));
                transaksi.getReservasi().setTanggalpesan(rs.getString("tanggalpesan"));
                
                ListTransaksi.add(transaksi);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public ArrayList<Transaksi> search(String keyword) {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery(" SELECT "
                                    + "     t.idtransaksi AS idtransaksi, "
                                    + "     t.tanggalbayar AS tanggalbayar, "
                                    + "     t.jumlahtiket AS jumlahtiket, "
                                    + "     t.hargatiket AS hargatiket, "
                                    + "     t.totalbayar AS totalbayar, "
                                    + "     r.idreservasi AS idreservasi, "
                                    + "     r.idpenumpang AS idpenumpang, "
                                    + "     r.idbus AS idbus, "
                                    + "     r.tanggalberangkat AS tanggalberangkat, "
                                    + "     r.tanggalpesan AS tanggalpesan "
                                    + "     FROM transaksi t "
                                    + "     LEFT JOIN reservasi r ON r.idreservasi = t.idreservasi "
                                    + "     WHERE t.tanggalbayar LIKE '%" + keyword + "%' "
                                    + "         OR t.idtransaksi LIKE '%" + keyword + "%' "
                                    + "         OR t.jumlahtiket LIKE '%" + keyword + "%' "
                                    + "         OR t.hargatiket LIKE '%" + keyword + "%' "
                                    + "         OR t.totalbayar LIKE '%" + keyword + "%' "
                                    + "         OR r.tanggalpesan LIKE '%" + keyword + "%' ");
        
        
        try {
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdtransaksi(rs.getInt("idtransaksi"));
                transaksi.setTanggalbayar(rs.getString("tanggalbayar"));
                transaksi.setJumlahtiket(rs.getInt("jumlahtiket"));
                transaksi.setHargatiket(rs.getInt("hargatiket"));
                transaksi.setTotalbayar(rs.getInt("totalbayar"));
                transaksi.getReservasi().setIdreservasi(rs.getInt("idreservasi"));
                transaksi.getReservasi().getPenumpang().setIdpenumpang(rs.getInt("idpenumpang"));
                transaksi.getReservasi().getBus().setIdbus(rs.getInt("idbus"));
                transaksi.getReservasi().setTanggalberangkat(rs.getString("tanggalberangkat"));
                transaksi.getReservasi().setTanggalpesan(rs.getString("tanggalpesan"));
                
                ListTransaksi.add(transaksi);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public void save() {
        if(getById(idtransaksi).getIdtransaksi() == 0) {
            String SQL = "INSERT INTO transaksi (tanggalbayar, "
                    + "jumlahtiket, hargatiket, totalbayar, idreservasi) VALUES("
                + " '" + this.tanggalbayar + "', "
                + " '" + this.jumlahtiket + "', "
                + " '" + this.hargatiket + "', "
                + " '" + this.totalbayar + "', "
                + " '" + this.getReservasi().getIdreservasi() + "' "
                + " )";
            this.idtransaksi = DBHelper.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE transaksi SET "  
                + " tanggalbayar = '" + this.tanggalbayar + "', "
                + " jumlahtiket = '" + this.jumlahtiket + "', "
                + " hargatiket = '" + this.hargatiket + "', "
                + " totalbayar = '" + this.totalbayar + "', "
                + " idreservasi = '" + this.getReservasi().getIdreservasi() + "' "
                + " WHERE idtransaksi = '" + this.idtransaksi + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM transaksi WHERE idtransaksi = '" + this.idtransaksi + "'";
        DBHelper.executeQuery(SQL);
    }
}
