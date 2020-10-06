package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountFinderService {
    private final AccountDao accountDao;

    public AccountFinderService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(final int accountId) {
        return accountDao.findById(accountId);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
