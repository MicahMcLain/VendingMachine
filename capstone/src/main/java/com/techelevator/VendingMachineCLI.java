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


    //private Item picked;

    public void doPurchaseWorkflow() {
        while (true) {
            String userChoice = ui.purchaseItemOption();
            if (userChoice.equals("1")) {
                BigDecimal total = new BigDecimal(String.valueOf(transactions.amountEntered()));
                transactions.setCurrentAmt(total);
                ui.displayTotalAMTEntered(total);

            } else if (userChoice.equals("2")) {
                ui.displayAllItems(slots);
                String selectedItem = ui.selectProduct();
                if (selectedItem.equals(""))
                    continue;

                Item picked = selectItem(selectedItem);
                if (picked != null) {
                    if (hasEnoughMoney(picked)) {
                        if (hasEnoughItems(picked)) {
                            transactions.purchaseItem(picked);
                            picked.dispenseItem();
                            ui.displayItemTypeMessage(picked);
                            ui.displayLeftOverMoney(transactions.getCurrentAmt());
                        } else {
                            ui.itemSoldOut();
                        }
                    } else {
                        ui.displayNotEnough();
                    }

                }
            } else if (userChoice.equals("3")) {
                transactions.makeChange();
            } else if (userChoice.equals("")){
                return;
            }
            else {
                ui.displayInvalidInput();
            }
        }
        //return;
    }



    public boolean hasEnoughMoney(Item picked) {
        if (transactions.getCurrentAmt().compareTo(picked.getItemPrice()) > 0)
            return true;
        ui.displayNotEnough();
        return false;
    }


    public Item selectItem(String selectedItem) {

            for (Item chosenItem : slots) {
                if (selectedItem.equals(chosenItem.getItemSlot())) {
                    return chosenItem;
                }

            }
            ui.displayInvalidInput();
            return null;
    }

    private boolean hasEnoughItems(Item picked) {
        return picked.getItemAmount() > 0;

    }
}
