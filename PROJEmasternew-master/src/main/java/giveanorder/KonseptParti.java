package giveanorder;

import com.ravzakoc.Session;
import orderingtypes.SadeceOrganizasyonSiparişiVermek;

import java.io.FileWriter;
import java.io.IOException;

public class KonseptParti extends SadeceOrganizasyonSiparişiVermek {
    public KonseptParti(){
    }


    @Override
    public void aksesuarlar() {

        System.out.println("Lütfen adınızı giriniz.");
        setName(scanner.nextLine());

        while (true) {
            System.out.println("Lütfen colour tercihi yapınız (kırmızı / mavi / siyah / beyaz / pembe):");
            String colour1  = scanner.nextLine().toLowerCase();

            if (colour1.equals("kırmızı") || colour1.equals("mavi") ||
                    colour1.equals("siyah") || colour1.equals("beyaz") ||
                    colour1.equals("pembe")) {

                setColour(colour1);
                break; // ✅ doğru colour → döngüden çık
            } else {
                System.out.println("Yanlış colour girdiniz! Lütfen tekrar deneyiniz.");
            }
        }
    }

    @Override
    public void numberOfPeople() {

        while (true) {
            try {
                System.out.print("Kişi sayısını giriniz: ");
                int numberofpeople1 = scanner.nextInt();

                if (numberofpeople1 < 0) {
                    System.out.println("Kişi sayısı negatif olamaz. Tekrar giriniz.");
                    continue; // döngünün başına dön
                }
                setNumberOfPeople(numberofpeople1);

                break; // ✅ doğru giriş → döngüden çık

            } catch (Exception e) {
                System.out.println("Sayı dışında bir şey girdiniz. Tekrar deneyiniz.");
                scanner.nextLine(); // ❗ hatalı input'u temizle
            }
        }
    }

    @Override
    public void waiterPreference() {

        while (true) {
            System.out.println("Garson istiyor musunuz? (evet / hayır)");
            boolean waiterPreference1 =scanner.nextBoolean();
            setName(scanner.nextLine());

            if (waiterPreference1) {


                while (true) {
                    System.out.print("Garson sayısını belirtiniz: ");
                    try {
                        int numberOfWaiters1 = Integer.parseInt(scanner.nextLine());

                        if (numberOfWaiters1 <= 0) {
                            System.out.println("Garson sayısı 0 veya negatif olamaz.");
                            continue;
                        }

                        System.out.println("Garson sayınız " + numberOfWaiters1 + " olarak karar verilmiştir");
                        setNumberOfWaiters(numberOfWaiters1);
                        break; // iç döngüden çık
                    } catch (NumberFormatException e) {
                        System.out.println("Lütfen geçerli bir sayı giriniz.");
                    }
                }
                setWaiterPreference(waiterPreference1);
                break; // ana döngüden çık
            }

            else if (waiterPreference1 == false) {
                System.out.println("Garson tercih etmediniz.");
                setWaiterPreference(waiterPreference1);
                break; // ana döngüden çık
            }

            else {
                System.out.println("Hatalı giriş! Lütfen sadece 'evet' veya 'hayır' yazınız.");
                setWaiterPreference(waiterPreference1);
            }
        }
    }
    @Override
    public void dj() {

        while (true) {
            System.out.println("DJ istiyor musunuz? (evet / hayır)");
            boolean dj1=scanner.nextBoolean();


            if ( dj1 == true) {

                System.out.println("DJ isteğiniz kaydedilmiştir.");
                setDj(dj1);
                break;
            }
            else if (dj1==false) {
                System.out.println("DJ istemediğiniz kaydedilmiştir.");
                setDj(dj1);
                break;
            }
            else {
                System.out.println("Hatalı giriş! Lütfen sadece 'evet' veya 'hayır' yazınız.");
                setDj(dj1);
            }
        }
    }
    @Override
    public void tercihler() {

        System.out.println("Tercihleriniz aşağıdaki gibidir:");

        System.out.println("Aksesuar rengi: " + getColour());
        System.out.println("Gelecek misafir sayısı: " + getNumberOfPeople());

        if (getWaiterPreference()
        ) {
            System.out.println("Garson istendi. Garson sayısı: " + getNumberOfWaiters());
        } else {
            System.out.println("Garson istenmedi.");
        }

        if (getdj()) {
            System.out.println("DJ istendi.");
        } else {
            System.out.println("DJ istenmedi.");
        }


    }
    public void kayit(){
        dosyayaYaz();
        System.out.println("Tercihleriniz alındı, sipariş için size dönüş yapacağız.");}



    public void dosyayaYaz() {
        try {
            FileWriter fw = new FileWriter("PROJEmasternew-master/src/main/java/com/ravzakoc/organizasyon_siparisleri.txt", true);

            fw.write(" Email: " + Session.aktifEmail  +
                    "Dogum Gunu | Renk: " + getColour() +
                            " | Kisi Sayisi: " + getNumberOfPeople() +
                            " | Garson: " + (getWaiterPreference()
                            ? "Var (" + getNumberOfWaiters() + ")" : "Yok") +
                            " | DJ: " + (getdj() ? "Var" : "Yok") +" | " + "\n"
            );

            fw.close();


        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatasi "+ e.getMessage());
        }
        System.exit(0);
    }



}