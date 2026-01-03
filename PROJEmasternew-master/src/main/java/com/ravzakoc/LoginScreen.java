package com.ravzakoc;

import java.util.Scanner;

public class LoginScreen {

    public static void login() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Redirected to the login screen");

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            boolean loginSuccessful = false;

            // 1️⃣ MÜŞTERİ (Sipariş Veren)
            for (OrderRegistration sv : OrderMemory.customer) {
                if (sv.getEmail().equals(email) && sv.getPassword().equals(password)) {
                    System.out.println("Customer login successful");
                    loginSuccessful = true;
                    Session.activeEmail = sv.getEmail();
                    return;
                }

            }

            // 2️⃣ SİPARİŞ ALAN (Organizasyon Alan Kişi)
            for (TakeOrderRegister sa : TakeOrderMemory.organisations) {
                if (sa.getEmail().equals(email) && sa.getPassword().equals(password)) {
                    System.out.println("Order taker login successful");
                    loginSuccessful = true;
                    Session.activeEmail = sa.getEmail();
                    return;
                }

            }

            // 3️⃣ ORGANİZASYON ŞİRKETİ
            for (OrganisationCompanyRegister os : OrganisationCompanyMemory.company) {
                if (os.getCompanyEmail().equals(email) && os.getPassword().equals(password)) {
                    System.out.println("Organization login successful");
                    loginSuccessful = true;
                    Session.activeEmail = os.getCompanyEmail();
                    return;
                }
            }

break;

        }
    }
}
