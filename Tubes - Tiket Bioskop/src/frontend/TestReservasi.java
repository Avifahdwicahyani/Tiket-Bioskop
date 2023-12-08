package frontend;


import backend.*;
public class TestReservasi {
    public static void main(String[] args) {
        Penumpang penumpang1 = new Penumpang().getById(1);
        Penumpang penumpang2 = new Penumpang().getById(4);
        Penumpang penumpang3 = new Penumpang().getById(5);
        
        Bus bus1 = new Bus().getById(1);
        Bus bus2 = new Bus().getById(2);
        Bus bus3 = new Bus().getById(4);
        Bus bus4 = new Bus().getById(5);
        
        Reservasi rs1 = new Reservasi(penumpang1, bus1, "20201201", "20201129");
        Reservasi rs2 = new Reservasi(penumpang2, bus2, "20201202", "20201128");
        Reservasi rs3 = new Reservasi(penumpang3, bus3, "20201203", "20201130");
        Reservasi rs4 = new Reservasi(penumpang1, bus4, "20201204", "20201202");
        Reservasi rs5 = new Reservasi(penumpang2, bus1, "20201201", "20201130");
        
        
        for(Reservasi rs : new Reservasi().getAll()) {
            System.out.println("==============================================");
            System.out.println("Penumpang\t\t= " + rs.getPenumpang().getNamapenumpang());
            System.out.println("Bus\t\t\t= " + rs.getBus().getNamabus());
            System.out.println("Tanggal Berangkat\t= " + rs.getTanggalberangkat());
            System.out.println("Tanggal Pesan\t\t= " + rs.getTanggalpesan());
            System.out.println("==============================================");
            System.out.println();
        } 
        
        for(Reservasi rs : new Reservasi().search("20201202")) {
            System.out.println("==============================================");
            System.out.println("Penumpang\t\t= " + rs.getPenumpang().getNamapenumpang());
            System.out.println("Bus\t\t\t= " + rs.getBus().getNamabus());
            System.out.println("Tanggal Berangkat\t= " + rs.getTanggalberangkat());
            System.out.println("Tanggal Pesan\t\t= " + rs.getTanggalpesan());
            System.out.println("==============================================");
            System.out.println();
        }
    }
}
