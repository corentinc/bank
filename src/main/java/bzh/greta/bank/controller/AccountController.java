package bzh.greta.bank.controller;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.service.AccountCreationService;
import bzh.greta.bank.service.AccountFinderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountCreationService accountCreationService;
    private final AccountFinderService accountFinderService;

    public AccountController(AccountCreationService accountCreationService, AccountFinderService accountFinderService) {
        this.accountCreationService = accountCreationService;
        this.accountFinderService = accountFinderService;
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody Account accountToCreate) {
        accountCreationService.createAccount(accountToCreate);
    }

    @GetMapping(value = "/account")
    public List<Account> findAll() {
        return accountFinderService.findAll();
    }
    
}
