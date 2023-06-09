package com.techelevator;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Transactions {
    public Transactions() {
    }

    UserInterface ui = new UserInterface();
    BigDecimal amtLeft;
    private BigDecimal amtQuarters;
    private BigDecimal amtDimes;
    private BigDecimal amtNickels;

    public BigDecimal getAmtLeft() {
        return amtLeft;
    }

    public void setAmtLeft(BigDecimal amtLeft) {
        this.amtLeft = amtLeft;
    }


    public BigDecimal getAmtQuarters() {
        return amtQuarters;
    }

    public void setAmtQuarters(BigDecimal amtQuarters) {
        this.amtQuarters = amtQuarters;
    }

    public BigDecimal getAmtDimes() {
        return amtDimes;
    }

    public void setAmtDimes(BigDecimal amtDimes) {
        this.amtDimes = amtDimes;
    }

    public BigDecimal getAmtNickels() {
        return amtNickels;
    }

    public void setAmtNickels(BigDecimal amtNickels) {
        this.amtNickels = amtNickels;
    }
    final private BigDecimal zero = new BigDecimal("0");
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

    public BigDecimal amountEntered() {

        //while(true) {
        //make sure amount is greater than 0, and a number
            String enteredAmount = ui.askHowMuchMoney();
        try {
            Integer money = Integer.parseInt(enteredAmount);
            BigDecimal amtEntered = new BigDecimal(String.valueOf(money));

            if (amtEntered.compareTo(zero) <= 0) {
                ui.displayInvalidInput();
            } else {
                currentAmt = currentAmt.add(amtEntered);
            }

        } catch (Exception e) {
            ui.displayInvalidInput();
        }

        //   break;
        // }
        return currentAmt;

    }

    public BigDecimal purchaseItem(Item picked) {

        currentAmt = currentAmt.subtract(picked.getItemPrice());

        return currentAmt;
    }
    List<Integer> coins = new ArrayList<>();

    public List<Integer> getCoins() {
        return coins;
    }

    public List<BigDecimal> makeChange() {
//        amtQuarters = 0;
//        amtDimes = 0;
//        amtNickels = 0;
        List<BigDecimal> coins = new ArrayList<>();

        BigDecimal[] numberOfQuarters = amtLeft.divideAndRemainder(quarter);
        amtQuarters = numberOfQuarters[0];
        amtLeft = numberOfQuarters[1];
        BigDecimal[] numberOfDimes = amtLeft.divideAndRemainder(dime);
        amtDimes = numberOfDimes[0];
        amtLeft = numberOfDimes[1];
        BigDecimal[] numberOfNickels = amtLeft.divideAndRemainder(nickel);
        amtNickels = numberOfNickels[0];
        amtLeft = numberOfNickels[1];
        coins.add(amtQuarters);
        coins.add(amtDimes);
        coins.add(amtNickels);

        return coins;
    }


}
