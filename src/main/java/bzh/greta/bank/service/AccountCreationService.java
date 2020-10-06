package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationService {
    private final AccountDao accountDao;

    public AccountCreationService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * Create an account
     *
     * @return return the account created
     */
    public Account createAccount(Account account) {
        accountDao.save(account);
        return account;
    }
}
