package com.teachmeskills.lesson_8.model.document;
import com.teachmeskills.lesson_8.model.card.BaseCard;

import java.util.Date;
// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран
public class Check {
    public double TransferAmount;
    public Date transferDate;
    public BaseCard card;
    public String comment;
    public Check(int transferAmount, Date transferDate, BaseCard card, String comment) {
        this.TransferAmount = transferAmount;
        this.transferDate = transferDate;
        this.card = card;
    }
public void showCheckInformation() {
    System.out.println("Transfer from:" + card.cardNumber + "Amount" + TransferAmount);
}

    public void printCheckInfo() {
        System.out.println("Transfer from card: " + card.cardNumber + "\nAmount: " + TransferAmount + "\n" + comment);
    }
}
