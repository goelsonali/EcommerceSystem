package learn.app;

//Loalty Program - - A loyalty program where customers earn points for purchases. Implement a system to track customer purchases and reward points.
//- **Exercise:** Develop a Java application that:
//    - Tracks customer purchases.
//       - OrderId and Cost of the order ( input)
//    - Calculates and updates loyalty points based on purchase value.
//          ** POINTS CALCULATION SERVICE **
//         - Point System Matrix ( to refer or to be created ?)
//         - Maintain/Retrieve a customer loyalty points existing data ( a data storage - in this sample example it can be a MAP)
//         - Calculate the new loyalty points for this purchase.
//         - Add/update the loyalty points for the customer.
//    - Notifies customers when they reach a point threshold for a reward (e.g., £10 off their next purchase).
//          ** REWARD NOTIFICATION SERVICE **
//          - After every update to the customer loyalty points check for the reward notification.
//          - Matrix for the reward notification to be set-up/fetched from the data store.
//          - Perform the check if loyalty points passed threshold -> notify the reward message.

import java.math.BigDecimal;
import learn.app.components.data.CustomerRepository;
import learn.app.components.data.PurchaseDetails;
import learn.app.components.model.OrderDetails;
import learn.app.components.model.OrderType;
import learn.app.components.notification.NotificationService;
import learn.app.components.reward.RewardCalculation;
import learn.app.components.service.CustomerService;
import learn.app.components.service.LoyaltyProgramService;

public class Main {
    public static void main(String[] args) {
        OrderDetails order_1 = new OrderDetails("101", "CUST01", new BigDecimal(24), OrderType.STORE);
        OrderDetails order_2 = new OrderDetails("102", "CUST02", new BigDecimal(30), OrderType.ONLINE);
        OrderDetails order_3 = new OrderDetails("103", "CUST01", new BigDecimal(30), OrderType.ONLINE);
        //Place the order

        PurchaseDetails.addOrderDetails(order_2);
        PurchaseDetails.addOrderDetails(order_3);

        PurchaseDetails.addOrderDetails(order_1);
        displayMessage("----Order no-1 placed----");
        displayLoyaltyPointsMessage("before", order_1);
        LoyaltyProgramService loyaltyService_order1 = new LoyaltyProgramService(new RewardCalculation(order_1),new CustomerService(), new NotificationService());
        loyaltyService_order1.processOrder(order_1);


        PurchaseDetails.addOrderDetails(order_2);
        displayMessage("-----Order no- 2 placed----");
        displayLoyaltyPointsMessage("before", order_2);
        LoyaltyProgramService loyaltyService_order2 = new LoyaltyProgramService(new RewardCalculation(order_2),new CustomerService(), new NotificationService());
        loyaltyService_order2.processOrder(order_2);

        PurchaseDetails.addOrderDetails(order_3);
        displayMessage("-----Order no- 3 placed----");
        displayLoyaltyPointsMessage("before", order_3);
        LoyaltyProgramService loyaltyService_order3 = new LoyaltyProgramService(new RewardCalculation(order_1),new CustomerService(), new NotificationService());
        loyaltyService_order3.processOrder(order_1);
    }

    private static void displayMessage(String message) {
        System.out.println(message);
    }

    private static void displayLoyaltyPointsMessage(String when, OrderDetails orderPlaced) {
        System.out.printf("Loyalty points for the customer with id - %s %s order is placed - points: %d%n",
                orderPlaced.customerId(), when, CustomerRepository.getPoints(orderPlaced.customerId()));
    }
}