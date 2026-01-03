package orderingtypes;

import com.ravzakoc.Session;
import foodtypes.NormalFood;
import foodtypes.VeganFood;
import foodtypes.VegetarianFood;
import giveanorder.Birthday;
import giveanorder.ConceptParty;
import giveanorder.Kina;
import giveanorder.Wedding;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class orderingMealAndOrganisation {
Scanner scanner = new Scanner(System.in);
    private OrderDepot depot;

    private OrderOrganisation selectedOrganization;
    private OrderingFood selectedFood;

    public orderingMealAndOrganisation(){
// empty constructor
    }
    public orderingMealAndOrganisation(OrderDepot orderDepot) {
        this.depot = orderDepot;
        this.scanner = new Scanner(System.in);
    }


   public void order() {
       System.out.println("\n--- SECTION 1: ORGANIZATION SELECTION ---");
// Organizasyon Kodlarını Kopyaladık
       System.out.println("Please select the type of organization you want.");
       System.out.println("1- Birthday\n 2- Consept Party\n 3- Wedding \n 4- Kina ");
       System.out.println("Please enter the number of your choice:");
       int organisationtype = scanner.nextInt();

       OrderOrganisation orderOrganisation = null;

       if (organisationtype == 1) orderOrganisation = new Birthday();
       if (organisationtype == 2) orderOrganisation = new ConceptParty();
       if (organisationtype == 3) orderOrganisation = new Wedding();
       if (organisationtype == 4) orderOrganisation = new Kina();

       if (orderOrganisation != null) {
           orderOrganisation.accessories();
           orderOrganisation.numberOfPeople();
           orderOrganisation.waiterPreference();
           orderOrganisation.dj();
           orderOrganisation.choices();
           this.selectedOrganization = orderOrganisation;
           depot.addOrganisation(orderOrganisation); // Depoya kaydet
           System.out.println(">> Organization added to the cart.");
       }

       System.out.println("\n--- SECTION 2: MEAL SELECTION ---");
       // Yemek Kodlarını Kopyaladık
       System.out.println("Please select the type of meal you want to order.");
       System.out.println("1- Normal meal\n2- Vegetarian meal\n3- Vegan meal");

       int foodType = scanner.nextInt();

       OrderingFood orderFood = null;

       if (foodType == 1) orderFood = new NormalFood();
       else if (foodType == 2) orderFood = new VegetarianFood();
       else if (foodType == 3) orderFood = new VeganFood();
       else System.out.println("Invalid choice.");

       if (orderFood != null) {
           orderFood.foodName();
           orderFood.numberOfPeople();
           orderFood.beverageChoice();
           orderFood.dessertChoice();
           this.selectedFood = orderFood;
           depot.addFood("Meal Order (Mixed Menu)"); // Depoya kaydet
           System.out.println(">> Meal added to the cart.");
       }

       System.out.println("\nBoth orders were successfully placed");
   }
   public void register(){
        writeToFile(selectedOrganization, selectedFood);
       System.out.println("Your selections have been saved to the file.");
   }
    public void writeToFile(OrderOrganisation org,
                            OrderingFood food) {

        try {
            FileWriter fw = new FileWriter(
                    "PROJEmasternew-master/src/main/java/com/ravzakoc/order_foodAndOrganisation", true);

            fw.write(" Email: " + Session.activeEmail +
                    " MİXED MENU | "+
                               // --- ORGANİZASYON ---
                            "Organisation: BİRTHDAY" +
                            " | Name: " + org.getName() +
                            "  Colour: " + org.getColour() +
                            " | The Number Of People Coming: " + org.getNumberOfPeople() +
                            " | Waitress: " + (org.getWaiterPreference()
                            ? "Wanted (" + org.getNumberOfWaiters() + ")" : "Not Wanted") +
                            " | DJ: " + (org.getdj() ? "Wanted" : "Not Wanted") +" | "+

                            " || " +

                            // --- YEMEK ---
                            "Food: NORMAL FOOD" +
                                    "Food: " + food.getFood() +
                                    " | Number of people: " + food.getNumberOfPeople() +
                                    " | Beverage: " + (food.getBeveragePreference() ? food.getDrink() : "Not choosen") +
                                    " | Dessert: " + (food.getDessertPreference() ? food.getDessert() : "Not choosen") +"\n"
            );

            fw.close();
            System.out.println("Mixed order has been saved to the file.");

        } catch (IOException e) {
            System.out.println("Error writing mixed order to the file: " + e.getMessage());
        }
    }

}


