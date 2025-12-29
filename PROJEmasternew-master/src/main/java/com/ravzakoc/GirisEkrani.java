package com.ravzakoc;

import java.util.Scanner;

public class GirisEkrani {

    public static void girisYap() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Şifre: ");
            String sifre = sc.nextLine();

            boolean girisBasarili = false;

            // 1️⃣ MÜŞTERİ (Sipariş Veren)
            for (SiparisVerenKayıt sv : SiparisVerenMemory.musteriler) {
                if (sv.getEmail().equals(email) && sv.getPassword().equals(sifre)) {
                    System.out.println("✅ Müşteri girişi başarılı");
                    girisBasarili = true;
                    Session.aktifEmail = sv.getEmail();
                    return;
                }

            }

            // 2️⃣ SİPARİŞ ALAN (Organizasyon Alan Kişi)
            for (SiparisAlanKayıt sa : SiparisAlanMemory.organizasyonlar) {
                if (sa.getEmail().equals(email) && sa.getPassword().equals(sifre)) {
                    System.out.println("✅ Sipariş alan girişi başarılı");
                    girisBasarili = true;
                    Session.aktifEmail = sa.getEmail();
                    return;
                }

            }

            // 3️⃣ ORGANİZASYON ŞİRKETİ
            for (OrganizasyonSirketiKayıt os : OrganizasyonSirketiMemory.sirket) {
                if (os.getSirketemail().equals(email) && os.getPassword().equals(sifre)) {
                    System.out.println("✅ Organizasyon şirketi girişi başarılı");
                    girisBasarili = true;
                    Session.aktifEmail = os.getSirketemail();
                    return;
                }
            }



        }
    }
}
