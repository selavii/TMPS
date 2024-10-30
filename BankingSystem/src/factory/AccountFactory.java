// src/factory/AccountFactory.java
package factory;

import domain.Account;
import domain.CheckingAccount;
import domain.SavingsAccount;

public class AccountFactory {
    public static Account createAccount(String accountType) {
        switch (accountType) {
            case "Checking":
                return new CheckingAccount();
            case "Savings":
                return new SavingsAccount();
            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }
}
