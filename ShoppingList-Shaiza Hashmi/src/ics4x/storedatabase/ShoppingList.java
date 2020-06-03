package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Class Name: [ShoppingList]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This project simulates a regular shopping trip one may do every week. The program allows the user to view the
 *               the inventory of the shop, add items to their cart/shopping list, remove items of their choice, and view the
 *               the cart as well. The user can add a maximum of ten items to their shopping list]
 */

//import statements to state and import external libraries used in this class
import java.util.Objects;
import java.util.Scanner;

public class ShoppingList implements Basket{
//this class implements the interface basket to act as a collection of the items the user would like
    //String variables to hold userInput and parsed substrings
    String request; //main string
    String response;    //substring 1
    String result;  //substring 2

    //booleans used to check what the first substring contains.
    // If the substring's content matches the variables' name, variable will be set to true
    boolean add = false;    //user wants to add items to shopping list
    boolean remove = false; //user wants to remove an item from shopping list
    boolean get = false;    //user is confirming addition of certain item to user's shopping list
    boolean cart = false;   //user wants to check the shopping list

    //following variables turn true if the content of the overall string mathces variables' names
    boolean userInput = true;   //program will continuously check for user input until correct statement is written
    boolean viewInventory = false;  //user wants to view inventory of the shop

    int category = 0;   //lets the program know content of substring. from 1-10, the value of category corresponds to
                        //an index in the inventory's list

    public void instruction(){ //first instruction set to begin program. User must enter 'start shopping' to begin
        System.out.println("Hello! Want to begin shopping?");
        System.out.println("Type" + CYAN + " start shopping " + RESET + "to begin!");
        stringCompare();    //program checks what exactly user inputted
    }
    public void instructions2(){    //instruction set #2. This method prints out the basic commands needed to work the program.
                                    //User must follow the instructions and type the commands accordingly as highlighted in
                                    //the CYAN blue colour
        System.out.println("Basic Commands:");
        System.out.println(YELLOW + "*************************************************************" + RESET);
        System.out.println(YELLOW + "*" + RESET + " To Add Items to Shopping List:" + CYAN + " add <item name> " + RESET + YELLOW +"*\n" + RESET +
                YELLOW + "*" + RESET + " To Remove Items from Shopping List:" + CYAN + " remove <item name>    " + RESET + YELLOW +"*\n" + RESET +
                YELLOW + "*" + RESET + " To View Inventory:" + CYAN + " view items                             " + RESET + YELLOW +"*\n" + RESET +
                YELLOW + "*" + RESET + " To Confirm Addition to Shopping list:" + CYAN + " get <item name>     " + RESET + YELLOW +"*\n" + RESET +
                YELLOW + "*" + RESET + " To view Shopping List:" + CYAN + " view cart                          " + RESET + YELLOW +"*\n" + RESET +
                YELLOW + "*" + RESET + " To checkout items in cart:" + CYAN + " checkout list                  " + RESET + YELLOW +"*\n" + RESET +
                YELLOW + "*" + RESET + " To view Basic commands:" + CYAN + " shop commands                     " + RESET + YELLOW + "*" + RESET);
        System.out.println(YELLOW + "*************************************************************" + RESET);
        stringCompare();    //checks user input and acts accordingly
    }
    public void stringCompare(){
        userInput = true;
        while(userInput) {  //loop will run as long as userInput is true. if a correct statement is entered, 'Userinput'
                            // will be set to false, and exit this while loop

            request = sc.nextLine(); //variable holding the entire string input from user
            response = request.substring(0, request.indexOf(" "));  //variable holding first substring-the first keyword
                                                                    // determining which command user wants to utilize
            result = request.substring(request.indexOf(" ") + 1);   //variable holding rest of string input to compare
                                                                    //what item or full command user wants to use

            //basic commands that allows uer to view the necessary information
            //These statements check the overall String input by separately checking substrings 1 and 2
            if (Objects.equals(response, "start") && Objects.equals(result, "shopping")) {
                instructions2();    //brings up command block
                userInput = false;
            }
            if (Objects.equals(response, "shop") && Objects.equals(result, "commands")) {
                instructions2(); //brings up command block
                userInput = false;
            }
            if (Objects.equals(response, "view") && Objects.equals(result, "items")) {
                viewInventory = true; //sets boolean for viewing inventory to true
                userInput = false;
            }
            if (Objects.equals(response, "view") && Objects.equals(result, "cart")) {
                cart = true; //sets variable to view shopping list to true
                userInput = false;
            }

            if (Objects.equals(response, "add")) {//if the first substring is 'add', sets boolean controlling 'add's'
                add = true;                          //to true
                userInput = false;
            }
            if (Objects.equals(response, "remove")) {//if the first substring is 'remove', sets boolean controlling 'remove's'
                remove = true;                          //to true
                userInput = false;
            }
            if (Objects.equals(response, "get")) {//if the first substring is 'get', sets boolean controlling 'get's'
                get = true;                          // to true
                userInput = false;

            }

            //if second substring equals any of hte followings strings, sets category variable to appropriate value in
            // order to check later which object to add/remove/get
            if (result.equalsIgnoreCase("toy car")) {
                category = 1;
                userInput = false;
            }
            if (result.equalsIgnoreCase("doll")) {
                category = 2;
                userInput = false;
            }
            if (result.equalsIgnoreCase("lego")) {
                category = 3;
                userInput = false;
            }
            if (result.equalsIgnoreCase("granola bar")) {
                category = 4;
                userInput = false;
            }
            if (result.equalsIgnoreCase("apples")) {
                category = 5;
                userInput = false;
            }
            if (result.equalsIgnoreCase("mangoes")) {
                category = 6;
                userInput = false;
            }
            if (result.equalsIgnoreCase("cake")) {
                category = 7;
                userInput = false;
            }
            if (result.equalsIgnoreCase("great gatsby")) {
                category = 8;
                userInput = false;
            }
            if (result.equalsIgnoreCase("into the wild")) {
                category = 9;
                userInput = false;
            }
            if (result.equalsIgnoreCase("the cat in the hat")) {
                category = 10;
                userInput = false;
            }
            else {
                if(userInput){//if the user mistypes a command, this will be displayed
                                      //if user reatedly mistypes, this will continue to show unless user types in an accpeted
                                      //command
                    System.out.println("Invalid Command. Please try again.");
                }
            }
        }
        routeGoods();//checks afterwards for mix and matching and acting appropriately according to values
    }

