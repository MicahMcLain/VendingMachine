package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class UiTest {
    @Test
    public void display_All_Items_Test(){
        Item c = new Item("Lays", "Chips", new BigDecimal("1.00"), 5, "A1");
        String itemInfo = c.getItemSlot()+"|"+c.getItemName() +"|"+c.getItemPrice()+"|"+c.getItemType();
        Assert.assertEquals("This should display item information", itemInfo, c.getItemSlot()+"|"+
                c.getItemName() +"|"+c.getItemPrice()+"|"+c.getItemType());
    }

    @Test
    public void display_Selected_Item(){
        Item d = new Item("Lays", "Chips", new BigDecimal("1.00"), 5, "A1");
        String picked = d.getItemSlot()+"|"+d.getItemName() +"|"+d.getItemPrice()+"|"+d.getItemType();
        Assert.assertEquals("Should display the selected item", picked,
                d.getItemSlot()+"|"+d.getItemName() +"|"+d.getItemPrice()+"|"+d.getItemType());
    }

}
