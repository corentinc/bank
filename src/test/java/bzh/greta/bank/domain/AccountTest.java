package bzh.greta.bank.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void getBalance() {
        Account account = new Account(1000);
        assertEquals(account.getBalance(), 1000);
    }
}