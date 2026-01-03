package com.ravzakoc;

import java.util.Scanner;

public class TakeOrderRegister implements RegisterScreen {

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
            System.out.println("Invalid email! (Write with at least 3 characters, use @ and . )");
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
            System.out.println("Invalid password! (Write with at least 3 characters)");
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
            System.out.println("Invalid Turkish ID number! It must be exactly 11 digits long. (Entered: " + tc.length() +" digits");
            return false; // Hata var, false dön
        }

        // 2. Rakam Kontrolü
        for (int i = 0; i < tc.length(); i++) {
            if (!Character.isDigit(tc.charAt(i))) {
                System.out.println("Invalid Turkish ID number! Only digits are allowed.");
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
    public void register() {
        // Scanner buffer temizliği (Eğer önceki menüden kalıntı varsa temizler)
        // scanner.nextLine(); // Gerekirse bu satırı yorumdan çıkarın

        // 1. EMAIL DÖNGÜSÜ
        while (true) {
            System.out.print("Enter email: ");
            String inputEmail = scanner.nextLine().trim(); // Boşlukları temizle
            setEmail(inputEmail);

            if (this.email != null) {
                break;
            }
        }

        // 2. ŞİFRE DÖNGÜSÜ
        while (true) {
            System.out.print("Enter password (with atleast 3 characters): ");
            String password = scanner.nextLine().trim();
            setPassword(password);

            if (this.password != null) {
                break;
            }
        }

        // 3. TC DÖNGÜSÜ (Burada hata olması imkansız hale getirildi)
        while (true) {
            System.out.print("Enter Turkish ID number: ");
            String input = scanner.nextLine().trim();

            boolean result = setTc(input);

            if (result == true) {
                break;
            }

        }


        while (true) {
            System.out.print("Write adress with atleast 3 characters: ");
            String address = scanner.nextLine();
            setaddress(address);
            if (this.address!=null){
                break;
            }}

        System.out.println("Registration completed successfully.");

        TakeOrderMemory.organisations.add(this);
        OrderProviderFileManager.saveToFile(); // 💾 KAYDET
        System.out.println("Redirected to the login screen.");
        LoginScreen.login();

    }
}