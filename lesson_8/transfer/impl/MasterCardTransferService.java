package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

// TODO реализовать имплементацию интерфейса
public class MasterCardTransferService implements CardTransferService {
    @Override
    public Check transferFromCardToCard(BaseCard sendingCard, BaseCard receivingCard, int amountTransfer) {
        if (sendingCard.checkCardLimitTransfer(amountTransfer)) {
            sendingCard.amount -= amountTransfer;
            receivingCard.amount += amountTransfer;
            return new Check(amountTransfer, new Date(), sendingCard, "Operation declined");
        }else{
            System.out.println("limit exceeded error");
            return new Check(Constants.MasterCardLimit, new Date(), sendingCard, "Operation declined");
        }


    }

    @Override
    public Check transferFromCardToAccount(BaseCard sendingCard, Account receivingAccount, int amountTransfer) {
        if (sendingCard.checkCardLimitTransfer(amountTransfer)){
            sendingCard.amount -= amountTransfer;
            receivingAccount.amount += amountTransfer;
            return new Check(amountTransfer, new Date(), sendingCard, "operation approved");
        }else if(amountTransfer <= 0) {
            return new Check(amountTransfer, new Date(), sendingCard, "Operation declined");
        } else {
            return new Check(Constants.MasterCardLimit, new Date(), sendingCard, "limit exceeded error");
        }

    }
}