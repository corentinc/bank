package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final AccountDao accountDao;

    public DepositService(AccountDao accountDao) {
        this.accountDao = accountDao;

    }

    public void depose(int accountId, int amount) {
        Account account = accountDao.findById(accountId);
        account.deposit(amount);
        accountDao.save(account);
    }
}
