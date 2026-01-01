package com.ravzakoc;

import java.util.Scanner;

public class OrganizasyonSirketiKayıt implements KayıtEkranı {

    Scanner scanner = new Scanner(System.in);

    private String sirketadi;
    private String sirketemail;
    private int calisansayisi;
    private String sirketadresi;
    private long vergiNumarası;
    private String password;

    public String getSirketadi(){
        return sirketadi;
    }

    public void setSirketadi(String sirketadi){
        this.sirketadi = sirketadi;   // burada direkt atadım
    }

    public String getSirketemail(){
        return sirketemail;
    }

    public void setSirketemail(String sirketemail){

        while(true){
            if(sirketemail.length() >= 3
                    && sirketemail.contains("@")
                    && sirketemail.contains(".")
                    && !sirketemail.matches("\\d+")){

                this.sirketemail = sirketemail;
                break;

            }else{
                System.out.println(" Geçersiz email! (en az 3 karakter, @ ve . içermeli)");
                System.out.print("Email giriniz: ");
                sirketemail = scanner.nextLine();
            }
        }
    }

    public int getCalisansayisi(){
        return calisansayisi;
    }

    public void setCalisansayisi(int calisansayisi){

        while(true){
            if(calisansayisi > 0){
                this.calisansayisi = calisansayisi;
                break;
            }
            else{
                System.out.println("Çalışan sayınız yetersiz");
                calisansayisi = scanner.nextInt();
            }
        }
    }

    public String getSirketadresi(){
        return sirketadresi;
    }

    public void setSirketadresi(String sirketadresi){
        this.sirketadresi = sirketadresi;
    }

    public long getVergiNumarası(){
        return vergiNumarası;
    }

    public void setVergiNumarası(long vergiNumarası){

        while(true){
            if(String.valueOf(vergiNumarası).length() == 10){
                this.vergiNumarası = vergiNumarası;
                break;
            }
            else{
                System.out.println("Geçersiz vergi numarası girdiniz.");
                System.out.print("Vergi numarası giriniz(10 karakter içermeli): ");
                vergiNumarası = scanner.nextLong();
            }
        }
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){

        while(true){
            if(password.length() >= 3 && !password.matches("\\d+")){
                this.password = password;
                break;
            }
            else{
                System.out.println("Geçersiz şifre! (En az 3 karakter, sadece sayı olamaz)");
                System.out.print("Şifre giriniz: ");
                password = scanner.nextLine();
            }
        }
    }

    public void kayitAl(){

        System.out.println("Şirket Adi:  ");
        setSirketadi(scanner.nextLine());

        System.out.print("Şirket Emailini giriniz: ");
        setSirketemail(scanner.nextLine());

        System.out.println("Şifreniz en az 3 karakterli olmalıdır");
        System.out.print("Şifre giriniz: ");
        setPassword(scanner.nextLine());

        System.out.println("Şirket adresini giriniz");
        setSirketadresi(scanner.nextLine());

        System.out.println("Şirketinizde çalışan kişi sayısını giriniz");
        setCalisansayisi(scanner.nextInt());

        System.out.println("Vergi numarası giriniz(10 karakter içermeli):");
        setVergiNumarası(scanner.nextLong());

        OrganizasyonSirketiMemory.sirket.add(this);

        OrganizasyonSirketiMemory.sirket.add(this);
        OrganizationCompanyFileManager.dosyayaKaydet(); // 💾 KAYDET

        System.out.println("Şirket kaydınız yapıldı.");
        System.out.println("Giriş Ekranına geçiş yapıldı");

        GirisEkrani.girisYap();


    }
}
