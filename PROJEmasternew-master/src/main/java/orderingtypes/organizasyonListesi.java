package orderingtypes;

import java.util.List;

public class organizasyonListesi {
    protected List<OrderOrganisation> organisationList;
    protected List<String> foodList;
    protected List<orderingMealAndOrganisation> foodandorgList;


    public void addOrganisation(OrderOrganisation org) {
        organisationList.add(org);
    }

    public List<OrderOrganisation> getOrganisationList() {
        return organisationList;
    }


    public void addFood(String food) {
        foodList.add(food);
    }

    public List<String> getFoodList() {
        return foodList;
    }

    public void foodAndOrg(orderingMealAndOrganisation mealAndOrganisation){
        foodandorgList.add(mealAndOrganisation);

    }

    public List< orderingMealAndOrganisation> getFoodandorgList(){
        return foodandorgList;
    }

}

