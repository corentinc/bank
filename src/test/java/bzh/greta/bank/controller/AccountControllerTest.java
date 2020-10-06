package bzh.greta.bank.controller;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.service.AccountCreationService;
import bzh.greta.bank.service.AccountFinderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @MockBean
    private AccountCreationService accountCreationService;

    @MockBean
    private AccountFinderService accountFinderService;

    @Autowired
    private MockMvc mockMvc;

    // Sert à transformer json -> java puis java -> json
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        when(accountFinderService.findAll()).thenReturn(Arrays.asList(
           new Account(10)
        ));

        mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].balance", is(10)));
    }

    @Test
    void createAccount() throws Exception {
        // transform l'instance d'Account en json, donc en String
        String json = objectMapper.writeValueAsString(new Account(90));
        mockMvc.perform(post("/account")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        verify(accountCreationService).createAccount(new Account(90));
    }
}