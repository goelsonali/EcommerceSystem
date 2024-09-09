package learn.app.components.notification;

import learn.app.components.model.Constants;
import learn.app.components.model.CustomerDetails;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyReward(String reward, CustomerDetails customerDetails) {
        System.out.println("Customer " + customerDetails.customerId() + " earned points: " + customerDetails.loyaltyPoints());
        if (!reward.equals(Constants.NO_REWARDS)) {
            System.out.println("Now you are rewarded with " + reward);
        }
    }


}
