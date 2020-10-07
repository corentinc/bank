package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WithdrawServiceTest {

    @Test
    void withdraw() {
        AccountDao accountDao = mock(AccountDao.class);
        WithdrawService withdrawService = new WithdrawService(accountDao);

        Account accountMocked = mock(Account.class);
        when(accountDao.findById(5)).thenReturn(accountMocked);

        withdrawService.withdraw(5, 100);

        InOrder inOrder = Mockito.inOrder(accountDao, accountMocked);
        inOrder.verify(accountMocked).withdraw(100);
        inOrder.verify(accountDao).save(accountMocked);
    }
}