package com.ravzakoc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizasyonSirketiMemory {

    public static List<OrganizasyonSirketiKayıt> sirket = new ArrayList<>();

    private static final String DOSYA_YOLU = "organizasyon_sirketleri.txt";

    // 📥 DOSYADAN OKUMA
    public static void dosyadanYukle() {
        sirket.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(DOSYA_YOLU))) {

            String satir;
            while ((satir = br.readLine()) != null) {

                String[] p = satir.split(";");

                if (p.length == 6) {
                    OrganizasyonSirketiKayıt os = new OrganizasyonSirketiKayıt();

                    os.setSirketadi(p[0]);
                    os.setSirketemail(p[1]);
                    os.setPassword(p[2]);
                    os.setSirketadresi(p[3]);
                    os.setCalisansayisi(Integer.parseInt(p[4]));
                    os.setVergiNumarası(Long.parseLong(p[5]));

                    sirket.add(os);
                }
            }

        } catch (FileNotFoundException e) {
            // İlk çalıştırmada dosya yoksa sorun değil
        } catch (IOException e) {
            System.out.println("Organizasyon şirketi dosya okuma hatası!");
        }
    }

    // 💾 DOSYAYA YAZMA
    public static void dosyayaKaydet() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DOSYA_YOLU))) {

            for (OrganizasyonSirketiKayıt os : sirket) {
                bw.write(
                        os.getSirketadi() + ";" +
                                os.getSirketemail() + ";" +
                                os.getPassword() + ";" +
                                os.getSirketadresi() + ";" +
                                os.getCalisansayisi() + ";" +
                                os.getVergiNumarası()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Organizasyon şirketi dosya yazma hatası!");
        }
    }
}
