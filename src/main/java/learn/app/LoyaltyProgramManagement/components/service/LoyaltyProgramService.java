package learn.app.LoyaltyProgramManagement.components.service;

import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;
import learn.app.LoyaltyProgramManagement.components.notification.NotificationService;
import learn.app.LoyaltyProgramManagement.components.reward.RewardCalculation;
import learn.app.LoyaltyProgramManagement.exception.InvalidOrderException;
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
        try{
            int points = rewardCalculation.calculatePoints(order);
            RewardType reward = rewardCalculation.applyReward(order);
            //2. Step 2 Add to customer profile
            customerService.addPointsToCustomer(order.customerId(), points);
            customerService.addCustomerRewards(order.customerId(), reward);
            return "Order processed successfully";
        } catch (RuntimeException exception) {
            throw new InvalidOrderException("Invalid Order");
        }
    }

    public int getPoints(String customerId) {
        if (customerService.getCustomer(customerId) != null) {
            return customerService.getCustomerPoints(customerId);
        } else {
            return 0;
        }
    }

    public String getRewards(String customerId) {
        if (customerService.getCustomer(customerId) != null) {
            return customerService.getCustomer(customerId).getRewardType().label();
        } else {
            return "Customer not valid";
        }

    }
}
