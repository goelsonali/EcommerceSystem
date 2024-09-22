package learn.app.LoyaltyProgramManagement.components.service;

import static learn.app.LoyaltyProgramManagement.components.data.LoyaltyAppTestData.createCustomerDetails;
import static learn.app.LoyaltyProgramManagement.components.data.LoyaltyAppTestData.createOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import learn.app.LoyaltyProgramManagement.components.model.CustomerDetails;
import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;
import learn.app.LoyaltyProgramManagement.components.notification.NotificationService;
import learn.app.LoyaltyProgramManagement.components.reward.RewardCalculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoyaltyProgramServiceTest {
    
    @Mock
    private RewardCalculation rewardCalculation;
    @Mock
    private CustomerService customerService;

    @Mock
    private NotificationService notificationService;
    
    @InjectMocks
    LoyaltyProgramService serviceToTest;
    
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessOrder() {
        OrderDetails orderDetails = createOrder();
        var expectedResult = "Order processed successfully";
        when(rewardCalculation.calculatePoints(any())).thenReturn(10);
        when(rewardCalculation.applyReward(any())).thenReturn(RewardType.NO_REWARD);

        String result = serviceToTest.processOrder(orderDetails);
        assertEquals(expectedResult, result);
    }
    
    @Test
    void testLoyaltyPointsWhenCustomerExists() {
        CustomerDetails customer = createCustomerDetails();
        when(customerService.getCustomer(anyString())).thenReturn(customer);
        when(customerService.getCustomerPoints(anyString())).thenReturn(customer.getLoyaltyPoints());
        int result = serviceToTest.getPoints(customer.getCustomerId());
        assertEquals(customer.getLoyaltyPoints(),result);
    }

    @Test
    void testLoyaltyPointsWhenCustomerNotExists() {
        CustomerDetails customer = createCustomerDetails();
        when(customerService.getCustomer(anyString())).thenReturn(null);
        int result = serviceToTest.getPoints(customer.getCustomerId());
        assertEquals(0,result);
    }
    
    @Test 
    void testRewardWhenCustomerExists() {
        CustomerDetails customer = createCustomerDetails(RewardType.DISCOUNT_5);
        when(customerService.getCustomer(anyString())).thenReturn(customer);
        String resultReward = serviceToTest.getRewards(customer.getCustomerId());
        assertEquals(RewardType.DISCOUNT_5.label(), resultReward);
    }

    @Test
    void testRewardWhenCustomerNotExists() {
        String expectedResult = "Customer not valid";
        when(customerService.getCustomer(anyString())).thenReturn(null);
        String resultReward = serviceToTest.getRewards(createCustomerDetails().getCustomerId());
        assertEquals(expectedResult, resultReward);
    }
}
