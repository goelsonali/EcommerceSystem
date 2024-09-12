package learn.app.components.service;

import learn.app.components.model.OrderDetails;
import learn.app.components.model.RewardType;
import learn.app.components.notification.NotificationService;
import learn.app.components.reward.RewardCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramService {

    private RewardCalculation rewardCalculation;
    private CustomerService customerService;
    private NotificationService notificationService;


    @Autowired
    public LoyaltyProgramService(CustomerService customerService, NotificationService notificationService) {
        this.customerService = customerService;
        this.notificationService = notificationService;
    }

    public String processOrder(OrderDetails order) {
        this.rewardCalculation = new RewardCalculation(order);
        //1. Step 1 Calculate the points
        int points = rewardCalculation.calculatePoints();
        RewardType reward = rewardCalculation.applyReward();
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
