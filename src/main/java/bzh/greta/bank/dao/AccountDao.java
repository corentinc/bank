package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;

public interface AccountDao {
    void save(Account account);

    Account findById(int accountId);
}
