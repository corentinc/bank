package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDaoDb;
import bzh.greta.bank.domain.Account;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class AccountCreationServiceTest {

    @Test
    public void createAccount() {
        AccountDaoDb mockDao = mock(AccountDaoDb.class);

        AccountCreationService service = new AccountCreationService(mockDao);

        Account account = service.createAccount(10);

        assertThat(account.getBalance(), equalTo(10));

        verify(mockDao).save(account);
    }
}