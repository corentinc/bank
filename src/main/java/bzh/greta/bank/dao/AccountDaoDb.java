package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoDb implements AccountDao {
    public void save(Account account) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(int accountId) {
        throw new RuntimeException("Not implemented yet");
    }
}
