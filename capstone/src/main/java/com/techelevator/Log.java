package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Log {

    public void printPurchasedItem(Item picked, BigDecimal currentBalance) {
        PrintWriter writer = null;
        final File newFile = new File("log.txt");
        FileOutputStream newThing = null;

        try {
            newThing = new FileOutputStream(newFile, true);
            writer = new PrintWriter(newThing);
            writer.println(LocalDateTime.now()+ " " + picked.getItemName() + " " + picked.getItemSlot()  + " " +
                    picked.getItemPrice() + " " + currentBalance);
        } catch (Exception e) {
            System.out.println("Cannot write this file. Please try again" + e.getMessage());
        } finally {
            writer.flush();
        }
    }
    public void printFeedMoney(BigDecimal currentBalance) {
        PrintWriter writer = null;
        final File newFile = new File("log.txt");
        FileOutputStream newThing = null;

        try {
            newThing = new FileOutputStream(newFile, true);
            writer = new PrintWriter(newThing);
            writer.println(LocalDateTime.now() + " FEED MONEY " + currentBalance);
        } catch (Exception e) {
            System.out.println("Cannot write this file. Please try again" + e.getMessage());
        } finally {
            writer.flush();
        }
    }
}
