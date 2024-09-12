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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoyaltyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoyaltyApplication.class, args);
    }
}
