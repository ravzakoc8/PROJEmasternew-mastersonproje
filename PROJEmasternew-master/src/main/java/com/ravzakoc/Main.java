package com.ravzakoc;

import foodtypes.siparisAlmak;
import orderingtypes.SiparisDeposu;
import orderingtypes.orderingMealAndOrganisation;
import orderingtypes.siparişVermek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SiparisDeposu ortakDepo = new SiparisDeposu();

        System.out.println("Hoş geldiniz yapmak istediğiniz işlemin numarasını seçiniz.");
        System.out.println("1- sipariş vermek istiyorum");
        System.out.println("2- sipariş almak istiyorum.");

        int numara = scanner.nextInt();
        if (numara == 1) {
            System.out.println("Seçiminiz sipariş vermek olarak alındı");
            System.out.println("Lütfen kaydınız yoksa kayıt ekranından kayıt olun eğer kaydınız varsa giriş ekranına gidiniz.");
            System.out.println("1-Kayıt ekranı");
            System.out.println("2-giriş ekranı");
            int kayıt = scanner.nextInt();
            if (kayıt == 1) {
                SiparisVerenKayıt kayıt1 = new SiparisVerenKayıt();
                kayıt1.kayitAl();

            } else if (kayıt == 2) {
                GirisEkrani girisEkrani = new GirisEkrani();
              OrderCustomerFileManager.dosyadanYukle(); // 🔥 ESKİ KAYITLAR GELİR
                girisEkrani.girisYap();

            } else {
                System.out.println("invalid login");
                return;
            }


            siparişVermek sv = new siparişVermek();
            int sipariştürü = scanner.nextInt();
            sv.siparişVermek(sipariştürü);

        } else if (numara == 2) {
            System.out.println("Seçiminiz sipariş almak olarak alındı");
            SiparisDeposu depo = new SiparisDeposu();

            siparisAlmak siparis = new siparisAlmak(depo);

            siparis.menuGoster();           // 👈 MENÜ BURADA
            int secim = scanner.nextInt();
            siparis.siparisAlmak1(secim);

        } else {
            System.out.println("Geçersiz giriş");
            return;
        }




    }
}
