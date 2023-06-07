package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public String displayMainMenu(){
        System.out.println("Welcome to the Vend-o-Matic 800");
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        return scanner.nextLine();
    }

    public String displayItemButtons() {

        System.out.println("Vend-o-Matic 800");
        System.out.println("Please select the item you would like to buy");
        System.out.println("A1 || A2 || A3 || A4");
        System.out.println("B1 || B2 || B3 || B4");
        System.out.println("C1 || C2 || C3 || C4");
        System.out.println("D1 || D2 || D3 || D4");

        System.out.println("Exit");

        return scanner.nextLine();
    }

    public String purchaseItem(String itemName, BigDecimal itemPrice){
        System.out.printf("%s costs $%f .", itemName, itemPrice);
        System.out.println("Would you like to purchase this item?");
        System.out.println("(1) Purchase");
        System.out.println("(2) Go back");

        return scanner.nextLine();
    }

    public void displayMoneyAmount(BigDecimal price){
        System.out.printf("Please enter $%f", price);
        //loop through and update price if they didn't enter enough money

    }

    public void displayGiveChange(BigDecimal change){
        System.out.printf("The amount of change you'll receive is $%f", change);

    }

    public String displaySelectedItem(Item picked) {
        System.out.println(picked);
        System.out.println();
        return scanner.nextLine();
    }


    public void displayGoodbyeMessage() {
        System.out.println("Have a good day!");
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input. Please try again!");
    }

    public String displayItemInfo(Item picked) {
        System.out.println(picked);
        System.out.println("(1) Deposit");
        System.out.print("Select option > ");

        return scanner.nextLine();
    }
    public String displayAllItems(){
        return slots;
    }
}
