package com.ravzakoc;

import java.util.Scanner;

public class SiparisVerenKayıt implements KayıtEkranı {

    private String email;
    private String password;
    private Long tc;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        if (email.length() >= 3
                && email.contains("@")
                && email.contains(".")
                && !email.matches("\\d+")){
            this.email = email; // ✅ SADECE GEÇERLİYSE SET
        } else {
            System.out.println("Geçersiz email! (en az 3 karakter, @ ve . içermeli)");
            this.email = null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        if (password.length() >= 3 && !password.matches("\\d+")) {
            this.password = password; // ✅
        } else {
            System.out.println("Geçersiz şifre! (En az 3 karakter)");
            this.password = null;
        }
    }

    public Long gettc(){
        return tc;
    }

    public void setTc(long tc) {
        int basamakSayisi = String.valueOf(tc).length();
        if (basamakSayisi == 11 ) {
            this.tc = tc; // ✅
        } else {
            System.out.println("Geçersiz TC! (11 haneli olmalı)");
            this.tc = null;
        }
    }

    public String getaddress(){
        return address;
    }

    public void setaddress (String address){
        if (address.length() >= 3 && !address.matches("\\d+")) {
            this.address = address; // ✅
        } else {
            System.out.println("Geçersiz adres!");
            this.address = null;
        }
    }

    @Override
    public void kayitAl() {
        Scanner scanner = new Scanner(System.in);

        // EMAIL
        while (true) {
            System.out.print("Email giriniz: ");
            setEmail(scanner.nextLine());
            if (email != null) break;
        }

        // PASSWORD
        while (true) {
            System.out.print("Şifre giriniz: ");
            setPassword(scanner.nextLine());
            if (password != null) break;
        }

        // TC
        while (true) {
            System.out.print("TC Kimlik No giriniz: ");
            if (scanner.hasNextLong()) {
                setTc(scanner.nextLong());
                scanner.nextLine(); // 🔥 BUFFER TEMİZLEME
                if (tc != null) break;
            } else {
                System.out.println("Lütfen sadece sayı giriniz.");
                scanner.nextLine();
            }
        }

        // ADDRESS
        while (true) {
            System.out.print("Adres giriniz: ");
            setaddress(scanner.nextLine());
            if (address != null) break;
        }

        SiparisVerenMemory.musteriler.add(this);SiparisVerenMemory.musteriler.add(this);
        OrderCustomerFileManager.dosyayaKaydet(this); // 🔥 EKLENDİ
        System.out.println("Kayıt başarılı, giriş ekranına yönlendiriliyorsunuz...");
        GirisEkrani.girisYap();

    }
}
