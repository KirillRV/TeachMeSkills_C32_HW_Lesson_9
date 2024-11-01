package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.model.client.BaseClient;
import com.teachmeskills.lesson_8.model.client.IndividualClient;
import com.teachmeskills.lesson_8.model.client.LegalClient;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;

import static com.teachmeskills.lesson_8.fabric.ParserFabric.createParser;

import java.util.Date;
import java.util.Scanner;


public class ApplicationRunner {

    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла
        System.out.print("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric

        // TODO заменить "" на имя файла, полученное со сканера
        IParser parser = createParser(filePath);
        parser.parseFile(filePath);
        System.out.println();

        // TODO реализовать тестовый сценарий
        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        // перевести с карты одного клиента на карту другого сумму денег
        // перевести с карты одного клиента на счет другого клиента сумму денег
        BaseClient client1 = new LegalClient("Cl" +
                "1",
                new Account[]{ new Account(" 1 ", 3000), new Account("0002", 1000)},
                new BaseCard[]{ new MasterCard(" **** **** **** 1875 ", 121, new Date(), "KIRILL", "BYN", 3500, "RB"),
                new VisaCard("**** **** **** 3358 ", 212, new Date(), "KIRILL", "BYN")},
                "12345678");

        BaseClient client2 = new IndividualClient(" Cl2 ",
                new Account[]{ new Account(" 2 ", 4000), new Account("0002", 3652)},
                new BaseCard[]{ new MasterCard("**** **** **** 3648 ", 121, new Date(), "Artem", "BYN", 400, "RB"),
                new VisaCard(" **** **** **** 2377 ", 212, new Date(), "Artem", "BYN")},
                "88005552535");

        BaseCard[] cardClient1 = client1.getCards();
        MasterCard masterCardClient1 = (MasterCard) cardClient1[0];
        VisaCard visaCardClient1 = (VisaCard) cardClient1[1];
        BaseCard[] cardClient2 = client2.getCards();
        MasterCard masterCardClient2 = (MasterCard) cardClient2[0];
        Account[] accountsClient2 = client2.getAccounts();
        Account accountClient2 = accountsClient2[1];

        MasterCardTransferService masterCardTransferService1 = new MasterCardTransferService();
        masterCardClient1.showBaseInfo();
        masterCardClient2.showBaseInfo();
        Check check1 = masterCardTransferService1.transferFromCardToCard(masterCardClient1, masterCardClient2,  100);
        check1.showCheckInformation();
        masterCardClient1.showBaseInfo();
        masterCardClient2.showBaseInfo();

        VisaCardTransferService visaCardTransferService1 = new VisaCardTransferService();
        visaCardClient1.showBaseInfo();
        accountClient2.showAccountInfo();
        Check check2 = visaCardTransferService1.transferFromCardToAccount(visaCardClient1 ,accountClient2, 916);
        check2.showCheckInformation();
        visaCardClient1.showBaseInfo();
        accountClient2.showAccountInfo();
    }

}