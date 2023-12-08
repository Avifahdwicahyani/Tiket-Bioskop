package backend;

import java.util.ArrayList;
import java.sql.*;

public class Reservasi {
    private int idreservasi;
    private Penumpang penumpang = new Penumpang();
    private Bus bus = new Bus();
    private String tanggalberangkat;
    private String tanggalpesan;

    public int getIdreservasi() {
        return idreservasi;
    }

    public void setIdreservasi(int idreservasi) {
        this.idreservasi = idreservasi;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
    public String getTanggalberangkat() {
        return tanggalberangkat;
    }

    public void setTanggalberangkat(String tanggalberangkat) {
        this.tanggalberangkat = tanggalberangkat;
    }

    public String getTanggalpesan() {
        return tanggalpesan;
    }

    public void setTanggalpesan(String tanggalpesan) {
        this.tanggalpesan = tanggalpesan;
    }
    
    public String toString() {
        return tanggalpesan;
    }
    
    public Reservasi() {
        
    }
    
    public Reservasi(Penumpang penumpang, Bus bus, String tanggalberangkat, String tanggalpesan) {
        this.penumpang = penumpang;
        this.bus = bus;
        this.tanggalberangkat = tanggalberangkat;
        this.tanggalpesan = tanggalpesan;
    }
    
    public Reservasi getById(int id){
        
        Reservasi reservasi = new Reservasi();
        ResultSet rs = DBHelper.selectQuery(" SELECT "
                            + "    r.idreservasi AS idreservasi, "
                            + "    r.tanggalberangkat AS tanggalberangkat, "
                            + "    r.tanggalpesan AS tanggalpesan, "
                            + "    p.idpenumpang AS idpenumpang, "
                            + "    p.namapenumpang AS namapenumpang, "
                            + "    p.alamat AS alamat, "
                            + "    p.gender AS gender, "
                            + "    p.notelepon AS notelepon, "
                            + "    b.idbus AS idbus, "
                            + "    b.namabus AS namabus, "
                            + "    b.jamberangkat AS jamberangkat, "
                            + "    b.hargatiket AS hargatiket, "
                            + "    b.terminalasal AS terminalasal, "
                            + "    b.terminaltujuan AS terminaltujuan "
                            + "    FROM reservasi r "
                            + "    INNER JOIN penumpang p "
                            + "    ON p.idpenumpang = r.idpenumpang "
                            + "    INNER JOIN bus b "
                            + "    ON b.idbus = r.idbus "
                            + "    WHERE idreservasi = '" + id +"'" );
        
        try {
            while(rs.next()){
                reservasi = new Reservasi();
                reservasi.setIdreservasi(rs.getInt("idreservasi"));
                reservasi.getPenumpang().setIdpenumpang(rs.getInt("idpenumpang"));
                reservasi.getPenumpang().setNamapenumpang(rs.getString("namapenumpang"));
                reservasi.getPenumpang().setAlamat(rs.getString("alamat"));
                reservasi.getPenumpang().setGender(rs.getString("gender"));
                reservasi.getPenumpang().setNotelepon(rs.getString("notelepon"));
                reservasi.getBus().setIdbus(rs.getInt("idbus"));
                reservasi.getBus().setNamabus(rs.getString("namabus"));
                reservasi.getBus().setJamberangkat(rs.getString("jamberangkat"));
                reservasi.getBus().setHargatiket(rs.getInt("hargatiket"));
                reservasi.getBus().setTerminalasal(rs.getString("terminalasal"));
                reservasi.getBus().setTerminaltujuan(rs.getString("terminaltujuan"));
                reservasi.setTanggalberangkat(rs.getString("tanggalberangkat"));
                reservasi.setTanggalpesan(rs.getString("tanggalpesan"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return reservasi;
    }
    
    public ArrayList<Reservasi> getAll(){
        ArrayList<Reservasi> ListReservasi = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery(" SELECT "
                            + "    r.idreservasi AS idreservasi, "
                            + "    r.tanggalberangkat AS tanggalberangkat, "
                            + "    r.tanggalpesan AS tanggalpesan, "
                            + "    p.idpenumpang AS idpenumpang, "
                            + "    p.namapenumpang AS namapenumpang, "
                            + "    p.alamat AS alamat, "
                            + "    p.gender AS gender, "
                            + "    p.notelepon AS notelepon, "
                            + "    b.idbus AS idbus, "
                            + "    b.namabus AS namabus, "
                            + "    b.jamberangkat AS jamberangkat, "
                            + "    b.hargatiket AS hargatiket, "
                            + "    b.terminalasal AS terminalasal, "
                            + "    b.terminaltujuan AS terminaltujuan "
                            + "    FROM reservasi r "
                            + "    INNER JOIN penumpang p "
                            + "    ON p.idpenumpang = r.idpenumpang "
                            + "    INNER JOIN bus b "
                            + "    ON b.idbus = r.idbus ");
        
        try {
            while(rs.next()){
                Reservasi reservasi = new Reservasi();
                reservasi.setIdreservasi(rs.getInt("idreservasi"));
                reservasi.getPenumpang().setIdpenumpang(rs.getInt("idpenumpang"));
                reservasi.getPenumpang().setNamapenumpang(rs.getString("namapenumpang"));
                reservasi.getPenumpang().setAlamat(rs.getString("alamat"));
                reservasi.getPenumpang().setGender(rs.getString("gender"));
                reservasi.getPenumpang().setNotelepon(rs.getString("notelepon"));
                reservasi.getBus().setIdbus(rs.getInt("idbus"));
                reservasi.getBus().setNamabus(rs.getString("namabus"));
                reservasi.getBus().setJamberangkat(rs.getString("jamberangkat"));
                reservasi.getBus().setHargatiket(rs.getInt("hargatiket"));
                reservasi.getBus().setTerminalasal(rs.getString("terminalasal"));
                reservasi.getBus().setTerminaltujuan(rs.getString("terminaltujuan"));
                reservasi.setTanggalberangkat(rs.getString("tanggalberangkat"));
                reservasi.setTanggalpesan(rs.getString("tanggalpesan"));
                
                ListReservasi.add(reservasi);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return ListReservasi;                       
    }
    
    public ArrayList<Reservasi> search (String keyword){
        ArrayList<Reservasi> ListReservasi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery(" SELECT "
                            + "    r.idreservasi AS idreservasi, "
                            + "    r.tanggalberangkat AS tanggalberangkat, "
                            + "    r.tanggalpesan AS tanggalpesan, "
                            + "    p.idpenumpang AS idpenumpang, "
                            + "    p.namapenumpang AS namapenumpang, "
                            + "    p.alamat AS alamat, "
                            + "    p.gender AS gender, "
                            + "    p.notelepon AS notelepon, "
                            + "    b.idbus AS idbus, "
                            + "    b.namabus AS namabus, "
                            + "    b.jamberangkat AS jamberangkat, "
                            + "    b.hargatiket AS hargatiket, "
                            + "    b.terminalasal AS terminalasal, "
                            + "    b.terminaltujuan AS terminaltujuan "
                            + "    FROM reservasi r "
                            + "    INNER JOIN penumpang p "
                            + "    ON p.idpenumpang = r.idpenumpang "
                            + "    INNER JOIN bus b "
                            + "    ON b.idbus = r.idbus "
                            + "    WHERE r.tanggalberangkat LIKE '%" + keyword + "%' "
                            + "    OR r.idreservasi LIKE '%" + keyword + "%' "
                            + "    OR r.tanggalpesan LIKE '%" + keyword + "%' "
                            + "    OR p.namapenumpang LIKE '%" + keyword + "%' "
                            + "    OR b.namabus LIKE '%" + keyword + "%' ");
        
        try {
            while(rs.next()){
                Reservasi reservasi = new Reservasi();
                reservasi.setIdreservasi(rs.getInt("idreservasi"));
                reservasi.getPenumpang().setIdpenumpang(rs.getInt("idpenumpang"));
                reservasi.getPenumpang().setNamapenumpang(rs.getString("namapenumpang"));
                reservasi.getPenumpang().setAlamat(rs.getString("alamat"));
                reservasi.getPenumpang().setGender(rs.getString("gender"));
                reservasi.getPenumpang().setNotelepon(rs.getString("notelepon"));
                reservasi.getBus().setIdbus(rs.getInt("idbus"));
                reservasi.getBus().setNamabus(rs.getString("namabus"));
                reservasi.getBus().setJamberangkat(rs.getString("jamberangkat"));
                reservasi.getBus().setHargatiket(rs.getInt("hargatiket"));
                reservasi.getBus().setTerminalasal(rs.getString("terminalasal"));
                reservasi.getBus().setTerminaltujuan(rs.getString("terminaltujuan"));
                reservasi.setTanggalberangkat(rs.getString("tanggalberangkat"));
                reservasi.setTanggalpesan(rs.getString("tanggalpesan"));
                
                ListReservasi.add(reservasi);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return ListReservasi; 
    }
    
    public void save(){
        
        if(getById(idreservasi).getIdreservasi() == 0){
            String SQL = "INSERT INTO reservasi (idpenumpang, idbus, tanggalberangkat, tanggalpesan) VALUES ("
                    +"         '" + this.getPenumpang().getIdpenumpang() + "', "
                    +"         '" + this.getBus().getIdbus() + "', "
                    +"         '" + this.tanggalberangkat + "', "
                    +"         '" + this.tanggalpesan + "' "
                    +"         )";
            this.idreservasi = DBHelper.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE reservasi SET "
                    +" idpenumpang = '" + this.getPenumpang().getIdpenumpang() + "', "
                    +" idbus = '" + this.getBus().getIdbus() + "', "
                    +" tanggalberangkat = '" + this.tanggalberangkat + "', "
                    +" tanggalpesan = '" + this.tanggalpesan + "' "
                    +" WHERE idreservasi = '" + this.idreservasi + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM reservasi WHERE idreservasi = '" + this.idreservasi + "'";
        DBHelper.executeQuery(SQL);
    }
}
