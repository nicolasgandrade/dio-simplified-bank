import entities.AccountImpl;
import entities.Bank;
import entities.CheckingAccount;
import entities.Customer;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("City Bank", 1);
        Customer customer = new Customer("Nicolas");
        AccountImpl account = new CheckingAccount(customer);

        Customer customer2 = new Customer("Maria");
        AccountImpl account2 = new CheckingAccount(customer2);

        System.out.println("Starting operations:");
        System.out.println();

        System.out.println("New checking account created!");
        System.out.println("Owner: " + account.getOwner().getName());
        System.out.println("Current balance: $" + account.getBalance());

        System.out.println("Type the values you want now:");
        System.out.println("Value to be deposited (X.XX): ");
        String value = sc.next();
        sc.nextLine();
        System.out.println("Depositing new amount of $" + value);
        account.deposit(new BigDecimal(value));

        System.out.println("Do yo want to make a new deposit? (y/n)");
        String opt = sc.nextLine();
        while (opt.equals("y") | opt.equals("Y")) {
            System.out.println("Value to be deposited (X.XX): ");
            String valueNewDeposit = sc.next();
            sc.nextLine();
            account.deposit(new BigDecimal(valueNewDeposit));
            System.out.println("$" + valueNewDeposit + "deposited");

            System.out.println("Do yo want to make a new deposit? (y/n)");
            opt = sc.next();
            sc.nextLine();
        }

        account.printBalance();

        System.out.println("Withdraw a value now");
        System.out.println("Value:");
        String withdraw = sc.next();
        sc.nextLine();
        account.withdraw(new BigDecimal(withdraw));

        account.printBalance();
        System.out.println();

        System.out.println("You can also transfer money to other account, let's try it now");
        System.out.println("Type the value to be transfer: ");
        String valueTransfer = sc.next();
        sc.nextLine();

        account.transfer(account2, new BigDecimal(valueTransfer));

        account.printBalance();
        account2.printBalance();
    }
}
