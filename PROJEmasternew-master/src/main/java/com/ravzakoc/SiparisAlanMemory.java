package com.ravzakoc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SiparisAlanMemory {

    public static List<SiparisAlanKayıt> organizasyonlar = new ArrayList<>();

    private static final String DOSYA_YOLU = "siparis_alanlar.txt";

    // 📥 DOSYADAN OKUMA
    public static void dosyadanYukle() {
        organizasyonlar.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(DOSYA_YOLU))) {

            String satir;
            while ((satir = br.readLine()) != null) {

                String[] parcalar = satir.split(";");

                if (parcalar.length == 4) {
                    SiparisAlanKayıt sa = new SiparisAlanKayıt();

                    sa.setEmail(parcalar[0]);
                    sa.setPassword(parcalar[1]);
                    sa.setTc(parcalar[2]);
                    sa.setaddress(parcalar[3]);

                    organizasyonlar.add(sa);
                }
            }

        } catch (FileNotFoundException e) {
            // İlk çalıştırmada dosya yoksa sorun değil
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası!");
        }
    }

    // 💾 DOSYAYA YAZMA
    public static void dosyayaKaydet() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DOSYA_YOLU))) {

            for (SiparisAlanKayıt sa : organizasyonlar) {
                bw.write(
                        sa.getEmail() + ";" +
                                sa.getPassword() + ";" +
                                sa.gettc() + ";" +
                                sa.getaddress()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Dosya yazma hatası!");
        }
    }
}
