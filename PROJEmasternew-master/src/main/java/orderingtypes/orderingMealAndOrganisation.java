package orderingtypes;

import com.ravzakoc.Session;
import foodtypes.Normalyemek;
import foodtypes.VeganYemek;
import foodtypes.vejeteryanYemek;
import giveanorder.Bithday;
import giveanorder.KonseptParti;
import giveanorder.Kına;
import giveanorder.Nikah;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class orderingMealAndOrganisation {
Scanner scanner = new Scanner(System.in);
    private SiparisDeposu depo;

    private SadeceOrganizasyonSiparişiVermek secilenOrganizasyon;
    private SadeceYemekSiparişiVermek secilenYemek;

    public orderingMealAndOrganisation(){
// empty constructor
    }
    public orderingMealAndOrganisation(SiparisDeposu gelenDepo) {
        this.depo = gelenDepo;
        this.scanner = new Scanner(System.in);
    }


   public void order() {
       System.out.println("\n--- BÖLÜM 1: ORGANİZASYON SEÇİMİ ---");
       // Organizasyon Kodlarını Kopyaladık
       System.out.println("Vermek istediğiniz organizasyon türünü seçiniz.");
       System.out.println("1- Doğum günü\n 2- Konsept parti\n 3- Nişan\n 4- Kına");
       int organizasyontürü = scanner.nextInt();

       SadeceOrganizasyonSiparişiVermek orgSiparis = null;

       if (organizasyontürü == 1) orgSiparis = new Bithday();
       if (organizasyontürü == 2) orgSiparis = new KonseptParti();
       if (organizasyontürü == 3) orgSiparis = new Nikah();
       if (organizasyontürü == 4) orgSiparis = new Kına();

       if (orgSiparis != null) {
           orgSiparis.aksesuarlar();
           orgSiparis.numberOfPeople();
           orgSiparis.waiterPreference();
           orgSiparis.dj();
           orgSiparis.tercihler();
           this.secilenOrganizasyon = orgSiparis;
           depo.organizasyonEkle(orgSiparis); // Depoya kaydet
           System.out.println(">> Organizasyon sepete eklendi.");
       }

       System.out.println("\n--- BÖLÜM 2: YEMEK SEÇİMİ ---");
       // Yemek Kodlarını Kopyaladık
       System.out.println("Vermek istediğiniz yemek türünü seçiniz.");
       System.out.println("1-Normal yemek\n2-Vejeteryan yemek\n3-Vegan yemek");
       int yemektürü = scanner.nextInt();

       SadeceYemekSiparişiVermek yemekSiparis = null;

       if (yemektürü == 1) yemekSiparis = new Normalyemek();
       else if (yemektürü == 2) yemekSiparis = new vejeteryanYemek();
       else if (yemektürü == 3) yemekSiparis = new VeganYemek();
       else System.out.println("yanlış tercih yaptınız.");

       if (yemekSiparis != null) {
           yemekSiparis.yemekadı();
           yemekSiparis.kişisayisi();
           yemekSiparis.icecektercihi();
           yemekSiparis.tatlitercihi();
           this.secilenYemek = yemekSiparis;
           depo.yemekEkle("Yemek Siparişi (Karma Menü)"); // Depoya kaydet
           System.out.println(">> Yemek sepete eklendi.");
       }

       System.out.println("\nHer iki siparişiniz de başarıyla alındı.");
   }
   public void kayit(){
        dosyayaYaz(secilenOrganizasyon, secilenYemek);
       System.out.println("tercihleriniz dosyaya kayıt edildi.");
   }
    public void dosyayaYaz(SadeceOrganizasyonSiparişiVermek org,
                           SadeceYemekSiparişiVermek yemek) {

        try {
            FileWriter fw = new FileWriter(
                    "PROJEmasternew-master/src/main/java/com/ravzakoc/yemekveorg_siparişleri", true);

            fw.write(" Email: " + Session.aktifEmail  +
                    " KARMA SIPARIS | " +

                            // --- ORGANİZASYON ---
                            "Organizasyon: Dogum Gunu" +
                            " | Isim: " + org.getName() +
                            " | Renk: " + org.getColour() +
                            " | Org Kisi Sayisi: " + org.getNumberOfPeople() +
                            " | Garson: " + (org.getWaiterPreference()
                            ? "Var (" + org.getNumberOfWaiters() + ")" : "Yok") +
                            " | DJ: " + (org.getdj() ? "Var" : "Yok") +

                            " || " +

                            // --- YEMEK ---
                            "Yemek: Normal Yemek" +
                            " | Yemek Turu: " + yemek.getYemek() +
                            " | Yemek Kisi Sayisi: " + yemek.getNumberOfPeople() +
                            " | Icecek: " + (yemek.getBeveragePreference()
                            ? yemek.getDrink() : "Yok") +
                            " | Tatli: " + (yemek.getdessertPreference()
                            ? yemek.getDessert() : "Yok") +

                            "\n"
            );

            fw.close();
            System.out.println("Karma siparis dosyaya kaydedildi.");

        } catch (IOException e) {
            System.out.println("Karma siparis dosyaya yazma hatasi: " + e.getMessage());
        }
    }

}


