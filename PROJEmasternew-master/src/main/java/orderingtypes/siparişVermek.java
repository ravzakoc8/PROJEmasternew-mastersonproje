package orderingtypes;

import foodtypes.Normalyemek;
import foodtypes.VeganYemek;
import foodtypes.vejeteryanYemek;
import giveanorder.Bithday;
import giveanorder.KonseptParti;
import giveanorder.Kına;
import giveanorder.Nikah;

import java.util.Scanner;


public class siparişVermek {
    //Polimorfizmi burda kullandık sadece :

    Scanner scanner= new Scanner(System.in);
    SiparisDeposu depo;

    public siparişVermek(){
        System.out.println("Sipariş türünü giriniz.");
        System.out.println("1- organizasyon siparişi vermek istiyorum");
        System.out.println("2- yemek siparişi vermek istiyorum");
        System.out.println("3- yemek ve organizasyon siparişi vermek istiyorum ");
    }
    public void siparişVermek( int sipariştürü){ //overloading

        if (sipariştürü ==1){
            scanner.nextLine();
            System.out.println("İsteğiniz organizasyon siparişi vermek istiyorum olarak kabul edildi.");

            System.out.println("Vermek istediğiniz organizasyon türünü seçiniz.");
            System.out.println("1- Doğum günü");
            System.out.println("2- Konsept parti");
            System.out.println("3- Nişan");
            System.out.println("4-Kına");
            int organizasyontürü= scanner.nextInt();

            int orgTuru = scanner.nextInt();

            // ADIM 1: Polimorfik Referansı Oluştur (Henüz boş)
            SadeceOrganizasyonSiparişiVermek organizasyon = null;

            // ADIM 2: Sadece "new" işlemi yap (Kutuyu doldur)
            if (orgTuru == 1) {
                organizasyon = new Bithday();
            } else if (orgTuru == 2) {
                organizasyon = new KonseptParti();
            } else if (orgTuru == 3) {
                organizasyon = new Nikah();
            } else if (orgTuru == 4) {
                organizasyon = new Kına();
            } else {
                System.out.println("Geçersiz organizasyon seçimi.");
                return;
            }

            // ADIM 3: Metotları sadece BURADA çağır (Kod tekrarı bitti!)
            // Java, 'organizasyon' değişkeninin içinde hangi obje varsa (Kına mı, Doğumgünü mü) onu çalıştırır.
            organizasyon.aksesuarlar();
            organizasyon.numberOfPeople();
            organizasyon.waiterPreference();
            organizasyon.dj();
            organizasyon.tercihler();
            organizasyon.kayit();
        }

        else if (sipariştürü == 2) {
            System.out.println("Yemek türü seçiniz: 1-Normal, 2-Vejeteryan, 3-Vegan");
            int yemekTuru = scanner.nextInt();

            // ADIM 1: Polimorfik Referans (Boş kutu)
            SadeceYemekSiparişiVermek yemek = null;

            // ADIM 2: Kutuyu doldur
            if (yemekTuru == 1) {
                yemek = new Normalyemek();
            } else if (yemekTuru == 2) {
                yemek = new vejeteryanYemek();
            } else if (yemekTuru == 3) {
                yemek = new VeganYemek();
            } else {
                System.out.println("Geçersiz yemek seçimi.");
                return;
            }

            // ADIM 3: Metotları tek seferde çalıştır
            yemek.yemekadı();
            yemek.kişisayisi();
            yemek.icecektercihi();
            yemek.tatlitercihi();
            yemek.kayit();
        }
        else if (sipariştürü == 3) {
            orderingMealAndOrganisation orderingMealAndOrganisation = new orderingMealAndOrganisation();
            orderingMealAndOrganisation.order();
        }

        else {
            System.out.println("Geçersiz ana menü seçimi.");
        }



    }
}