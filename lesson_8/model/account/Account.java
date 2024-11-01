package com.teachmeskills.lesson_8.model.account;

public class Account {

    public String accountNumber;
    public double amount;

    public Account(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public void showAccountInfo(){
        System.out.println(accountNumber + " -> " + amount);
    }
}