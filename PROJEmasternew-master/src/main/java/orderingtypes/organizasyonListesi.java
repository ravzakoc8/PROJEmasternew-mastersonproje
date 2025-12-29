package orderingtypes;

import java.util.ArrayList;
import java.util.List;

public class organizasyonListesi {
    protected List<SadeceOrganizasyonSiparişiVermek> organizasyonListesi;
    protected List<String> yemekListesi;
    protected List<orderingMealAndOrganisation> yemekveorgSiparisi;


    public void organizasyonEkle(SadeceOrganizasyonSiparişiVermek siparis) {
        organizasyonListesi.add(siparis);
    }

    public List<SadeceOrganizasyonSiparişiVermek> getOrganizasyonListesi() {
        return organizasyonListesi;
    }


    public void yemekEkle(String yemekSiparisi) {
        yemekListesi.add(yemekSiparisi);
    }

    public List<String> getYemekListesi() {
        return yemekListesi;
    }

    public void yemekveorg(orderingMealAndOrganisation sipariş){
        yemekveorgSiparisi.add(sipariş);

    }

    public List< orderingMealAndOrganisation> getYemekveorgSiparisi(){
        return  yemekveorgSiparisi;
    }

}

