package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class AccountCreationServiceTest {

    @Test
    public void createAccount() {
        AccountDao mockDao = mock(AccountDao.class);
        AccountCreationService service = new AccountCreationService(mockDao);

        when(mockDao.findAll()).thenReturn(Arrays.asList(
                mock(Account.class),
                mock(Account.class),
                mock(Account.class)
        ));

        Account createdAccount = service.createAccount(500);

        assertEquals(createdAccount, new Account(3, 500));
        verify(mockDao).save(createdAccount);
    }
}