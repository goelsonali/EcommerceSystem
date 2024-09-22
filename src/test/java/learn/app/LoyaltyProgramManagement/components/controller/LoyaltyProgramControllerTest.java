package learn.app.LoyaltyProgramManagement.components.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import learn.app.LoyaltyProgramManagement.components.service.LoyaltyProgramService;
import learn.app.LoyaltyProgramManagement.exception.InvalidOrderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(LoyaltyProgramController.class)
public class LoyaltyProgramControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean
    private LoyaltyProgramService mockLoyaltyService;

    private String orderDetailsJson;

    @BeforeEach
    void setup() {
    this.orderDetailsJson =
        "{ \"orderId\": \"12345\", \"customerId\": \"cust_101\", \"orderCost\": 20}";
    }

    //For process order api
    @Test
    void testInternalServerErrorProcessOrder() throws Exception {
    when(mockLoyaltyService.processOrder(any()))
        .thenThrow(new InvalidOrderException("Invalid Order"));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/process-order")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testOkResponseProcessOrder() throws Exception{
        when(mockLoyaltyService.processOrder(any())).thenReturn("Order processed successfully");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/process-order")
                        .contentType(APPLICATION_JSON)
                        .content(orderDetailsJson))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Order processed successfully"));
    }

    @Test
    void testGetPoints() throws Exception {
        String customerId = "12345";
        int expectedPoints = 10;
        when(mockLoyaltyService.getPoints(any())).thenReturn(expectedPoints);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/customers/{customerId}/points", customerId)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedPoints)));
    }

    @Test
    void testGetRewards() throws Exception{
        String customerId = "12345";
        String expectedReward = "Reward_Test";
        when(mockLoyaltyService.getRewards(any())).thenReturn("Reward_Test");

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/{customerId}/rewards", customerId)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedReward));
    }
}
