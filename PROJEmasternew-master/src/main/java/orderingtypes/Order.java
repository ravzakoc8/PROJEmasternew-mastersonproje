package orderingtypes;

import foodtypes.NormalFood;
import foodtypes.VeganFood;
import foodtypes.VegetarianFood;
import giveanorder.Birthday;
import giveanorder.ConceptParty;
import giveanorder.Kina;
import giveanorder.Wedding;

import java.util.Scanner;


public class Order {
    //Polimorfizmi burda kullandık sadece

    Scanner scanner= new Scanner(System.in);
    OrderDepot depot;

    public Order(){
        System.out.println("Enter your order type.");
        System.out.println("1- I want to order organisation ");
        System.out.println("2- I want to order food ");
        System.out.println("3- I want to order food and organisation ");
    }
    public void order(int orderType){ //overloading

        if (orderType ==1){
            scanner.nextLine();
            System.out.println("Your choice is been made as wanting an organisation.");

            System.out.println("Vermek istediğiniz organisation türünü seçiniz.");
            System.out.println("1- Birthday");
            System.out.println("2- Concept Party");
            System.out.println("3- Wedding");
            System.out.println("4-Kina");

            int orgType = scanner.nextInt();

            // ADIM 1: Polimorfik Referansı Oluştur (Henüz boş)
            OrderOrganisation organisation = null;

            // ADIM 2: Sadece "new" işlemi yap (Kutuyu doldur)
            if (orgType == 1) {
                organisation = new Birthday();
            } else if (orgType == 2) {
                organisation = new ConceptParty();
            } else if (orgType == 3) {
                organisation = new Wedding();
            } else if (orgType == 4) {
                organisation = new Kina();
            } else {
                System.out.println("Invalid organisation choice.");
                return;
            }

            // ADIM 3: Metotları sadece BURADA çağır (Kod tekrarı bitti!)
            // Java, 'organisation' değişkeninin içinde hangi obje varsa (Kına mı, Doğumgünü mü) onu çalıştırır.
            organisation.accessories();
            organisation.numberOfPeople();
            organisation.waiterPreference();
            organisation.dj();
            organisation.choices();
            organisation.registration();
        }

        else if (orderType == 2) {
            System.out.println("Order food type: 1-Normal, 2-Vegetarian, 3-Vegan");
            int foodType = scanner.nextInt();

            // ADIM 1: Polimorfik Referans (Boş kutu)
            OrderingFood food = null;

            // ADIM 2: Kutuyu doldur
            if (foodType == 1) {
                food = new NormalFood();
            } else if (foodType == 2) {
                food = new VegetarianFood();
            } else if (foodType == 3) {
                food = new VeganFood();
            } else {
                System.out.println("Invalid food choice.");
                return;
            }

            // ADIM 3: Metotları tek seferde çalıştır
            food.foodName();
            food.numberOfPeople();
            food.beverageChoice();
            food.dessertChoice();
            food.registration();
        }
        else if (orderType == 3) {
            OrderDepot depot = new OrderDepot();
            orderingMealAndOrganisation order =
                    new orderingMealAndOrganisation(depot);

            order.order();
            order.register();

        }

        else {
            System.out.println("Invalid main course choice.");
        }



    }
}