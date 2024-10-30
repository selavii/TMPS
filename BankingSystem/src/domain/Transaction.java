// src/domain/Transaction.java
package domain;

public class Transaction {
    private double amount;
    private String type;
    private Account account;

    public Transaction(double amount, String type, Account account) {
        this.amount = amount;
        this.type = type;
        this.account = account;
    }

    public void execute() {
        if (type.equals("Deposit")) {
            account.deposit(amount);
        } else if (type.equals("Withdrawal")) {
            account.withdraw(amount);
        }
        System.out.println(type + " of " + amount + " completed for " + account.getType());
    }
}
