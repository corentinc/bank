package bzh.greta.bank.domain;

public class Operation {
    private OperationType operationType;
    private int amount;

    public Operation(OperationType operationType, int amount) {
        this.operationType = operationType;
        this.amount = amount;
    }
}
