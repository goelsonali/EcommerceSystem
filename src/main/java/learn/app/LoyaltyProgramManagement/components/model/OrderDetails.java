package learn.app.LoyaltyProgramManagement.components.model;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record OrderDetails(
        @NotBlank
        String orderId,
        @NotBlank
        String customerId,
        @NotBlank
        BigDecimal orderCost,
        OrderType orderType)  {
        public OrderDetails(String orderId, String customerId, BigDecimal orderCost) {
            this(orderId, customerId, orderCost, OrderType.ONLINE);
        }
}
