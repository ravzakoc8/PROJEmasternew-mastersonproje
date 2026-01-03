package foodtypes;

import com.ravzakoc.*;
import orderingtypes.OrderDepot;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TakeOrder {
     Scanner scanner =new Scanner(System.in);
    OrderDepot depot; // Depoya erişim şart

    public TakeOrder(OrderDepot ComingDepot) {
        this.depot = ComingDepot;
    }


    public void ShowMenu() {
        System.out.println("Choose the type you want to take order from.");
        System.out.println("1- I want to take orders for organisation");
        System.out.println("2- I want to take food orders");
        System.out.println("3- I want to take orders of organisations and food orders.");
    }
    public void takeOrder1(int orderType) {

        if (orderType == 1) {
            System.out.println("You need to have an organisation for taking this order.");
            System.out.println("If you have an organisation,please login if not please register it.");
            System.out.println("1-Login screen");
            System.out.println("2-Registration screen");
            int screenChoice = scanner.nextInt();
            if (screenChoice == 1) {

                OrganisationCompanyFileManager.dowloadFromFile(); // ⭐ BUNU EKLE
                LoginScreen.login();


                List<String> rows = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/order_organisations.txt"))) {



                    String row;
                    while ((row = br.readLine()) != null) {
                        System.out.println(row);
                        rows.add(row); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("File is unreadable: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Please write the email you want to erase your order from: ");
                String emailToErase = scanner.nextLine();
                List<String> remainingOnes = new ArrayList<>();

                for (String s : rows) {
                    if (!s.contains("Email: " + emailToErase)) {
                        remainingOnes.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/order_organisations.txt", false)) {
                    for (String s : remainingOnes) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Your order from the written email is been erased.");
                } catch (IOException e) {
                    System.out.println("File writing error: " + e.getMessage());
                }



            } else if (screenChoice == 2) {
                OrganisationCompanyRegister organisationCompanyRegister = new OrganisationCompanyRegister();
                organisationCompanyRegister.register();


                List<String> rows = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/order_organisations.txt"))) {



                    String row;
                    while ((row = br.readLine()) != null) {
                        System.out.println(row);
                        rows.add(row); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("File is unreadable: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Please write the email you want to erase your order from: ");
                String emailToErase = scanner.nextLine();
                List<String> remainingOnes = new ArrayList<>();

                for (String s : rows) {
                    if (!s.contains("Email: " + emailToErase)) {
                        remainingOnes.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/order_organisations.txt", false)) {
                    for (String s : remainingOnes) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Your order from the written email is been erased");
                } catch (IOException e) {
                    System.out.println("File writing error: " + e.getMessage());
                }


            } else {
                System.out.println("Invalid selection.");
            }


        } else if (orderType == 2) {
            System.out.println("Please log in to accept orders. If you do not have an account, please register.");
            System.out.println("1- Register Screen");
            System.out.println("2- Login Screen");
            int selectscreen = scanner.nextInt();

            if (selectscreen == 1) {
                TakeOrderRegister takeOrderRegister = new TakeOrderRegister();

                takeOrderRegister.register();

                List<String> rows = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/order_food.txt"))) {



                    String row;
                    while ((row = br.readLine()) != null) {
                        System.out.println(row);
                        rows.add(row); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("File is unreadable: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Please write the email you want to erase your order from: ");
                String emailToErase = scanner.nextLine();
                List<String> remainingOnes = new ArrayList<>();

                for (String s : rows) {
                    if (!s.contains("Email: " + emailToErase)) {
                        remainingOnes.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/order_food.txt", false)) {
                    for (String s : remainingOnes) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Your order from the written email is been erased.");
                } catch (IOException e) {
                    System.out.println("File writing error: " + e.getMessage());
                }



            } else if (selectscreen == 2) {
                OrderProviderFileManager.dowloadFromFile(); // 📥 YÜKLE
                LoginScreen.login();

                List<String> rows = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/order_food.txt"))) {



                    String row;
                    while ((row = br.readLine()) != null) {
                        System.out.println(row);
                        rows.add(row); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("File is unreadable: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Please write the email you want to erase your order from: ");
                String emailToErase = scanner.nextLine();
                List<String> remainingOnes = new ArrayList<>();

                for (String s : rows) {
                    if (!s.contains("Email: " + emailToErase)) {
                        remainingOnes.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/order_food.txt", false)) {
                    for (String s : remainingOnes) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Your order from the written email is been erased.");
                } catch (IOException e) {
                    System.out.println("File writing error: " + e.getMessage());
                }


            } else {
            System.out.println("Invalid selection.”");
        }

    }else if (orderType==3) {
            System.out.println("You need to have an organisation for taking this order.");
            System.out.println("If you have an organisation,please login if not please register it.");
            System.out.println("1- Login Screen");
            System.out.println("2- Register Screen");
            int selectscreen= scanner.nextInt();

            if(selectscreen==1){
                LoginScreen loginScreen= new LoginScreen();
                loginScreen.login();
                List<String> rows = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/order_foodAndOrganisation"))) {



                    String row;
                    while ((row = br.readLine()) != null) {
                        System.out.println(row);
                        rows.add(row); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("File is unreadable: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Please write the email you want to erase your order from: ");
                String emailToErase = scanner.nextLine();
                List<String> remainingOnes = new ArrayList<>();

                for (String s : rows) {
                    if (!s.contains("Email: " + emailToErase)) {
                        remainingOnes.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/order_foodAndOrganisation", false)) {
                    for (String s : remainingOnes) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Your order from the written email is been erased.");
                } catch (IOException e) {
                    System.out.println("File writing error: " + e.getMessage());
                }


            }
            else if(selectscreen==2){
                OrganisationCompanyRegister organisationCompanyRegister= new OrganisationCompanyRegister();
                organisationCompanyRegister.register();
                List<String> rows = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/order_foodAndOrganisation"))) {



                    String row;
                    while ((row = br.readLine()) != null) {
                        System.out.println(row);
                        rows.add(row); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("File is unreadable: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Please write the email you want to erase your order from: ");
                String emailToErase = scanner.nextLine();
                List<String> remainingOnes = new ArrayList<>();

                for (String s : rows) {
                    if (!s.contains("Email: " + emailToErase)) {
                        remainingOnes.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/order_foodAndOrganisation", false)) {
                    for (String s : remainingOnes) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Your order from the written email is been erased.");
                } catch (IOException e) {
                    System.out.println("File writing error: " + e.getMessage());
                }


            }
            else{
                System.out.println("Invalid selection.”");
            }

        }
        else {
            System.out.println("Invalid login.");
        }
    }

}

