package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Interface Name: [Basket]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This project...]*
 */

import java.util.Scanner;

public interface Basket {
    //object instantiation of other classes
    Inventory stock = new Inventory();  //Inventory instantiation in order to view inventory information

    // array to hold user's chosen items in a shopping list array. Column 1 = Item Name; Column 2 = Item's Price
    String[][] list = new String[10][2];

    //set up of scanner to check for user Input
    Scanner sc = new Scanner(System.in);

    //ASCII values of colours to change text colour in the console
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String RESET = "\033[0m";  // Text colour Reset



    void instruction();
    void instructions2();
    void stringCompare();
    void addItems();
    void getItems();
    void removeItems();
    void routeGoods();
}
