package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


public class AccountCreationServiceTest {

    @Test
    public void createAccount() {
        AccountDao mockDao = mock(AccountDao.class);
        AccountCreationService service = new AccountCreationService(mockDao);
        // todo implementez le test
    }
}