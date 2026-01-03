package com.ravzakoc;

import foodtypes.TakeOrder;
import orderingtypes.OrderDepot;
import orderingtypes.Order;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OrderDepot sharedStorage = new OrderDepot();

        System.out.println("Welcome! Please choose an option by entering its number.");
        System.out.println("1-I want to place an order.");
        System.out.println("2-I want to take orders.");

        int number = scanner.nextInt();
        if (number == 1) {
            System.out.println("Your selection has been received as placing an order.");
            System.out.println("If you are not registered, please sign up on the registration screen. If you already have an account, please go to the login screen.");
            System.out.println("1-Register Screen");
            System.out.println("2-Login Screen");
            int register = scanner.nextInt();
            if (register == 1) {
                OrderRegistration register1 = new OrderRegistration();
                register1.register();

            } else if (register == 2) {
                LoginScreen loginScreen = new LoginScreen();
               OrderCustomerFileManager.dowloadFromFile(); // 🔥 ESKİ KAYITLAR GELİR
                loginScreen.login();

            } else {
                System.out.println("invalid login");
                return;
            }


            Order sv = new Order();
            int orderType = scanner.nextInt();
            sv.order(orderType);

        } else if (number == 2) {
            System.out.println("You selected: Take orders.");
            OrderDepot depot = new OrderDepot();

            TakeOrder isTakingOrders = new TakeOrder(depot);

            isTakingOrders.ShowMenu();          // 👈 MENÜ BURADA
            int select = scanner.nextInt();
            isTakingOrders.takeOrder1(select);

        } else {
            System.out.println("Invalid login");
            return;
        }




    }
}
