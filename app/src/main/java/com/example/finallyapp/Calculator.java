package com.example.finallyapp;

public class Calculator {

    public double calculateTipOut(double percent, double netSales){
        percent = percent/100;
        return netSales*percent;
    }

    public double calculateFinal(boolean owesHouse, double tipOut, double amountOwed){
        if(owesHouse){
            return amountOwed + tipOut;
        } else {
            return amountOwed - tipOut;
        }
    }
}