    //method that checks for all possibilities for adding an item to the shopping list
    public void addItems(){
        //if statement checks
        if(add && category > 0 && category <= 3){
            stock.toyStock();
            //if item user wants to add belongs in the toy category, further info for the toy category
            //will be brought up for addition confirmation
            add = false;
        }
        if(add  && category > 3 && category <= 7){
            //if item user wants to add belongs in the food category, further info for the food category
            //will be brought up for addition confirmation
            stock.foodsStock();
            add = false;
        }
        if(add  && category > 7 && category <= 10){
            //if item user wants to add belongs in the book category, further info for the book category
            //will be brought up for addition confirmation
            stock.booksStock();
            add = false;
        }
    }
    //method that confirms addition to shopping cart list
    public void getItems(){
        //runs a simple if loop, with a for loop. stores value of substring 2 in the first empty array index
        if(get == true){
            for(int i = 0; i < list.length; i++)
            {
                if(list[i][0] == null) {
                    list[i][0] = result;
                    //to ensure no overlapping of values when calling command 'view cart', 'cart value is also stored.
                    //this clears that value so it no longer remains
                    if(list[i][0].equalsIgnoreCase("cart")){
                        list[i][0] = null;
                    }
                    i = 10;
                    //checkout();
                    get = false;
                }
            }
        }
    }
    //method that removes items from shopping list
    public void removeItems(){
        //runs a simple if loop, with a for loop. searches for value of substring 2 in array, when it finds it,
        // it empties that index, resetting it to a null value
        if(remove == true){
            for(int i = 0; i < list.length; i++){
                if(list[i][0].equals(result)){
                    list[i][0] = null;
                    i = 10;
                }
                remove = false;
                //category = 0;
            }
        }
    }//one loop works for all items no matter what
    //method checks for combinations of possible substrings 1 and 2, and acts accordingly
    public void routeGoods(){
        addItems();
        getItems();
        if(cart == true){
            for(int i = 0; i < 10; i++){
                System.out.println(list[i][0]);
            }
            cart = false;
        }
        removeItems();
        if(viewInventory == true){
            stock.inventories();
            viewInventory = false;
        }
        stringCompare();
    }

    //main method of program. This is where the program begins.
    //instantiation of project occurs here
    public static void main(String args[]){
        ShoppingList start = new ShoppingList();
        start.run();
    }

    //individually developed run method to hold methods to run program
    public void run(){
        instruction();
        stringCompare();

    }
}
