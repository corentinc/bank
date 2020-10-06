package bzh.greta.bank.service;

import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DepositServiceTest {

    @Test
    void depose() {
        AccountFinderService accountFinderService = mock(AccountFinderService.class);
        DepositService depositService = new DepositService(accountFinderService);

        int accountId = 10;
        Account accountMocked = mock(Account.class);
        when(accountFinderService.findAccountById(accountId)).thenReturn(accountMocked);

        depositService.depose(accountId, 500);

        verify(accountMocked).deposit(500);
    }
}