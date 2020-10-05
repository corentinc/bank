package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;

/**
 * Responsable de persister les instances en DB
 */
public class AccountDaoDb implements AccountDao {
    public void save(Account account) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Account findById(int accountId) {
        throw new RuntimeException("Not implemented yet");
    }
}
