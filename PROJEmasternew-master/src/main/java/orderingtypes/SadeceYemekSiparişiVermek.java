package orderingtypes;


public abstract class SadeceYemekSiparişiVermek {
    // normal yemek, vejeteryan yemek, vegan yemek
    //methodlar (yemek adı, kişi sayısı,  ister misiniz ve adı , tatlı ister misiniz ve adı)
    private String yemek;
    private int numberOfPeople;
    private boolean beveragePreference;
    private String drink;
    private boolean dessertPreference;
    private String dessert;

    public String getYemek(){
     return yemek;
    }
    public void setYemek(String yemek){
     this.yemek=yemek;
    }
    
    public int getNumberOfPeople(){
     return numberOfPeople;
    }
    public void setNumberOfPeople(int numberOfPeople){
     this.numberOfPeople = numberOfPeople;
    }
    
    public boolean getBeveragePreference(){
     return beveragePreference;
    }
    public void setBeveragePreference(boolean beveragePreference){
     this.beveragePreference = beveragePreference;
    }

    public String getDrink(){
        return drink;
    }
    public void setDrink(String drink){
        this.drink=drink;
    }

    public boolean getdessertPreference(){
        return dessertPreference;
    }
    public void setDessertPreference(boolean dessertPreference){
        this.dessertPreference=dessertPreference;
    }

    public String getDessert(){
        return dessert;
    }
    public void setDessert(String dessert){
        this.dessert=dessert;
    }


 public abstract void yemekadı();
     public abstract void kişisayisi();
     public abstract void icecektercihi();
     public abstract void tatlitercihi();
     public abstract void yemekDosyayaYaz();
     public abstract void kayit();

}
