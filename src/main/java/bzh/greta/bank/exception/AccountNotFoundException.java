package bzh.greta.bank.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int accountId) {
        super("Nous n'avons pas trouvé le compte avec l'id " + accountId);
    }
}
