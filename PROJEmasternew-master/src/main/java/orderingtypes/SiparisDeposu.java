package orderingtypes;

import java.util.ArrayList;
import java.util.List;

public class SiparisDeposu extends organizasyonListesi {

    public SiparisDeposu() {
        this.organizasyonListesi = new ArrayList<>();
        this.yemekListesi = new ArrayList<>();
    }

    // SiparisDeposu.java dosyasının içi

    public void organizasyonlariListele() {
        System.out.println("\n--- ORGANİZASYON LİSTESİ ---");
        if (organizasyonListesi.isEmpty()) {
            System.out.println("Şu an hiç organizasyon siparişi yok.");
        } else {
            for (SadeceOrganizasyonSiparişiVermek org : organizasyonListesi) {
                // ToString metodunu çağırarak ekrana basar
                System.out.println(org.toString());
            }
        }
    }

    public void yemekleriListele() {
        System.out.println("YEMEK LİSTESİ ");
        if (yemekListesi.isEmpty()) {
            System.out.println("Şu an hiç yemek siparişi yok.");
        } else {
            for (String yemek : yemekListesi) {
                System.out.println("- " + yemek);
            }
        }
    }
    public void organizasyonveyemkListele() {
        System.out.println("ORGANİZASYON VE YEMEK LİSTESİ");
        if (yemekveorgSiparisi.isEmpty()) {
            System.out.println("Şu an hiç organizasyon ve yemek siparişi yok.");
        } else {
            for (orderingMealAndOrganisation yemekorg : yemekveorgSiparisi) {
                // Burada nesneyi yazdırmalısınız
                System.out.println("- " + yemekorg.toString());
            }
        }
    }
}
