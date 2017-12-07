package FunctionLayer;

import entity.Material;
import java.util.ArrayList;

public class PriceCalculator {

    public double totalOrderPrice(ArrayList<Material> carportItems){
        double totalPrice = 0;
        for (Material material : carportItems) {
            totalPrice += material.getAmount() * material.getPrice();
        }
        return totalPrice;
    }
}