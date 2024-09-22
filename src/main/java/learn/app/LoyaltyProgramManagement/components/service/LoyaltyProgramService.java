package learn.app.LoyaltyProgramManagement.components.service;

import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;
import learn.app.LoyaltyProgramManagement.components.notification.NotificationService;
import learn.app.LoyaltyProgramManagement.components.reward.RewardCalculation;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramService {

    private final RewardCalculation rewardCalculation;
    private final CustomerService customerService;
    private final NotificationService notificationService;

    public LoyaltyProgramService(CustomerService customerService, NotificationService notificationService, RewardCalculation rewardCalculation) {
        this.customerService = customerService;
        this.notificationService = notificationService;
        this.rewardCalculation = rewardCalculation;
    }

    public String processOrder(OrderDetails order) {
        //1. Step 1 Calculate the points
        int points = rewardCalculation.calculatePoints(order);
        RewardType reward = rewardCalculation.applyReward(order);
        //2. Step 2 Add to customer profile
        customerService.addPointsToCustomer(order.customerId(), points);
        customerService.addCustomerRewards(order.customerId(), reward);
        return "Order processed successfully";
    }

    public int getPoints(String customerId) {
        return customerService.getCustomerPoints(customerId);
    }

    public String getRewards(String customerId) {
        return customerService.getCustomer(customerId).getRewardType().label();
    }
}
