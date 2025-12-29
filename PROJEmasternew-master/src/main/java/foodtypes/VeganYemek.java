package foodtypes;

import com.ravzakoc.Session;
import orderingtypes.SadeceYemekSiparişiVermek;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VeganYemek extends SadeceYemekSiparişiVermek {
public VeganYemek(){

}
    public Scanner scanner =new Scanner(System.in);


    @Override
    public void yemekadı() {

        System.out.println("Lütfen yemek tercihi yapınız ( krep / hamburger  / sarma / makarna salatası / çorba ):");
        String yemek1 = scanner.nextLine().toLowerCase();
        while (true) {
            if (yemek1.equals("krep") || yemek1.equals(" hamburger ") ||
                    yemek1.equals("sarma") || yemek1.equals("makarna salatası") ||
                    yemek1.equals("çorba")) {

                setYemek(yemek1);
                System.out.println("Yemek seçiminiz kaydedildi.");
                break;

            } else {
                System.out.println("Yanlış yemek seçimi. Tekrar giriniz:");
                yemek1 = scanner.nextLine().toLowerCase();
            }
        }
    }

    @Override
    public void kişisayisi() {

        while (true) {
            try {
                System.out.print("Kişi sayısını giriniz: ");
                int kisisayisi1 = scanner.nextInt();

                if (kisisayisi1 < 0) {
                    System.out.println("Kişi sayısı negatif olamaz. Tekrar giriniz.");
                    continue; // döngünün başına dön
                }
                setNumberOfPeople(kisisayisi1);
                break; // ✅ doğru giriş → döngüden çık

            } catch (Exception e) {
                System.out.println("Sayı dışında bir şey girdiniz. Tekrar deneyiniz.");
                scanner.nextLine(); // ❗ hatalı input'u temizle
            }


        }

    }

    @Override
    public void icecektercihi() {

        while (true) {
            try {
                System.out.println("İçecek istiyor musunuz? true / false giriniz:");
                boolean BeveragePreference = scanner.nextBoolean();
                setBeveragePreference(BeveragePreference);
                scanner.nextLine(); // ⭐ TEMİZLEME

                if (BeveragePreference) {
                    while (true) {
                        System.out.println("İçecek seçiniz (kola / fanta / meyve suyu / gazoz / limonata)");
                        String drink1 = scanner.nextLine().toLowerCase();

                        if (drink1.equals("kola") || drink1.equals("fanta") ||
                                drink1.equals("meyve suyu") || drink1.equals("gazoz") ||
                                drink1.equals("limonata")) {
                            setDrink(drink1);   // ✅ burada olmalı
                            System.out.println("İçecek seçiminiz kaydedildi.");
                            break;
                            // drink1 döngüsünden çık
                        } else {
                            System.out.println("Geçersiz drink1! Tekrar deneyiniz.");
                        }

                    }
                } else {
                    System.out.println("İçecek tercihiniz: istemiyorum olarak kaydedildi.");
                }

                break; // ANA while'dan çık

            } catch (Exception e) {
                System.out.println("Lütfen sadece true veya false giriniz!");
                scanner.nextLine(); // hatalı girişi temizle
            }
        }
    }


    @Override
    public void tatlitercihi() {

        while (true) {
            try {
                System.out.println(" Tatlı istiyor musunuz? true / false giriniz:");
                boolean dessertPreference = scanner.nextBoolean();
                setDessertPreference(dessertPreference);
                scanner.nextLine(); // ⭐ TEMİZLEME

                if (dessertPreference) {
                    while (true) {
                        System.out.println("Tatlı seçiniz ( cheesecake / cake / tiramisu / parfe )");
                        String dessert1 = scanner.nextLine().toLowerCase();
                        if (dessert1.equals("cheesecake") || dessert1.equals("cake") ||
                                dessert1.equals("tiramisu") || dessert1.equals("parfe")) {

                            setDessert(dessert1);
                            System.out.println("Tatlı seçiminiz kaydedildi.");
                            break;
                        } else {
                            System.out.println("Geçersiz tatlı! Tekrar deneyiniz.");
                        }

                    }
                } else {
                    System.out.println("Tatli tercihiniz: istemiyorum olarak kaydedildi.");
                }

                break; // ANA while'dan çık

            } catch (Exception e) {
                System.out.println("Lütfen sadece true veya false giriniz!");
                scanner.nextLine(); // hatalı girişi temizle
            }
        }

    }
    public void kayit(){
        System.out.println("Tercihler alındı dosyaya yazılıyor");
        yemekDosyayaYaz();
    }
    public void yemekDosyayaYaz() {

        System.out.println(">>> yemekDosyayaYaz METODUNA GİRİLDİ <<<");
        try {
            FileWriter fw = new FileWriter("C:/Users/Public/yemek_siparisleri.txt", true);
            fw.write(
                    " Email: " + Session.aktifEmail  +
                    " Vegan Yemek | " +
                            "Yemek: " + getYemek() +
                            " | Kisi Sayisi: " + getNumberOfPeople() +
                            " | Icecek: " + (getBeveragePreference() ? getDrink() : "Yok") +
                            " | Tatli: " + (getdessertPreference() ? getDessert() : "Yok") + "\n"
            );

            fw.close();
            System.out.println("Yemek siparisi dosyaya kaydedildi.");


        } catch (IOException e) {
            System.out.println("Yemek dosyasina yazma hatasi."+e.getMessage());
        }



    }

}
