package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

class DepositServiceTest {

    @Test
    void depose() {
        AccountDao accountDao = mock(AccountDao.class);
        DepositService depositService = new DepositService(accountDao);

        int accountId = 10;
        Account accountMocked = mock(Account.class);
        when(accountDao.findById(accountId)).thenReturn(accountMocked);

        depositService.depose(accountId, 500);

        InOrder inOrder = inOrder(accountDao, accountMocked);
        inOrder.verify(accountMocked).deposit(500);
        inOrder.verify(accountDao).save(accountMocked);
    }
}