package bzh.greta.bank.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // indique à JPA que cette classe map une table en BDD
@Data // lombok - ajoute getters/setters, toString(), equals(), hashCode()
@AllArgsConstructor // lombok - crée un constructeur avec tous les champs de la classe
@NoArgsConstructor // lombok - crée un constructeur sans parametres
@Builder
@Getter
public class Account {
    @Id // indique que le champ 'id' est la Primary Key de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // va être auto-incrémenté
    private int id;
    private int balance;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Operation> operations = new ArrayList<>();

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(int amount) {
        operations.add(new Operation(OperationType.DEPOT, amount));
        balance += amount;
    }

    public void withdraw(int amount) {
        operations.add(new Operation(OperationType.RETRAIT, amount));
        balance -= amount;
    }
}
