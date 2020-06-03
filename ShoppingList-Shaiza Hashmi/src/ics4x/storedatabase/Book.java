package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Class Name: [Book]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This class extends superclass item and implement's the interface of Taxable. This class generate the
 *               appropriate and necessary values for the Book category. Description, Prices, and age limits are information
 *               included and generated here]*
 */

public class Book extends Item implements Taxable{

    private double[] bookPrice = new double[10];//override superclass' method

    public void generatePrices(){//overrides superclass' method,a generates prices from a certain range specifically for book
        for(int i = 7; i <10; i++){  //randomize book prices from a separate price range
            bookPrice[i] = rand.nextFloat() * (35.0 - 12.0) + 12.0; //generates from a range of 12$ to 35$
            calculateTax();
        }
    }
    public void calculateTax(){
        for(int i = 7; i < 10; i++){
            bookPrice[i] = bookPrice[i]* taxRate;
            inventory[i][2] = String.format ("%.2f", bookPrice[i]);
        }
    }

    public void descriptions(){//generates descriptions/names of all the books in the category
        inventory[7][0] = "Great Gatsby";
        inventory[8][0] = "Into the Wild";
        inventory[9][0] = "The Cat in the Hat";
    }

    public void authors() {//generate the author's names and store into inventory for books
        inventory[7][3] = "F. Scott Fitgerald";
        inventory[8][3] = "Erin Hunter";
        inventory[9][3] = "Dr. Seuss";

    }
}
