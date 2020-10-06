package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final AccountFinderService accountFinderService;

    public DepositService(AccountFinderService accountFinderService) {
        this.accountFinderService = accountFinderService;
    }

    public void depose(int accountId, int amount) {
        Account account = accountFinderService.findAccountById(accountId);
        account.deposit(amount);
    }
}
