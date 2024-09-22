package learn.app.LoyaltyProgramManagement.components.data;

import learn.app.LoyaltyProgramManagement.components.model.CustomerDetails;
import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.model.OrderType;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;

import java.math.BigDecimal;

public class LoyaltyAppTestData {

    public static OrderDetails createOrder() {
        return new OrderDetails("test_orderId","test_customerId", new BigDecimal("10") );
    }
    public static OrderDetails createOrder(OrderType type) {
        return new OrderDetails("test_orderId","test_customerId", new BigDecimal("10"), type );
    }
    public static CustomerDetails createCustomerDetails() {
        return CustomerDetails.builder().customerId("test_customer_id").loyaltyPoints(10).build();
    }
    public static CustomerDetails createCustomerDetails(RewardType rewardType) {
        return CustomerDetails.builder()
                .customerId("test_customer_id")
                .loyaltyPoints(10)
                .rewardType(rewardType).build();
    }
}
