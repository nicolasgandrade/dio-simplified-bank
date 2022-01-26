package entities;

import java.math.BigDecimal;

/**
 * Class that implements all the features of an Account.
 */
public abstract class AccountImpl implements Account{

    private static final int AGENCY = 1;
    private static int ACCOUNT_NUMBER = 1;

    private int agency;
    private int accountNumber;
    private Customer owner;
    private BigDecimal balance = new BigDecimal("0.00");

    public AccountImpl(Customer customer) {
        this.agency = AGENCY;
        this.accountNumber = ACCOUNT_NUMBER++;
        this.owner = customer;
    }

    public Customer getOwner() {
        return owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Method that receives a value as a param and withdraw this
     * value from the current account.
     * @param value
     */
    @Override
    public void withdraw(BigDecimal value) {
        this.balance = getBalance().subtract(value);
    }

    /**
     * Method that receives a value as a param, and add this
     * value to the current account.
     * @param value
     */
    @Override
    public void deposit(BigDecimal value) {
        this.balance = getBalance().add(value);
    }

    /**
     * Method that remove money from an account, and deposit that
     * money to other account.
     * @param target
     * @param value
     */
    @Override
    public void transfer(AccountImpl target, BigDecimal value) {
        try {
            this.balance = getBalance().subtract(value);
            target.balance = target.getBalance().add(value);
        } catch (Exception e) {
            System.out.println("An error occurred during the operation :" + e.getMessage());
        }
    }

    /**
     * Method to print the current balance of an account.
     */
    @Override
    public void printBalance() {
        System.out.println("===== Current Balance =====");
        System.out.println("Owner: " + getOwner().getName());
        System.out.println("Total: " + getBalance());
        System.out.println("===========================");
    }
}
