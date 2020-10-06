package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;

import java.util.List;

public interface AccountDao {
    void save(Account account);

    List<Account> findAll();

    Account findById(int accountId);
}
