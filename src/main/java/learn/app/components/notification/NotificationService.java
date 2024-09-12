package learn.app.components.notification;

import learn.app.components.model.CustomerDetails;
import learn.app.components.model.RewardType;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyReward(String reward, CustomerDetails customerDetails) {
        System.out.println("Customer " + customerDetails.getCustomerId() + " earned points: " + customerDetails.getLoyaltyPoints());
        if (!reward.equals(RewardType.NO_REWARD.label())) {
            System.out.println("Now you are rewarded with " + reward);
        }
    }


}
