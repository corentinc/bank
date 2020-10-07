package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class AccountCreationServiceTest {

    @Test
    public void createAccount() {
        AccountDao mockDao = mock(AccountDao.class);
        AccountCreationService service = new AccountCreationService(mockDao);

        Account createdAccount = service.createAccount(500);


        assertEquals(createdAccount, Account.builder()
                .balance(500)
                .build()
        );
        verify(mockDao).save(createdAccount);
    }
}