package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

public class VisaCard extends BaseCard{

    int cashback;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency) {
        super(cardNumber, cvv, validDate, cardHolder, currency);
        this.cashback = cashback;
    }

    @Override
    public boolean checkCardLimitTransfer(double transferAmount) {
        return (Constants.VisaCardLimit >= transferAmount);
        // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит

        // это пока стоит как ответ-заглушка
    }
}

