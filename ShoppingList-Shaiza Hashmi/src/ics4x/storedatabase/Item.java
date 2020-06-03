package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Class Name: [Item]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This class is a superclass. Food, Toy and Book are its subclasses. This class defines the basic
 *               arrays and variables use. Only quantities method has code, as it is not subclass specific.]
 */

//import statements
import java.util.Random;

public class Item {

    String[][] inventory = new String[10][4];   //inventory array which stores all information of what shop provides
    private int[] value = new int[10];  //variable used to generate Price in their subclass
    public Random rand = new Random(); //random rand variable init

    public void generatePrices(){
    }

    public void descriptions(){
    }

    public void quantity(){//method determines how many of each item will be stocked by the store
        for(int i = 0; i < 10; i++){
            value[i] = rand.nextInt(25 - 1)+ 1;
            inventory[i][1] = Integer.toString(value[i]); //sends value to the overall array
        }

    }

}
