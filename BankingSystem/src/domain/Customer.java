// src/domain/Customer.java
package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String id;
    private List<Account> accounts;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
}
