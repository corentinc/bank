package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
    private final AccountDao accountDao;

    public WithdrawService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void withdraw(int accountId, int amount) {
        Account account = accountDao.findById(accountId);
        account.withdraw(amount);
        accountDao.save(account);
    }
}
