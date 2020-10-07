package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.exception.AccountNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class AccountDaoMemory implements AccountDao {
    private final Map<Integer, Account> accountMap = new HashMap<>();

    @Override
    public void save(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountMap.values());
    }

    @Override
    public Account findById(int accountId) {
        Account account = accountMap.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }
        return account;
    }
}
