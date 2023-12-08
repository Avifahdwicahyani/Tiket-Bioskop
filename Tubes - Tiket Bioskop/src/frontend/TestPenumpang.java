package frontend;

import backend.*;
public class TestPenumpang {
    public static void main(String[] args) {
        Penumpang p = new Penumpang("Dandi", "Lumajang", "Laki-laki", "087846184617");
        Penumpang p2 = new Penumpang("Pramudya", "Probolinggo", "Laki-laki", "085852754556");
        Penumpang p3 = new Penumpang("Fai", "Malang", "Laki-laki", "085334567889");
        
        p.save();
        p2.save();
        p3.save();
        
        p2.setAlamat("Malang");
        p2.save();
        
        p3.delete();
        
        for(Penumpang penumpang : new Penumpang().getAll()) {
            System.out.println("==============================================");
            System.out.println("Nama Penumpang\t= " + penumpang.getNamapenumpang());
            System.out.println("Alamat\t\t= " + penumpang.getAlamat());
            System.out.println("Gender\t\t= " + penumpang.getGender());
            System.out.println("Telepon\t\t= " + penumpang.getNotelepon());
            System.out.println("==============================================");
            System.out.println();
        }
        
        for(Penumpang penumpang : new Penumpang().search("Fauzan")) {
            System.out.println("==============================================");
            System.out.println("Nama Penumpang\t= " + penumpang.getNamapenumpang());
            System.out.println("Alamat\t\t= " + penumpang.getAlamat());
            System.out.println("Gender\t\t= " + penumpang.getGender());
            System.out.println("Telepon\t\t= " + penumpang.getNotelepon());
            System.out.println("==============================================");
            System.out.println();
        }
    }
}
