package com.ravzakoc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SiparisVerenMemory {

    public static List<SiparisVerenKayıt> musteriler = new ArrayList<>();
    private static final String DOSYA_ADI = "siparis_verenler.txt";

    // 🔹 PROGRAM AÇILIRKEN ÇAĞRILACAK
    public static void dosyadanYukle() {
        musteriler.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(DOSYA_ADI))) {
            String satir;

            while ((satir = br.readLine()) != null) {
                String[] parca = satir.split(";");

                SiparisVerenKayıt sv = new SiparisVerenKayıt();
                sv.setEmail(parca[0]);
                sv.setPassword(parca[1]);
                sv.setTc(Long.parseLong(parca[2]));
                sv.setaddress(parca[3]);

                musteriler.add(sv);
            }
        } catch (IOException e) {
            // dosya yoksa sorun değil, ilk çalıştırma olabilir
        }
    }

    // 🔹 KAYIT OLUNCA ÇAĞRILACAK
    public static void dosyayaKaydet(SiparisVerenKayıt sv) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DOSYA_ADI, true))) {

            bw.write(
                    sv.getEmail() + ";" +
                            sv.getPassword() + ";" +
                            sv.gettc() + ";" +
                            sv.getaddress()
            );
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Dosyaya yazılamadı!");
        }
    }
}
