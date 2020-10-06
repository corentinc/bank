package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class AccountDaoMemory implements AccountDao {
    private final List<Account> accountList = new ArrayList<>();

    @Override
    public void save(Account account) {
        accountList.add(account);
    }

    @Override
    public List<Account> findAll() {
        return accountList;
    }

    @Override
    public Account findById(int accountId) {
        throw new RuntimeException("Not implemented yet");
    }
}
