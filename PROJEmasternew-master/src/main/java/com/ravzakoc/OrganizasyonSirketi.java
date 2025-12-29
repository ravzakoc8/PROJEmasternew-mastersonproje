package com.ravzakoc;

import foodtypes.siparisAlmak;
import orderingtypes.SiparisDeposu;

import java.util.Scanner;

public class OrganizasyonSirketi extends siparisAlmak {

    Scanner scanner= new Scanner(System.in);
    String sirketadi;
    String sirketemail;
    int çalisansayisi;
    String şirketadresi;
    double vergiNumarası;

    public OrganizasyonSirketi(SiparisDeposu depo) {
        super(depo); // <-- parent constructor’ı çağır
        System.out.println("Organizasyon şirketinizi programa kayıt ediniz aksi halde sipariş kabul edemezsiniz.");
    }

    public void sirketBilgileri(){
      sirketadi=scanner.nextLine();
      sirketemail= scanner.nextLine();
      çalisansayisi= scanner.nextInt();
      şirketadresi = scanner.nextLine();
      vergiNumarası= scanner.nextDouble();



    }
    public void çıktı(){
        System.out.println("Şirket kaydınız yapıldı.");
        System.out.println();
    }
}
