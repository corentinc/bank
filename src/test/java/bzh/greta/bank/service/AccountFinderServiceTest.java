package bzh.greta.bank.service;

import bzh.greta.bank.dao.AccountDao;
import bzh.greta.bank.domain.Account;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountFinderServiceTest {

    @Test
    public void findAccountById() {
        // je crée mon mock
        AccountDao accountDao = mock(AccountDao.class);
        // j'instancie la classe que je veux tester en lui passant sa dépendance mockée
        AccountFinderService accountFinderService = new AccountFinderService(accountDao);
        // je simule le comportement du mock
        // quand j'appelle la méthode .findById(15), il me retourne expectedAccount
        when(accountDao.findById(15)).thenReturn(new Account(15, 5000));
        // je m'assure que le service me retourne ce que lui renvoie le DAO
        assertThat(new Account(15, 5000), equalTo(accountFinderService.findAccountById(15)));
    }
}