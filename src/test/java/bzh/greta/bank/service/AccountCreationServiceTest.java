package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class AccountCreationServiceTest {

    @Test
    public void createAccount() {
        AccountDao mockDao = mock(AccountDao.class);

        AccountCreationService service = new AccountCreationService(mockDao);

        Account sentAccount = new Account(10);

        Account createdAccount = service.createAccount(sentAccount);

        assertThat(createdAccount, equalTo(sentAccount));

        verify(mockDao).save(createdAccount);
    }
}