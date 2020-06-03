package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Class Name: [Food]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This class extends superclass item and implements the interface of Taxable. This class generate the
 *               appropriate and necessary values for the Food category. Description, Prices, and number of calories are information
 *               included and generated here]*
 */

public class Food extends Item{

    private double[] foodPrice = new double[10];//overrides superclass' variables'

    public void generatePrices(){//overrides superclass' method,a generates prices from a certain range specifically for food
        for(int i =3; i <7;i++){ //randomize food prices from a low price range
            foodPrice[i] = rand.nextFloat() * (10.0 - 2.0) + 2.0;
            inventory[i][2] = String.format ("%.2f", foodPrice[i]);
        }
    }

    public void descriptions(){//generates descriptions/names of all foods in the category
        inventory[3][0] = "Granola Bar";
        inventory[4][0] = "Apples";
        inventory[5][0] = "Mangoes";
        inventory[6][0] = "Cake";
    }

    public void calories(){//generates the number of calories in each food from a random interval
        for(int i = 3; i<7; i++){
            int calories = rand.nextInt(300-110) + 110;
            inventory[i][3] = Integer.toString(calories);
        }
    }
}
