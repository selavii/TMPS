// src/client/Main.java
package client;

import domain.*;
import factory.AccountFactory;
import models.TransactionBuilder;

public class Main {
    public static void main(String[] args) {
        // Initialize singleton bank instance
        Bank bank = Bank.getInstance();

        // Create customer
        Customer customer = new Customer("John Doe", "123456789");

        // Create accounts using Factory
        Account savings = AccountFactory.createAccount("Savings");
        Account checking = AccountFactory.createAccount("Checking");

        // Assign accounts to customer
        customer.addAccount(savings);
        customer.addAccount(checking);

        // Add customer to bank
        bank.addCustomer(customer);

        // Create a transaction using Builder
        Transaction depositTransaction = new TransactionBuilder()
            .setAmount(500)
            .setType("Deposit")
            .setAccount(savings)
            .build();

        // Execute transaction
        depositTransaction.execute();

        System.out.println("Transaction completed for customer: " + customer.getName());
    }
}
