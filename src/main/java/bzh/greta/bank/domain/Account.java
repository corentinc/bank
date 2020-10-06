package bzh.greta.bank.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private int id;
    private int balance;
    private List<Operation> operations;

    public Account(int id, int balance) {
        this(id, balance, new ArrayList<>());
    }

    public Account(int id, int balance, List<Operation> operations) {
        this.id = id;
        this.balance = balance;
        this.operations = operations;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        operations.add(new Operation(OperationType.DEPOT, amount));
        balance += amount;
    }

    public void withdraw(int amount) {
        operations.add(new Operation(OperationType.RETRAIT, amount));
        balance -= amount;
    }


    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                balance == account.balance &&
                Objects.equals(operations, account.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, operations);
    }
}
