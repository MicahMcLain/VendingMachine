package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineCLI {

    private ArrayList<Item> slots = new ArrayList<>();

    public ArrayList<Item> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Item> slots) {
        this.slots = slots;
    }

    UserInterface ui = new UserInterface();
    Transactions transactions = new Transactions();

    public VendingMachineCLI() {
        readFile();
    }

    public void run() {
        // start your vending machine from here

        while (true) {
            String userChoice = ui.displayMainMenu();

            switch (userChoice) {
                case "1":
                    ui.displayAllItems(slots);
                    //if out of stock, display out of stock
                    break;
                case "2":
                    doPurchaseWorkflow();
                    break;
                case "3":
                    ui.displayGoodbyeMessage();
                    return;
                default:
                    ui.displayInvalidInput();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        VendingMachineCLI cli = new VendingMachineCLI();
        cli.run();

    }

    private void readFile() {

        File input = new File("vendingmachine.csv");

        try (Scanner fileScanner = new Scanner(input)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] itemList = line.split("\\|");

                String itemSlot = itemList[0];
                String itemName = itemList[1];
                BigDecimal itemPrice = new BigDecimal(itemList[2]);
                String itemType = itemList[3];

                Item item = new Item(itemName, itemType, itemPrice, 5, itemSlot);
                this.slots.add(item);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }


    }

    public void selectItem() {
        while (true) {
            String selectedItem = ui.selectProduct();

            if (selectedItem.equals("")) return;

            for (Item chosenItem : slots) {
                if (selectedItem.equals(chosenItem.getItemSlot())) {
                    picked = chosenItem;
                    break;
                }
            }
            if (picked != null) {
                ui.displaySelectedItem(picked);
            }

            else  {
                ui.displayInvalidInput();
                return;
            }
        }
    }
        private Item picked;

    public void doPurchaseWorkflow() {
        while (true) {
            String userChoice = ui.purchaseItemOption();
            if (userChoice.equals("1")) {
               BigDecimal total = new BigDecimal(String.valueOf(transactions.amountEntered()));
               ui.displayTotalAMTEntered(total);

            } else if (userChoice.equals("2")) {
                ui.displayAllItems(slots);
                selectItem();
                //if item code doesnt exist, display error message
                if(picked.getItemAmount() < 1){
                    ui.itemSoldOut();
                }
                //if bought, display message based on item type
                //then change item quantity to one less
            } else if (userChoice.equals("3")){
                //give change if necessary
                BigDecimal amtEntered = new BigDecimal(ui.askHowMuchMoney());
                //return to main menu

                if((amtEntered.compareTo(picked.getItemPrice()) > 0)){
                    transactions.purchaseItem();
                    //give change function from transactions
                    //log transaction
                } else {
                    ui.displayNotEnough();
                    //return to this menu instead of main menu
                }
            }
            //return;
        }
    }

}
