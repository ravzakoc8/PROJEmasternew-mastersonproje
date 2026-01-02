package foodtypes;

import com.ravzakoc.*;
import orderingtypes.SiparisDeposu;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class siparisAlmak {
     Scanner scanner =new Scanner(System.in);
    SiparisDeposu depo; // Depoya erişim şart

    public siparisAlmak(SiparisDeposu gelenDepo) {
        this.depo = gelenDepo;
    }


    public void menuGoster() {
        System.out.println("Sipariş almak istediğiniz türü seçiniz.");
        System.out.println("1- Organizasyon siparişlerini kabul etmek istiyorum");
        System.out.println("2- Yemek siparişlerini kabul etmek istiyorum");
        System.out.println("3- Yemek ve organizasyon siparişlerini kabul etmek istiyorum");
    }
    public void siparisAlmak1(int siparistürü) {

        if (siparistürü == 1) {
            System.out.println("Bu siparişi kabul etmek için organizasyon şirketiniz olması gerekiyor");
            System.out.println("Eğer şirketiniz varsa kayıt yaptırın kayıtlı iseniz giriş yapın lütfen.");
            System.out.println("1-Giriş ekranı");
            System.out.println("2-Kayıt ekranı");
            int ekranseçimi = scanner.nextInt();
            if (ekranseçimi == 1) {

                OrganizationCompanyFileManager.dosyadanYukle(); // ⭐ BUNU EKLE
                GirisEkrani.girisYap();


                List<String> satirlar = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/organizasyon_siparisleri.txt"))) {



                    String satir;
                    while ((satir = br.readLine()) != null) {
                        System.out.println(satir);
                        satirlar.add(satir); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("Dosya okunamadı: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Silmek istediğiniz siparişin emailini girin: ");
                String silinecekEmail = scanner.nextLine();
                List<String> kalanlar = new ArrayList<>();

                for (String s : satirlar) {
                    if (!s.contains("Email: " + silinecekEmail)) {
                        kalanlar.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/organizasyon_siparisleri.txt", false)) {
                    for (String s : kalanlar) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Seçilen email'e ait sipariş silindi.");
                } catch (IOException e) {
                    System.out.println("Dosya yazma hatası: " + e.getMessage());
                }



            } else if (ekranseçimi == 2) {
                OrganizasyonSirketiKayıt organizasyonSirketiKayıt = new OrganizasyonSirketiKayıt();
                organizasyonSirketiKayıt.kayitAl();


                List<String> satirlar = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/organizasyon_siparisleri.txt"))) {



                    String satir;
                    while ((satir = br.readLine()) != null) {
                        System.out.println(satir);
                        satirlar.add(satir); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("Dosya okunamadı: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Silmek istediğiniz siparişin emailini girin: ");
                String silinecekEmail = scanner.nextLine();
                List<String> kalanlar = new ArrayList<>();

                for (String s : satirlar) {
                    if (!s.contains("Email: " + silinecekEmail)) {
                        kalanlar.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/organizasyon_siparisleri.txt", false)) {
                    for (String s : kalanlar) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Seçilen email'e ait sipariş silindi.");
                } catch (IOException e) {
                    System.out.println("Dosya yazma hatası: " + e.getMessage());
                }


            } else {
                System.out.println("Yanlış seçim yaptınız");
            }


        } else if (siparistürü == 2) {
            System.out.println("Lütfen sipariş kabul etmek için giriş yapın kaydınız yoksa kayıt olun");
            System.out.println("1-Kayıt Ekranı");
            System.out.println("2-Giriş ekranı");
            int ekranseçimi1 = scanner.nextInt();

            if (ekranseçimi1 == 1) {
                SiparisAlanKayıt siparisAlanKayıt = new SiparisAlanKayıt();
                siparisAlanKayıt.kayitAl();
                List<String> satirlar = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/yemek_siparisleri.txt"))) {



                    String satir;
                    while ((satir = br.readLine()) != null) {
                        System.out.println(satir);
                        satirlar.add(satir); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("Dosya okunamadı: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Silmek istediğiniz siparişin emailini girin: ");
                String silinecekEmail = scanner.nextLine();
                List<String> kalanlar = new ArrayList<>();

                for (String s : satirlar) {
                    if (!s.contains("Email: " + silinecekEmail)) {
                        kalanlar.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/yemek_siparisleri.txt", false)) {
                    for (String s : kalanlar) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Seçilen email'e ait sipariş silindi.");
                } catch (IOException e) {
                    System.out.println("Dosya yazma hatası: " + e.getMessage());
                }

            } else if (ekranseçimi1 == 2) {
                OrderProviderFileManager.dosyadanYukle(); // 📥 YÜKLE
                GirisEkrani.girisYap();

                List<String> satirlar = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/yemek_siparisleri.txt"))) {



                    String satir;
                    while ((satir = br.readLine()) != null) {
                        System.out.println(satir);
                        satirlar.add(satir); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("Dosya okunamadı: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Silmek istediğiniz siparişin emailini girin: ");
                String silinecekEmail = scanner.nextLine();
                List<String> kalanlar = new ArrayList<>();

                for (String s : satirlar) {
                    if (!s.contains("Email: " + silinecekEmail)) {
                        kalanlar.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/yemek_siparisleri.txt", false)) {
                    for (String s : kalanlar) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Seçilen email'e ait sipariş silindi.");
                } catch (IOException e) {
                    System.out.println("Dosya yazma hatası: " + e.getMessage());
                }


            } else {
            System.out.println("Yanlış giriş yaptınız");
        }

    }else if (siparistürü==3) {
            System.out.println("Bu siparişi kabul etmek için organizasyon şirketiniz olması gerekiyor");
            System.out.println("Eğer şirketiniz varsa kayıt yaptırın kayıtlı iseniz giriş yapın lütfen.");
            System.out.println("1-Giriş ekranı");
            System.out.println("2-Kayıt ekranı");
            int ekranseçimi= scanner.nextInt();

            if(ekranseçimi==1){
                GirisEkrani girisEkrani= new GirisEkrani();
                girisEkrani.girisYap();
                List<String> satirlar = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/yemekveorg_siparişleri"))) {



                    String satir;
                    while ((satir = br.readLine()) != null) {
                        System.out.println(satir);
                        satirlar.add(satir); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("Dosya okunamadı: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Silmek istediğiniz siparişin emailini girin: ");
                String silinecekEmail = scanner.nextLine();
                List<String> kalanlar = new ArrayList<>();

                for (String s : satirlar) {
                    if (!s.contains("Email: " + silinecekEmail)) {
                        kalanlar.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/yemekveorg_siparişleri", false)) {
                    for (String s : kalanlar) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Seçilen email'e ait sipariş silindi.");
                } catch (IOException e) {
                    System.out.println("Dosya yazma hatası: " + e.getMessage());
                }


            }
            else if(ekranseçimi==2){
                OrganizasyonSirketiKayıt organizasyonSirketiKayıt= new OrganizasyonSirketiKayıt();
                organizasyonSirketiKayıt.kayitAl();
                List<String> satirlar = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("PROJEmasternew-master/src/main/java/com/ravzakoc/yemekveorg_siparişleri"))) {



                    String satir;
                    while ((satir = br.readLine()) != null) {
                        System.out.println(satir);
                        satirlar.add(satir); // ⭐ BURASI ÖNEMLİ
                    }

                } catch (IOException e) {
                    System.out.println("Dosya okunamadı: " + e.getMessage());
                }
                scanner.nextLine(); // buffer temizle
                System.out.print("Silmek istediğiniz siparişin emailini girin: ");
                String silinecekEmail = scanner.nextLine();
                List<String> kalanlar = new ArrayList<>();

                for (String s : satirlar) {
                    if (!s.contains("Email: " + silinecekEmail)) {
                        kalanlar.add(s);
                    }
                }
                try (FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/yemekveorg_siparişleri", false)) {
                    for (String s : kalanlar) {
                        fw.write(s + "\n");
                    }
                    System.out.println("Seçilen email'e ait sipariş silindi.");
                } catch (IOException e) {
                    System.out.println("Dosya yazma hatası: " + e.getMessage());
                }


            }
            else{
                System.out.println("Yanlış seçim yaptınız");
            }

        }
        else {
            System.out.println("Yanlış giriş yaptınız.");
        }
    }

}

