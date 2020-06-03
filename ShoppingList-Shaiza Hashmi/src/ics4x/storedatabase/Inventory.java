package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Class Name: [Item]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This class sets up the view for the inventory and sub-inventories which will show the information
 *               for items, specifically category-wise. Depending on what the user asks for, the object’s behaviours
  *              will be implemented accordingly.]
 */

public class Inventory {

    //initialization of subclasses
    private Toy toys = new Toy();
    private Food foods = new Food();
    private Book books = new Book();

    //sets up and generates all values for the toy category, name(descriptions), prices, quantity, and toy's age list
    public void toysInit(){
        toys.generatePrices();
        toys.descriptions();
        toys.quantity();
        toys.ages();
    }
    //sets up and generates all values for the food category, name(descriptions), prices, quantity, and calories contained in food
    public void foodsInit(){
        foods.generatePrices();
        foods.descriptions();
        foods.quantity();
        foods.calories();
    }
    //sets up and generates all values for the book category, name(descriptions), prices, quantity, and author's names
    public void booksInit(){
        books.generatePrices();
        books.descriptions();
        books.quantity();
        books.authors();
    }

    //prints out inventory of all items in store
    public void inventories(){
        //sets up inits for all 3 categories
        //prints out information under 3 headings; Goods names, Quantitities, and Price
        //information is prined out in a table format
        toysInit();
        foodsInit();
        booksInit();
        System.out.format("+--------------------+------------+--------------+%n");
        System.out.format("|  Goods name        | Quantity   | Price (+tax) |%n");
        System.out.format("+--------------------+------------+--------------+%n");
        for (int i = 0; i < 3; i++) {//prints out toy section
            String leftAlignFormat = "| %18s | %10s | %12s | %n";
            System.out.format(leftAlignFormat, toys.inventory[i][0], toys.inventory[i][1], toys.inventory[i][2]);
        }
        for (int i = 3; i < 7; i++) {//prints out foods section
            String leftAlignFormat = "| %18s | %10s | %12s | %n";
            System.out.format(leftAlignFormat, foods.inventory[i][0], foods.inventory[i][1], foods.inventory[i][2]);
        }
        for (int i = 7; i < 10; i++) {//prints out the books section
            String leftAlignFormat = "| %18s | %10s | %12s | %n";
            System.out.format(leftAlignFormat, books.inventory[i][0], books.inventory[i][1], books.inventory[i][2]);
        }

        System.out.format("+--------------------+------------+--------------+%n");
    }

    public void toyStock(){//prints out relevant information for only Toys category
        toysInit();//sets up all values for toys
        //prints out a min table, similar to inventory, but only for toys section, with extra column
        System.out.format("+--------------------+------------+--------------+-------------+%n");
        System.out.format("|  Toy's name        | Quantity   | Price (+tax) |  Age Limit  |%n");
        System.out.format("+--------------------+------------+--------------+-------------+%n");
        for (int i = 0; i < 3; i++) {
            String leftAlignFormat = "| %18s | %10s | %12s | %11s | %n";
            System.out.format(leftAlignFormat, toys.inventory[i][0], toys.inventory[i][1], toys.inventory[i][2], toys.inventory[i][3]);
        }
        System.out.format("+--------------------+------------+--------------+-------------+%n");
    }
    public void foodsStock(){//prints out relevant information for only food category
        foodsInit();//sets up all values for foods
        //prints out a min table, similar to inventory, but only for food section, with extra column
        System.out.format("+--------------------+------------+--------------+-------------+%n");
        System.out.format("|  Foods name        | Quantity   | Price(no tax)|   Calories  |%n");
        System.out.format("+--------------------+------------+--------------+-------------+%n");
        for (int i = 3; i < 7; i++) {
            String leftAlignFormat = "| %18s | %10s | %12s | %11s | %n";
            System.out.format(leftAlignFormat, foods.inventory[i][0], foods.inventory[i][1], foods.inventory[i][2], foods.inventory[i][3]);
        }
        System.out.format("+--------------------+------------+--------------+-------------+%n");
    }
    public void booksStock(){//prints out relevant information for only books category
        booksInit();//sets up all values for books
        //prints out a min table, similar to inventory, but only for books section, with extra column
        System.out.format("+--------------------+------------+--------------+--------------------+%n");
        System.out.format("|  Book's name       | Quantity   | Price (+tax) |       Author       |%n");
        System.out.format("+--------------------+------------+--------------+--------------------+%n");
        for (int i = 7; i < 10; i++) {
            String leftAlignFormat = "| %18s | %10s | %12s | %18s | %n";
            System.out.format(leftAlignFormat, books.inventory[i][0], books.inventory[i][1], books.inventory[i][2], books.inventory[i][3]);
        }
        System.out.format("+--------------------+------------+--------------+--------------------+%n");
    }

}
