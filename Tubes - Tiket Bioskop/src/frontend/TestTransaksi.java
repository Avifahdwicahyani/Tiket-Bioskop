package frontend;


import backend.*;
public class TestTransaksi {
    public static void main(String[] args) {
        Reservasi rs1 = new Reservasi().getById(1);
        Reservasi rs2 = new Reservasi().getById(3);
        Reservasi rs3 = new Reservasi().getById(4);
        Reservasi rs4 = new Reservasi().getById(7);
        
        Transaksi tr1 = new Transaksi("20201130", 1, 45000, 45000, rs1);
        Transaksi tr2 = new Transaksi("20201201", 3, 75000, 225000, rs2);
        Transaksi tr3 = new Transaksi("20201203", 2, 105000, 210000, rs3);
        Transaksi tr4 = new Transaksi("20201130", 3, 70000, 210000, rs4);
        
//        tr1.save();
//        tr2.save();
//        tr3.save();
//        tr4.save();
//        
//        tr2.setJumlahtiket(2);
//        tr2.setTotalbayar(150000);
//        tr2.save();
//        
//        tr4.delete();
        
        for(Transaksi tr : new Transaksi().getAll()) {
            System.out.println("==============================================");
            System.out.println("Tanggal Bayar\t\t= " + tr.getTanggalbayar());
            System.out.println("Jumlah Tiket\t\t= " + tr.getJumlahtiket());
            System.out.println("Harga Tiket\t\t= Rp." + tr.getHargatiket());
            System.out.println("Total Bayar\t\t= Rp." + tr.getTotalbayar());
            System.out.println("Reservasi\t\t= " + tr.getReservasi().getTanggalpesan());
            System.out.println("==============================================");
        }
        
        
        for(Transaksi tr : new Transaksi().search("20201012")) {
            System.out.println("================ CARI TRANSAKSI ==============");
            System.out.println("Tanggal Bayar\t\t= " + tr.getTanggalbayar());
            System.out.println("Jumlah Tiket\t\t= " + tr.getJumlahtiket());
            System.out.println("Harga Tiket\t\t= Rp." + tr.getHargatiket());
            System.out.println("Total Bayar\t\t= Rp." + tr.getTotalbayar());
            System.out.println("Reservasi\t\t= " + tr.getReservasi().getTanggalpesan());
            System.out.println("==============================================");
        }
    }
}
