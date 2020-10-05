package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDaoDb;
import bzh.greta.bank.domain.Account;


public class AccountCreationService {
    private final AccountDaoDb accountDao;

    public AccountCreationService(AccountDaoDb accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * Create an account
     *
     * @return return the account created
     */
    public Account createAccount(int initialBalance) {
        Account account = new Account(initialBalance);
        accountDao.save(account);
        return account;
    }
}
