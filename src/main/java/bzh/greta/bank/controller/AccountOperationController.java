package bzh.greta.bank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/{accountId}")
public class AccountOperationController {
    // todo Quelles dépendances ? On crée un nouveau service ? :)

    /**
     * Dépose de l'argent
     * @param accountId l'identifiant du compte
     * @param amount le montant
     */
    @PostMapping("/depose/{amount}")
    public void deposit(@PathVariable int accountId, @PathVariable int amount) {
        // todo
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
