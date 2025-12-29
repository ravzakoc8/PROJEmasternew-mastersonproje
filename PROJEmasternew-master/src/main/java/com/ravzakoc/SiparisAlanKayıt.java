package com.ravzakoc;

import java.util.Scanner;

public class SiparisAlanKayıt implements KayıtEkranı {

    private String email;
    private String password;
    private String tc;
    private String address;

    // Scanner'ı burada tanımlıyoruz ki her metodda yeniden oluşturulmasın
    private Scanner scanner = new Scanner(System.in);

    // --- GETTER & SETTER METOTLARI ---

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length() >= 3 && email.contains("@") && email.contains(".") && !email.matches("\\d+")) {
            this.email = email;
        } else {
            System.out.println("Geçersiz email! (en az 3 karakter, @ ve . içermeli)");
            this.email = null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() >= 3 && !password.matches("\\d+")) {
            this.password = password;
        } else {
            System.out.println("Geçersiz şifre! (En az 3 karakter)");
            this.password = null;
        }
    }

    public String gettc() {
        return tc;
    }


    public boolean setTc(String tc) {

        // Önce null yapalım, garanti olsun
        this.tc = null;

        // 1. Uzunluk Kontrolü
        if (tc.length() != 11) {
            System.out.println("Geçersiz TC! Tam 11 haneli olmalıdır. (Girilen: " + tc.length() + " hane)");
            return false; // Hata var, false dön
        }

        // 2. Rakam Kontrolü
        for (int i = 0; i < tc.length(); i++) {
            if (!Character.isDigit(tc.charAt(i))) {
                System.out.println("Geçersiz TC! Sadece rakam girilmelidir.");
                return false; // Hata var, false dön
            }
        }

        // 3. Her şey yolunda
        this.tc = tc;
        return true; // Başarılı, true dön
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        if (address.length() >= 3 && !address.matches("\\d+")) {
            this.address = address;
        }else {
            System.out.println("Invalid adress write with atleast 3 characters");
            this.address = null;
        }
    }




    @Override
    public void kayitAl() {
        // Scanner buffer temizliği (Eğer önceki menüden kalıntı varsa temizler)
        // scanner.nextLine(); // Gerekirse bu satırı yorumdan çıkarın

        // 1. EMAIL DÖNGÜSÜ
        while (true) {
            System.out.print("Email giriniz: ");
            String inputEmail = scanner.nextLine().trim(); // Boşlukları temizle
            setEmail(inputEmail);

            if (this.email != null) {
                break;
            }
        }

        // 2. ŞİFRE DÖNGÜSÜ
        while (true) {
            System.out.print("Şifre giriniz (En az 3 karakter): ");
            String password = scanner.nextLine().trim();
            setPassword(password);

            if (this.password != null) {
                break;
            }
        }

        // 3. TC DÖNGÜSÜ (Burada hata olması imkansız hale getirildi)
        while (true) {
            System.out.print("TC Kimlik No giriniz: ");
            String input = scanner.nextLine().trim();

            boolean sonuc = setTc(input);

            if (sonuc == true) {
                break;
            }

        }


        while (true) {
            System.out.print("Write adress with atleast 3 characters: ");
            String adress = scanner.nextLine();
            setaddress(adress);
            if (this.address!=null){
                break;
            }}

        System.out.println("Kayıt başarıyla tamamlandı.");

        SiparisAlanMemory.organizasyonlar.add(this);
        SiparisAlanMemory.dosyayaKaydet(); // 💾 KAYDET
        System.out.println("Giriş Ekranına grçiş yapıldı");
        GirisEkrani.girisYap();

    }
}