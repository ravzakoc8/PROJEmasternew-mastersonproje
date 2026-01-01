package foodtypes;

import com.ravzakoc.*;
import orderingtypes.SiparisDeposu;


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
    public void siparisAlmak1(int siparistürü){

        if (siparistürü==1){
            System.out.println("Bu siparişi kabul etmek için organizasyon şirketiniz olması gerekiyor");
            System.out.println("Eğer şirketiniz varsa kayıt yaptırın kayıtlı iseniz giriş yapın lütfen.");
            System.out.println("1-Giriş ekranı");
            System.out.println("2-Kayıt ekranı");
            int ekranseçimi= scanner.nextInt();
            if(ekranseçimi==1){

                   OrganizationCompanyFileManager.dosyadanYukle(); // ⭐ BUNU EKLE
                    GirisEkrani.girisYap();


                // ---> BURAYA EKLİYORSUN <---
                System.out.println("Giriş Başarılı. Siparişler yükleniyor...");
                depo.organizasyonlariListele();
                // ---------------------------

            }
             else if(ekranseçimi==2){
                OrganizasyonSirketiKayıt organizasyonSirketiKayıt= new OrganizasyonSirketiKayıt();
                organizasyonSirketiKayıt.kayitAl();


                // ---> BURAYA EKLİYORSUN <---
                System.out.println("Giriş Başarılı. Siparişler yükleniyor...");
                depo.organizasyonlariListele();
                // ---------------------------

             }
            else{
                System.out.println("Yanlış seçim yaptınız");
            }


        } else if (siparistürü==2) {
            System.out.println("Lütfen sipariş kabul etmek için giriş yapın kaydınız yoksa kayıt olun");
            System.out.println("1-Kayıt Ekranı");
            System.out.println("2-Giriş ekranı");
            int ekranseçimi1=scanner.nextInt();

            if (ekranseçimi1==1){
            SiparisVerenKayıt siparisVerenKayıt= new SiparisVerenKayıt();
            siparisVerenKayıt.kayitAl();}

            else if (ekranseçimi1==2) {
                OrderProviderFileManager.dosyadanYukle(); // 📥 YÜKLE
                GirisEkrani.girisYap();


                // ---> BURAYA EKLİYORSUN <---
                System.out.println("Giriş Başarılı. Yemekler yükleniyor...");
                depo.yemekleriListele();
                // ---------------------------
            }
            else{
                System.out.println("Yanlış giriş yaptınız");
            }

        } else if (siparistürü==3) {
            System.out.println("Bu siparişi kabul etmek için organizasyon şirketiniz olması gerekiyor");
            System.out.println("Eğer şirketiniz varsa kayıt yaptırın kayıtlı iseniz giriş yapın lütfen.");
            System.out.println("1-Giriş ekranı");
            System.out.println("2-Kayıt ekranı");
            int ekranseçimi= scanner.nextInt();

            if(ekranseçimi==1){
                GirisEkrani girisEkrani= new GirisEkrani();
                girisEkrani.girisYap();

            }
            else if(ekranseçimi==2){
                OrganizasyonSirketiKayıt organizasyonSirketiKayıt= new OrganizasyonSirketiKayıt();
                organizasyonSirketiKayıt.kayitAl();

                System.out.println("Giriş Başarılı. Tüm siparişler yükleniyor...");

                depo.organizasyonlariListele(); // Önce organizasyonları dök
                depo.yemekleriListele();        // Altına yemekleri dök
                // ----------------------

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
