package backend;

import java.util.ArrayList;
import java.sql.*;

public class Tiket {
    private int idtiket;
    private Bus bus = new Bus();
    private String jadwal;
    private String nokursi;
    private String kelas;

    public int getIdtiket() {
        return idtiket;
    }

    public void setIdtiket(int idtiket) {
        this.idtiket = idtiket;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getNokursi() {
        return nokursi;
    }

    public void setNokursi(String nokursi) {
        this.nokursi = nokursi;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
    public Tiket() {
        
    }
    
    public Tiket(Bus bus, String jadwal, String nokursi, String kelas) {
        this.bus = bus;
        this.jadwal = jadwal;
        this.nokursi = nokursi;
        this.kelas = kelas;
    }
    
    public Tiket getById(int id) {
        Tiket tiket = new Tiket();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + " t.idtiket AS idtiket, "
                                    + " t.jadwal AS jadwal, "
                                    + " t.nokursi AS nokursi, "
                                    + " t.kelas AS kelas, "
                                    + " b.idbus AS idbus, "
                                    + " b.namabus AS namabus, "
                                    + " b.jamberangkat AS jamberangkat, "
                                    + " b.hargatiket AS hargatiket, "
                                    + " b.terminalasal AS terminalasal, "
                                    + " b.terminaltujuan AS terminaltujuan "
                                    + " FROM tiket t "
                                    + " LEFT JOIN bus b ON t.idbus = b.idbus "
                                    + " WHERE t.idtiket = '" + id + "'");
        
        try {
            while(rs.next()){
                tiket = new Tiket();
                tiket.setIdtiket(rs.getInt("idtiket"));
                tiket.getBus().setIdbus(rs.getInt("idbus"));
                tiket.getBus().setNamabus(rs.getString("namabus"));
                tiket.getBus().setJamberangkat(rs.getString("jamberangkat"));
                tiket.getBus().setHargatiket(rs.getInt("hargatiket"));
                tiket.getBus().setTerminalasal(rs.getString("terminalasal"));
                tiket.getBus().setTerminaltujuan(rs.getString("terminaltujuan"));
                tiket.setJadwal(rs.getString("jadwal"));
                tiket.setNokursi(rs.getString("nokursi"));
                tiket.setKelas(rs.getString("kelas"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tiket;
    }

    public ArrayList<Tiket> getAll() {
        ArrayList<Tiket> ListTiket = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + " t.idtiket AS idtiket, "
                                    + " t.jadwal AS jadwal, "
                                    + " t.nokursi AS nokursi, "
                                    + " t.kelas AS kelas, "
                                    + " b.idbus AS idbus, "
                                    + " b.namabus AS namabus, "
                                    + " b.jamberangkat AS jamberangkat, "
                                    + " b.hargatiket AS hargatiket, "
                                    + " b.terminalasal AS terminalasal, "
                                    + " b.terminaltujuan AS terminaltujuan "
                                    + " FROM tiket t "
                                    + " LEFT JOIN bus b ON t.idbus = b.idbus ");
        try {
            while(rs.next()){
                Tiket tiket = new Tiket();
                tiket.setIdtiket(rs.getInt("idtiket"));
                tiket.getBus().setIdbus(rs.getInt("idbus"));
                tiket.getBus().setNamabus(rs.getString("namabus"));
                tiket.getBus().setJamberangkat(rs.getString("jamberangkat"));
                tiket.getBus().setHargatiket(rs.getInt("hargatiket"));
                tiket.getBus().setTerminalasal(rs.getString("terminalasal"));
                tiket.getBus().setTerminaltujuan(rs.getString("terminaltujuan"));
                tiket.setJadwal(rs.getString("jadwal"));
                tiket.setNokursi(rs.getString("nokursi"));
                tiket.setKelas(rs.getString("kelas"));

                ListTiket.add(tiket);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListTiket;
    }

    public ArrayList<Tiket> search(String keyword) {
        ArrayList<Tiket> ListTiket = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                                    + " t.idtiket AS idtiket, "
                                    + " t.jadwal AS jadwal, "
                                    + " t.nokursi AS nokursi, "
                                    + " t.kelas AS kelas, "
                                    + " b.idbus AS idbus, "
                                    + " b.namabus AS namabus, "
                                    + " b.jamberangkat AS jamberangkat, "
                                    + " b.hargatiket AS hargatiket, "
                                    + " b.terminalasal AS terminalasal, "
                                    + " b.terminaltujuan AS terminaltujuan "
                                    + " FROM tiket t "
                                    + " LEFT JOIN bus b ON t.idbus = b.idbus "
                                    + " WHERE t.jadwal LIKE '%" + keyword + "%' "
                                    + " OR t.idtiket LIKE '%" + keyword + "%' "
                                    + " OR t.nokursi LIKE '%" + keyword + "%' "
                                    + " OR t.kelas LIKE '%" + keyword + "%' "
                                    + " OR b.namabus LIKE '%" + keyword + "%' "
                                    + " OR b.jamberangkat LIKE '%" + keyword + "%' ");
        try {
            while(rs.next()){
                Tiket tiket = new Tiket();
                tiket.setIdtiket(rs.getInt("idtiket"));
                tiket.getBus().setIdbus(rs.getInt("idbus"));
                tiket.getBus().setNamabus(rs.getString("namabus"));
                tiket.getBus().setJamberangkat(rs.getString("jamberangkat"));
                tiket.getBus().setHargatiket(rs.getInt("hargatiket"));
                tiket.getBus().setTerminalasal(rs.getString("terminalasal"));
                tiket.getBus().setTerminaltujuan(rs.getString("terminaltujuan"));
                tiket.setJadwal(rs.getString("jadwal"));
                tiket.setNokursi(rs.getString("nokursi"));
                tiket.setKelas(rs.getString("kelas"));

                ListTiket.add(tiket);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListTiket;
    }

    public void save() {
        if(getById(idtiket).getIdtiket() == 0) {
            String SQL = "INSERT INTO tiket (idbus, jadwal, nokursi, kelas) VALUES("
                + " '" + this.getBus().getIdbus() + "', "
                + " '" + this.jadwal + "', "
                + " '" + this.nokursi + "', "
                + " '" + this.kelas + "' "
                + " )";
            this.idtiket = DBHelper.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE tiket SET "
                + " idbus = '" + this.getBus().getIdbus() + "', "
                + " jadwal = '" + this.jadwal + "', "
                + " nokursi = '" + this.nokursi + "', "
                + " kelas = '" + this.kelas + "' "
                + " WHERE idtiket = '" + this.idtiket + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM tiket WHERE idtiket = '" + this.idtiket + "'";
        DBHelper.executeQuery(SQL);
    }
}
