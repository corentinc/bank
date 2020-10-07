package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class AccountDaoDb implements AccountDao {
    private final AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int accountId) {
        return accountRepository.getOne(accountId);
    }
}
