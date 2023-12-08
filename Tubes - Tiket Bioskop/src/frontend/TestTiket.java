package frontend;


import backend.*;
public class TestTiket {
    public static void main(String[] args) {
        Bus bus1 = new Bus().getById(1);
        Bus bus2 = new Bus().getById(2);
        Bus bus3 = new Bus().getById(4);
        Bus bus4 = new Bus().getById(5);
        
        Tiket tiket1 = new Tiket(bus1, "20201201", "12AA", "Ekekutif");
        Tiket tiket2 = new Tiket(bus2, "20201202", "12AB", "Eksekutif");
        Tiket tiket3 = new Tiket(bus3, "20201203", "12AC", "Eksekutif");
        Tiket tiket4 = new Tiket(bus4, "20201204", "12AD", "Ekonomi");
        Tiket tiket5 = new Tiket(bus1, "20201205", "12AA", "Ekonomi");
        
        tiket1.save();
        tiket2.save();
        tiket3.save();
        tiket4.save();
        tiket5.save();
        
        tiket2.setNokursi("12AE");
        tiket2.save();
        
        tiket5.delete();
        
        for(Tiket t : new Tiket().getAll()) {
            System.out.println("==============================================");
            System.out.println("Bus\t\t= " + t.getBus().getNamabus());
            System.out.println("Jadwal\t\t= " + t.getJadwal());
            System.out.println("Nomor Kursi\t= " + t.getNokursi());
            System.out.println("Kelas\t\t= " + t.getKelas());
            System.out.println("==============================================");
            System.out.println();
        }
        
        for(Tiket t : new Tiket().search("12A")) {
            System.out.println("=================== CARI BUS =================");
            System.out.println("Bus\t\t= " + t.getBus().getNamabus());
            System.out.println("Jadwal\t\t= " + t.getJadwal());
            System.out.println("Nomor Kursi\t= " + t.getNokursi());
            System.out.println("Kelas\t\t= " + t.getKelas());
            System.out.println("==============================================");
        }
    }
}
