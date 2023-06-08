package com.techelevator;

import java.math.BigDecimal;

public class Transactions {
    public Transactions() {
    }

    UserInterface ui = new UserInterface();

    private BigDecimal quarter = new BigDecimal("0.25");
    private BigDecimal dime = new BigDecimal("0.10");
    private BigDecimal nickel = new BigDecimal("0.05");

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

    public BigDecimal amountEntered(){

       while(true) {
           BigDecimal amtEntered = new BigDecimal(ui.askHowMuchMoney());
               currentAmt = currentAmt.add(amtEntered);
           //System.out.println(totalAmtEntered);
           break;
       }
        return currentAmt;

    }

    public void purchaseItem() {
        BigDecimal balance = new BigDecimal(0);
        //total amount entered - item price
        //give change
    }
    public void makeChange(){
        int amtQuarters = 0;
        int amtDimes = 0;
        int amtNickels = 0;

    }

//    public void depositMoney(BigDecimal balance) {
//        if(balance.compareTo(amountEntered()) == 0)
//            amountEntered()
//
//    }
}
