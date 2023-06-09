package com.techelevator;

import java.math.BigDecimal;

public class Transactions {
    public Transactions() {
    }

    UserInterface ui = new UserInterface();
    BigDecimal amtLeft;
    private int amtQuarters;
    private int amtDimes;
    private int amtNickels;

    public BigDecimal getAmtLeft() {
        return amtLeft;
    }

    public void setAmtLeft(BigDecimal amtLeft) {
        this.amtLeft = amtLeft;
    }


    public int getAmtQuarters() {
        return amtQuarters;
    }

    public void setAmtQuarters(int amtQuarters) {
        this.amtQuarters = amtQuarters;
    }

    public int getAmtDimes() {
        return amtDimes;
    }

    public void setAmtDimes(int amtDimes) {
        this.amtDimes = amtDimes;
    }

    public int getAmtNickels() {
        return amtNickels;
    }

    public void setAmtNickels(int amtNickels) {
        this.amtNickels = amtNickels;
    }

    final private BigDecimal quarter = new BigDecimal("0.25");
    final private BigDecimal dime = new BigDecimal("0.10");
    final private BigDecimal nickel = new BigDecimal("0.05");

    public BigDecimal getQuarter() {
        return quarter;
    }

    public BigDecimal getDime() {
        return dime;
    }

    public BigDecimal getNickel() {
        return nickel;
    }
    BigDecimal currentAmt = new BigDecimal("0");

    public BigDecimal getCurrentAmt() {
        return currentAmt;
    }

    public void setCurrentAmt(BigDecimal currentAmt) {
        this.currentAmt = currentAmt;
    }

    public BigDecimal amountEntered(){

        while(true) {
            BigDecimal amtEntered = new BigDecimal(ui.askHowMuchMoney());
            currentAmt = currentAmt.add(amtEntered);
         break;
        }
        return currentAmt;

    }

    public BigDecimal purchaseItem(Item picked) {
        currentAmt = currentAmt.subtract(picked.getItemPrice());

        return currentAmt;
    }
    public void makeChange(){
        amtQuarters = 0;
        amtDimes = 0;
        amtNickels = 0;
        if (amtLeft.compareTo(quarter) > 0){
            //loop through and subtract quarters until less than 25
        }
        else if (amtLeft.compareTo(dime) > 0){
            //loop through and subtract dimes until less than 10
        }
        else {
            //loop through and add nickels until 0
        }

    }


}
