package com.teachmeskills.lesson_8.model.card;

import java.util.Date;
import com.teachmeskills.lesson_8.utils.Constants;
public class MasterCard extends BaseCard {

    public String country;

    public MasterCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, int i, String country) {
        super(cardNumber, cvv, validDate, cardHolder, currency);
        this.country = country;
    }

    @Override
    public boolean checkCardLimitTransfer(double transferAmount) {
        return (Constants.MasterCardLimit >= transferAmount);

            // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит

            // это пока стоит как ответ-заглушка
        }
}

