package bzh.greta.bank.controller;

import bzh.greta.bank.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/{accountId}")
public class AccountOperationController {
    private final DepositService depositService;

    public AccountOperationController(DepositService depositService) {
        this.depositService = depositService;
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
    public void withdraw(@PathVariable int accountId, @PathVariable int amount) {
        // todo
    }
}
