package learn.app.components.service;

import learn.app.components.model.OrderDetails;
import learn.app.components.notification.NotificationService;
import learn.app.components.reward.RewardCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramService {

    private final RewardCalculation rewardCalculation;
    private final CustomerService customerService;
    private final NotificationService notificationService;


    @Autowired
    public LoyaltyProgramService(RewardCalculation rewardCalculation, CustomerService customerService, NotificationService notificationService) {
        this.rewardCalculation = rewardCalculation;
        this.customerService = customerService;
        this.notificationService = notificationService;
    }

    public void processOrder(OrderDetails order) {
        //1. Step 1 Calculate points
        int points = rewardCalculation.calculatePoints();
        //2. Step 2 Add to customer profile
        customerService.addPointsToCustomer(order.customerId(), points);
        //3. Step 3 Get reward and notify customer
        String reward = rewardCalculation.getRewards();
        notificationService.notifyReward(reward, customerService.getCustomer(order.customerId()));
    }
}
