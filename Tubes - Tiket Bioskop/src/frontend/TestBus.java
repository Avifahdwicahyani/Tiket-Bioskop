package frontend;


import backend.*;
public class TestBus {
    public static void main(String[] args) {
        Bus bus1 = new Bus("Perum PPD", "17:45", 45000, "Terminal Ambulu", "Terminal Arjosari");
        Bus bus2 = new Bus("BIG Bird", "18:15", 75000, "Terminal Anjuk Ladang", "Terminal Arya Wiraraja");
        Bus bus3 = new Bus("Eagle High", "20:00", 80000, "Terminal Batu", "Terminal Brawijaya");
        Bus bus4 = new Bus("Sinar Jaya", "21:30", 105000, "Terminal Joyoboyo", "Terminal Bondowoso");
        Bus bus5 = new Bus("DAMRI", "19:00", 70000, "Terminal Joyoboyo", "Terminal Arjosari");
        Bus bus6 = new Bus("Gunung Harta", "18:45", 55000, "Terminal Krian", "Terminal Arjosari");
        
        for(Bus bus : new Bus().getAll()) {
            System.out.println("==============================================");
            System.out.println("Nama Bus\t\t= " + bus.getNamabus());
            System.out.println("Jam Berangkat\t\t= " + bus.getJamberangkat());
            System.out.println("Harga Tiket\t\t= Rp." + bus.getHargatiket());
            System.out.println("Terminal Asal\t\t= " + bus.getTerminalasal());
            System.out.println("Terminal Tujuan\t\t= " + bus.getTerminaltujuan());
            System.out.println("==============================================");
        }
        
        // test search
        for(Bus bus : new Bus().search("Sempati Star")) {
            System.out.println("=================== CARI BUS =================");
            System.out.println("Nama Bus\t\t= " + bus.getNamabus());
            System.out.println("Jam Berangkat\t\t= " + bus.getJamberangkat());
            System.out.println("Harga Tiket\t\t= Rp." + bus.getHargatiket());
            System.out.println("Terminal Asal\t\t= " + bus.getTerminalasal());
            System.out.println("Terminal Tujuan\t\t= " + bus.getTerminaltujuan());
            System.out.println("==============================================");
        }
    }
}
