package backend;
import java.util.ArrayList;
import java.sql.*;

public class Bus {
    private int idbus;
    private String namabus;
    private String jamberangkat;
    private int hargatiket;
    private String terminalasal;
    private String terminaltujuan;
    
    public Bus() {
        
    }
    
    public Bus(String namabus, String jamberangkat, int hargatiket, String terminalasal, String terminaltujuan) {
        this.namabus = namabus;
        this.jamberangkat = jamberangkat;
        this.hargatiket = hargatiket;
        this.terminalasal = terminalasal;
        this.terminaltujuan = terminaltujuan;
    }

    public int getIdbus() {
        return idbus;
    }

    public void setIdbus(int idbus) {
        this.idbus = idbus;
    }

    public String getNamabus() {
        return namabus;
    }

    public void setNamabus(String namabus) {
        this.namabus = namabus;
    }

    public String getJamberangkat() {
        return jamberangkat;
    }

    public void setJamberangkat(String jamberangkat) {
        this.jamberangkat = jamberangkat;
    }

    public int getHargatiket() {
        return hargatiket;
    }

    public void setHargatiket(int hargatiket) {
        this.hargatiket = hargatiket;
    }

    public String getTerminalasal() {
        return terminalasal;
    }

    public void setTerminalasal(String terminalasal) {
        this.terminalasal = terminalasal;
    }

    public String getTerminaltujuan() {
        return terminaltujuan;
    }

    public void setTerminaltujuan(String terminaltujuan) {
        this.terminaltujuan = terminaltujuan;
    }
    
    public String toString() {
        return namabus;
    }
    
    public Bus getById(int id) {
        Bus bus = new Bus();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM bus " 
                                            + " WHERE idbus = '" + id +"'");
        
        try {
            while(rs.next()) {
                bus = new Bus();
                bus.setIdbus(rs.getInt("idbus"));
                bus.setNamabus(rs.getString("namabus"));
                bus.setJamberangkat(rs.getString("jamberangkat"));
                bus.setHargatiket(rs.getInt("hargatiket"));
                bus.setTerminalasal(rs.getString("terminalasal"));
                bus.setTerminaltujuan(rs.getString("terminaltujuan"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return bus;
    }
    
    public ArrayList<Bus> getAll() {
        ArrayList<Bus> ListKategori = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM bus");
        
        try {
            while(rs.next()) {
                Bus bus = new Bus();
                bus.setIdbus(rs.getInt("idbus"));
                bus.setNamabus(rs.getString("namabus"));
                bus.setJamberangkat(rs.getString("jamberangkat"));
                bus.setHargatiket(rs.getInt("hargatiket"));
                bus.setTerminalasal(rs.getString("terminalasal"));
                bus.setTerminaltujuan(rs.getString("terminaltujuan"));
                
                ListKategori.add(bus);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public ArrayList<Bus> search(String keyword) {
        ArrayList<Bus> ListKategori = new ArrayList();
        
        String sql = "SELECT * FROM bus WHERE "
                + "     namabus LIKE '%" + keyword + "%' "
                + "     OR jamberangkat LIKE '%" + keyword + "%' "
                + "     OR idbus LIKE '%" + keyword + "%' "
                + "     OR hargatiket LIKE '%" + keyword + "%' "
                + "     OR terminalasal LIKE '%" + keyword + "%' "
                + "     OR terminaltujuan LIKE '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try {
            while(rs.next()) {
                Bus bus = new Bus();
                bus.setIdbus(rs.getInt("idbus"));
                bus.setNamabus(rs.getString("namabus"));
                bus.setJamberangkat(rs.getString("jamberangkat"));
                bus.setHargatiket(rs.getInt("hargatiket"));
                bus.setTerminalasal(rs.getString("terminalasal"));
                bus.setTerminaltujuan(rs.getString("terminaltujuan"));
                
                ListKategori.add(bus);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public void save() {
        if(getById(idbus).getIdbus() == 0) {
            String SQL = "INSERT INTO bus (namabus, jamberangkat, hargatiket, terminalasal, terminaltujuan) VALUES("
                    + "     '" + this.namabus + "', "
                    + "     '" + this.jamberangkat + "', "
                    + "     '" + this.hargatiket + "', "
                    + "     '" + this.terminalasal + "', "
                    + "     '" + this.terminaltujuan + "' "
                    + "     )";
            this.idbus = DBHelper.insertQueryGetId(SQL);
        }
        else {
            String SQL = "UPDATE bus SET "
                    + "     namabus = '" + this.namabus +"', "
                    + "     jamberangkat = '" + this.jamberangkat +"', "
                    + "     hargatiket = '" + this.hargatiket + "', "
                    + "     terminalasal = '" + this.terminalasal +"', "
                    + "     terminaltujuan = '" + this.terminalasal + "' "
                    + "     WHERE idbus = '" + this.idbus + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM bus WHERE idbus = '" + this.idbus + "'";
        DBHelper.executeQuery(SQL);
    }
}
