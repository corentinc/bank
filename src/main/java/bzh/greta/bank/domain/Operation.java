package bzh.greta.bank.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    private int amount;

    public Operation(OperationType operationType, int amount) {
        this.operationType = operationType;
        this.amount = amount;
    }
}
