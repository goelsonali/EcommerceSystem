package learn.app.components.model;

import java.math.BigDecimal;

public record OrderDetails(String orderId, String customerId, BigDecimal orderCost, OrderType orderType) {}
