package entities;

import java.math.BigDecimal;

public interface Account {
    void withdraw(BigDecimal value);
    void deposit(BigDecimal value);
    void transfer(AccountImpl target, BigDecimal value);
    void printBalance();
}
