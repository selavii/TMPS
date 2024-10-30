// src/models/TransactionBuilder.java
package models;

import domain.Account;
import domain.Transaction;

public class TransactionBuilder {
    private double amount;
    private String type;
    private Account account;

    public TransactionBuilder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public TransactionBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public TransactionBuilder setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Transaction build() {
        return new Transaction(amount, type, account);
    }
}
