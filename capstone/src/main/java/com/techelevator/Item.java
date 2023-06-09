package com.techelevator;

import java.math.BigDecimal;

public class Item {
    private String itemName;
    private String itemType;
    private BigDecimal itemPrice;
    private int itemAmount;
    private String itemSlot;

    private String itemInfo;

    public Item() {
    }



    public Item(String itemName, String itemType, BigDecimal itemPrice, int itemAmount, String itemSlot) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
        this.itemSlot = itemSlot;


    }

    public String setItemInfo(String itemName, String itemType, BigDecimal itemPrice, String itemSlot){
        itemInfo = itemSlot+" | "+itemName+" | "+itemPrice+" | "+itemType + " | "+ itemAmount;
        return itemInfo;
    }

    public String getItemInfo() {
        return itemInfo;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }
    public void dispenseItem(){
            itemAmount --;
    }
}
