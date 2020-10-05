package bzh.greta.bank.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Account {
    private int balance;
    private ArrayList<Operation> operations;

    public Account(final int solde) {
        operations = new ArrayList<>();
        this.balance = solde;
    }

    public void deposit(int amount) {
        operations.add(new Operation(OperationType.DEPOT, amount));
        balance += amount;
    }

    public void withdraw(int amount) {
        operations.add(new Operation(OperationType.RETRAIT, amount));
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account otherAccount = (Account) o;
        return balance == otherAccount.balance &&
                Objects.equals(operations, otherAccount.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, operations);
    }
}
