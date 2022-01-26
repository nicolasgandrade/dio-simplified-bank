package entities;


import java.math.BigDecimal;
import java.util.List;

public class Bank {

    private String name;
    private int agencyNumber;
    private List<Customer> customers;
    private List<CheckingAccount> checkingAccounts;
    private BigDecimal amount;

    public Bank(String name, int agencyNumber) {
        this.name = name;
        this.agencyNumber = agencyNumber;
    }
}
