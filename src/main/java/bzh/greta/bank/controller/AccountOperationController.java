package bzh.greta.bank.controller;

import bzh.greta.bank.service.DepositService;
import bzh.greta.bank.service.WithdrawService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/{accountId}")
public class AccountOperationController {
    private final DepositService depositService;
    private final WithdrawService withdrawService;

    public AccountOperationController(DepositService depositService, WithdrawService withdrawService) {
        this.depositService = depositService;
        this.withdrawService = withdrawService;
    }

    /**
     * Dépose de l'argent
     * @param accountId l'identifiant du compte
     * @param amount le montant
     */
    @PostMapping("/depose/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deposit(@PathVariable int accountId, @PathVariable int amount) {
        depositService.depose(accountId, amount);
    }

    /**
     * Retire de l'argent
     * @param accountId l'identifiant du compte
     * @param amount le montant
     */
    @PostMapping("/withdraw/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public void withdraw(@PathVariable int accountId, @PathVariable int amount) {
        withdrawService.withdraw(accountId, amount);
    }
}
