package bzh.greta.bank.controller;

import bzh.greta.bank.service.DepositService;
import bzh.greta.bank.service.WithdrawService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountOperationController.class)
class AccountOperationControllerTest {

    @MockBean
    private DepositService depositService;

    @MockBean
    private WithdrawService withdrawService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deposit() throws Exception {
        mockMvc.perform(post("/account/5/depose/20"))
                .andExpect(status().isCreated());

        verify(depositService).depose(5, 20);
    }

    @Test
    void withdraw() throws Exception {
        mockMvc.perform(post("/account/10/withdraw/50"))
                .andExpect(status().isCreated());

        verify(withdrawService).withdraw(10, 50);
    }
}