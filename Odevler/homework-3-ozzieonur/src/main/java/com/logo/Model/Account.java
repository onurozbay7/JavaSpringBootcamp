package com.logo.Model;

import com.logo.Model.enums.CurrencyType;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Account {
    static AtomicInteger i = new AtomicInteger(0);

    private int id;
    private String accountName;
    private String accountNumber;
    private String iban;
    private CurrencyType currencyType;
    private int balance;

    public Account(String accountName, String accountNumber, String iban, CurrencyType currencyType, int balance) {
        id = i.incrementAndGet();
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.iban = iban;
        this.currencyType = currencyType;
        this.balance = balance;
    }
}
