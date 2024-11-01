package com.teachmeskills.lesson_8.model.client;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;

public class LegalClient extends BaseClient{

    public String legalClientNumber;

    public LegalClient(String name, Account[] accounts, BaseCard[] cards , String legalClientNumber) {
        super(name, accounts, cards);
        this.legalClientNumber = legalClientNumber;
    }
}