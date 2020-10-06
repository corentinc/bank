package bzh.greta.bank.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private int balance;
    private List<Operation> operations;

    public Account(final int balance) {
        this(balance, new ArrayList<>());
    }

    public Account(int balance, List<Operation> operations) {
        this.balance = balance;
        if (operations == null) {
            operations = new ArrayList<>();
        }
        this.operations = operations;
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

    public List<Operation> getOperations() {
        return operations;
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
