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
	}

	public void run() {
		// start your vending machine from here
		ui.displayMainMenu();

		while(true){
			String userChoice = ui.displayMainMenu();

			switch (userChoice) {
				case "1":
					selectItem();
					break;
				case "2":
					ui.purchaseItem();

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
				String[] items = line.split("|");

				String itemSlot = items[0];
				String itemName = items[1];
				BigDecimal itemPrice = new BigDecimal(items[2]);
				String itemType = items[3];

				Item item = new Item(itemName, itemType, itemPrice, 5, itemSlot);
				slots.add(item);

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");

		}



	}
	public void selectItem(){
		while(true) {
			String selectedItem = ui.displayItemButtons();

			if (selectedItem.equals(""))
				return;

			Item picked = null;
			for (Item chosenItem : slots) {
				if (selectedItem.equals(chosenItem.getItemSlot()))
					picked = chosenItem;
			}
			if (picked == null) {
				ui.displayInvalidInput();
			} else {
				purchaseItem(picked);
			}

		}
	}

	public void purchaseItem(Item picked){
		while(true) {
			String buy = ui.displayItemInfo(picked);

			if (buy.equals("1")){

			}
//				atmDeposit(active);
//			else if (buy.equals("2"))
//				atmWithdraw(active);
//			else if (buy.equals("3"))
//				return;
//			else {
//				ui.displayInvalidInput();
//			}
		}
	}


}
