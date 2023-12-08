package backend;

import java.util.ArrayList;
import java.sql.*;

public class Penumpang {
    private int idpenumpang;
    private String namapenumpang;
    private String alamat;
    private String gender;
    private String notelepon;
    
    public Penumpang() {
        
    }
    
    public Penumpang(String namapenumpang, String alamat, String gender, String notelepon) {
        this.namapenumpang = namapenumpang;
        this.alamat = alamat;
        this.gender = gender;
        this.notelepon = notelepon;
    }

    public int getIdpenumpang() {
        return idpenumpang;
    }

    public void setIdpenumpang(int idpenumpang) {
        this.idpenumpang = idpenumpang;
    }

    public String getNamapenumpang() {
        return namapenumpang;
    }

    public void setNamapenumpang(String namapenumpang) {
        this.namapenumpang = namapenumpang;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNotelepon() {
        return notelepon;
    }

    public void setNotelepon(String notelepon) {
        this.notelepon = notelepon;
    }
    
    public String toString() {
        return namapenumpang;
    }
    
    public Penumpang getById(int id) {
        Penumpang penumpang = new Penumpang();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penumpang " 
                                            + " WHERE idpenumpang = '" + id +"'");
        
        try {
            while(rs.next()) {
                penumpang = new Penumpang();
                penumpang.setIdpenumpang(rs.getInt("idpenumpang"));
                penumpang.setNamapenumpang(rs.getString("namapenumpang"));
                penumpang.setAlamat(rs.getString("alamat"));
                penumpang.setGender(rs.getString("gender"));
                penumpang.setNotelepon(rs.getString("notelepon"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return penumpang;
    }
    
    public ArrayList<Penumpang> getAll() {
        ArrayList<Penumpang> ListKategori = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penumpang");
        
        try {
            while(rs.next()) {
                Penumpang penumpang = new Penumpang();
                penumpang.setIdpenumpang(rs.getInt("idpenumpang"));
                penumpang.setNamapenumpang(rs.getString("namapenumpang"));
                penumpang.setAlamat(rs.getString("alamat"));
                penumpang.setGender(rs.getString("gender"));
                penumpang.setNotelepon(rs.getString("notelepon"));
                
                ListKategori.add(penumpang);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public ArrayList<Penumpang> search(String keyword) {
        ArrayList<Penumpang> ListKategori = new ArrayList();
        
        String sql = "SELECT * FROM penumpang WHERE "
                + "     idpenumpang LIKE '%" + keyword + "%' "
                + "     OR namapenumpang LIKE '%" + keyword + "%' "
                + "     OR alamat LIKE '%" + keyword + "%' "
                + "     OR gender LIKE '%" + keyword + "%' "
                + "     OR notelepon LIKE '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try {
            while(rs.next()) {
                Penumpang penumpang = new Penumpang();
                penumpang.setIdpenumpang(rs.getInt("idpenumpang"));
                penumpang.setNamapenumpang(rs.getString("namapenumpang"));
                penumpang.setAlamat(rs.getString("alamat"));
                penumpang.setGender(rs.getString("gender"));
                penumpang.setNotelepon(rs.getString("notelepon"));
                
                ListKategori.add(penumpang);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public void save() {
        if(getById(idpenumpang).getIdpenumpang() == 0) {
            String SQL = "INSERT INTO penumpang (namapenumpang, alamat, gender, notelepon) VALUES("
                    + "     '" + this.namapenumpang + "', "
                    + "     '" + this.alamat + "', "
                    + "     '" + this.gender + "', "
                    + "     '" + this.notelepon + "' "
                    + "     )";
            this.idpenumpang = DBHelper.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE penumpang SET "
                    + "     namapenumpang = '" + this.namapenumpang +"', "
                    + "     alamat = '" + this.alamat + "', "
                    + "     gender = '" + this.gender +"', "
                    + "     notelepon = '" + this.notelepon + "' "
                    + "     WHERE idpenumpang = '" + this.idpenumpang + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM penumpang WHERE idpenumpang = '" + this.idpenumpang + "'";
        DBHelper.executeQuery(SQL);
    }
}
