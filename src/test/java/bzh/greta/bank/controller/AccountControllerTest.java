package bzh.greta.bank.controller;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.domain.Operation;
import bzh.greta.bank.domain.OperationType;
import bzh.greta.bank.service.AccountCreationService;
import bzh.greta.bank.service.AccountFinderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @MockBean
    private AccountCreationService accountCreationService;

    @MockBean
    private AccountFinderService accountFinderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        // je crée l'instance que le service doit me retourner
        List<Operation> operations = Arrays.asList(new Operation(OperationType.DEPOT, 200));
        Account account = new Account(10, 5000, operations);

        // je dis au mock de me retourner une liste contant l'instance d'Account
        when(accountFinderService.findAll()).thenReturn(Arrays.asList(account));

        mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(10)))
                .andExpect(jsonPath("$[0].balance", is(5000)))
                .andExpect(jsonPath("$[0].operations", hasSize(1)))
                .andExpect(jsonPath("$[0].operations[0].operationType", is(OperationType.DEPOT.name())))
                .andExpect(jsonPath("$[0].operations[0].amount", is(200)));
    }

    @Test
    void createAccount() throws Exception {
        mockMvc.perform(post("/account?balance=90")
        ).andExpect(status().isCreated());

        verify(accountCreationService).createAccount(90);
    }
}