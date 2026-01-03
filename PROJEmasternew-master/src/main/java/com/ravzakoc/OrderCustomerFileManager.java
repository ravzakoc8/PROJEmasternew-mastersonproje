package com.ravzakoc;

import java.io.*;

import static com.ravzakoc.OrderMemory.customer;

public class OrderCustomerFileManager {
    /*bu classımız içinde müşterilerin dosyadan okuma ve dosyaya yazma işlemlerini tutuyor */
    private static final String FİLE_PATH = "PROJEmasternew-master/src/main/java/com/ravzakoc/order";

    // 🔹 PROGRAM AÇILIRKEN ÇAĞRILACAK
    public static void dowloadFromFile() {
         customer.clear();


        try (BufferedReader br = new BufferedReader(new FileReader(FİLE_PATH))) {
            String row;

            while ((row = br.readLine()) != null) {
                String[] part = row.split(";");

                OrderRegistration sv = new OrderRegistration();
                sv.setEmail(part[0]);
                sv.setPassword(part[1]);
                sv.setTc(Long.parseLong(part[2]));
                sv.setaddress(part[3]);

                customer.add(sv);
            }
        } catch (IOException e) {
            // dosya yoksa sorun değil, ilk çalıştırma olabilir
        }
    }

    // 🔹 KAYIT OLUNCA ÇAĞRILACAK
    public static void saveToFile(OrderRegistration sv) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FİLE_PATH, true))) {

            bw.write(
                    sv.getEmail() + ";" +
                            sv.getPassword() + ";" +
                            sv.gettc() + ";" +
                            sv.getaddress()
            );
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Failed to write to the file!");
        }
    }
}
