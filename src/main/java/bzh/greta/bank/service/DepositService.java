package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final AccountDao accountDao;

    @Autowired
    public DepositService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void depose(Account account) {
        throw new RuntimeException("Not implemented yet");
    }
}
