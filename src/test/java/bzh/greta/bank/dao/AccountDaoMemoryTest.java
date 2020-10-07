package bzh.greta.bank.dao;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.exception.AccountNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class AccountDaoMemoryTest {

    @Test
    void findById() {
        AccountDao accountDao = new AccountDaoMemory();

        Account account = new Account(10, 500, Collections.emptyList());
        accountDao.save(account);

        assertThat(accountDao.findById(10), equalTo(account));
    }

    @Test
    void findAll() {
        AccountDao accountDao = new AccountDaoMemory();

        assertThat(accountDao.findAll(), hasSize(0));

        Account account = new Account(20, 100, Collections.emptyList());
        accountDao.save(account);

        assertThat(accountDao.findAll(), hasSize(1));
        assertThat(accountDao.findAll().get(0), equalTo(account));
    }

    @Test
    void save_thenUpdate() {
        AccountDao accountDao = new AccountDaoMemory();

        accountDao.save(new Account(10, 50, Collections.emptyList()));
        accountDao.save(new Account(10, 100, Collections.emptyList()));

        assertThat(accountDao.findAll(), hasSize(1));
        assertThat(accountDao.findById(10), equalTo(new Account(10, 100, Collections.emptyList())));
    }

    @Test
    void findById_whenNotExists() {
        AccountDao accountDao = new AccountDaoMemory();

        assertThatThrownBy(() -> accountDao.findById(50))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage("Nous n'avons pas trouvé le compte avec l'id 50");

    }
}