package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;

public class DepositService {
    private final AccountDao accountDao;

    public DepositService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void depose(Account account) {
        throw new RuntimeException("Not implemented yet");
    }
}
