package learn.app.components.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import learn.app.components.model.OrderDetails;

public class PurchaseDetails {

    static Map<String, OrderDetails> orderByCost = new ConcurrentHashMap<>();
    public static Map<String, OrderDetails> getOrderDetails() {
        return orderByCost;
    }

    public static void addOrderDetails(OrderDetails orderDetails) {
        orderByCost.put(orderDetails.orderId(), orderDetails);
    }

}
