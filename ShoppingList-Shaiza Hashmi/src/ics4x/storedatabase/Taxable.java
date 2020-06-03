package ics4x.storedatabase;
/*
 * Assignment Name: [ShoppingList]
 * Interface Name: [GoTaxable]
 * Author: [Shaiza Hashmi]
 * Date: [11/25/2018]
 * Description: [This project...]*
 */


public interface Taxable {                  //Interface for a taxable object
    double taxRate = (float) 1.06;           //The tax rate amount
    void calculateTax();                   //Method to calculate the tax of an object
}