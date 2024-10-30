// src/domain/Account.java
package domain;

public abstract class Account {
    private double balance;

    public abstract String getType();

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
