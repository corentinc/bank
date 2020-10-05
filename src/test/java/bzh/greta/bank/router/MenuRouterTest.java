package bzh.greta.bank.router;

import bzh.greta.bank.service.WithdrawService;
import bzh.greta.bank.domain.Account;
import bzh.greta.bank.domain.MenuMode;
import bzh.greta.bank.service.DepositService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuRouterTest {
    private final WithdrawService withdrawService = mock(WithdrawService.class);
    private final DepositService depositService = mock(DepositService.class);
    private final MenuRouter menuRouter = new MenuRouter(withdrawService, depositService);
    private final Account accountMocked = mock(Account.class);

    @Test
    public void execute_whenWithdrawMode() {
        menuRouter.execute(accountMocked, MenuMode.WITHDRAW);
        verify(withdrawService).withdraw(accountMocked);
    }

    @Test
    public void execute_whenDepositMode() {
        menuRouter.execute(accountMocked, MenuMode.DEPOSIT);
        verify(depositService).depose(accountMocked);
    }
}