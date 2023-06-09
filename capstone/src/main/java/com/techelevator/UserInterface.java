package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {


    public UserInterface() {
    }

    Scanner scanner = new Scanner(System.in);

    public String displayMainMenu(){
        System.out.println();
        System.out.println("Welcome to the Vend-o-Matic 800");
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        return scanner.nextLine();
    }

    public String selectProduct() {
        System.out.print("Pick an item you would like to purchase -> ");
        return scanner.nextLine();
    }

    public String askHowMuchMoney() {
        System.out.print("How much money would you like to enter? -> ");

        return scanner.nextLine();

    }

    public String purchaseItemOption(){
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");


        return scanner.nextLine();
    }


    public void displayGiveChange(List<BigDecimal> coins){
        System.out.printf("The number of coins you'll receive is %s quarters, %s dimes, %s nickels.",
                coins.get(0), coins.get(1), coins.get(2));

    }


    public void displayGoodbyeMessage() {
        System.out.println("Have a good day!");
        System.out.println();
    }

    public void displayInvalidInput() {
        System.out.println("Invalid input. Please try again!");
        System.out.println();
    }

    public void displayAllItems(List<Item> slots){
        for (Item eachItem : slots){
            System.out.println(eachItem.getItemSlot() +" | "+eachItem.getItemName() +" | "
                    + eachItem.getItemPrice() +" | "+ eachItem.getItemType() + " | "+ eachItem.getItemAmount());
        }
        System.out.println();
    }

    public void itemSoldOut() {

        System.out.println("Sorry, that item is sold out. Please choose another item.");

    }

    public void displayTotalAMTEntered(BigDecimal total) {

        System.out.print("Your total amount entered is: $" + total);
        System.out.println();

    }

    public void displayNotEnough() {
        System.out.println("Please enter more money");
    }

    public void displayLeftOverMoney(BigDecimal amtLeft) {
        System.out.println("The amount of money you have left is: $" + amtLeft);
    }

    public void displayItemTypeMessage(Item picked) {
        System.out.println();
        if (picked.getItemType().equals("Candy")) {
            System.out.println("Munch Munch, Yum!");
        } else if (picked.getItemType().equals("Chip")) {
            System.out.println("Crunch Crunch, Yum!");
        } else if (picked.getItemType().equals("Drink")) {
            System.out.println("Glug Glug, Yum!");
        } else if (picked.getItemType().equals("Gum")) {
            System.out.println("Chew Chew, Yum!");
        }
    }

    public void displayNoChange() {
        System.out.println();
        System.out.println("You won't get any change");
    }
}

