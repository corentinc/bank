package bzh.greta.bank.router;

import bzh.greta.bank.service.WithdrawService;
import bzh.greta.bank.domain.Account;
import bzh.greta.bank.domain.MenuMode;
import bzh.greta.bank.service.DepositService;

public class MenuRouter {
    private final WithdrawService withdrawService;
    private final DepositService depositService;

    public MenuRouter(WithdrawService withdrawService, DepositService depositService) {
        this.withdrawService = withdrawService;
        this.depositService = depositService;
    }

    public void execute(Account account, MenuMode menuMode) {
        switch (menuMode) {
            case WITHDRAW:
                withdrawService.withdraw(account);
                break;
            case DEPOSIT:
                depositService.depose(account);
                break;
            case VIEW:
                throw new RuntimeException("Not implemented yet");
            default:
                throw new RuntimeException("Choice not supported");
        }
    }
}
