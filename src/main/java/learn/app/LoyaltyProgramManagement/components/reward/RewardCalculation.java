package learn.app.LoyaltyProgramManagement.components.reward;

import learn.app.LoyaltyProgramManagement.components.data.CustomerRepository;
import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.model.OrderType;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;

public class RewardCalculation {

    OrderDetails orderDetails;
    RewardMatrix rewardMatrix;

    public RewardCalculation(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        if (OrderType.ONLINE.equals(orderDetails.orderType())) {
            rewardMatrix = new OnlineRewardMatrix();
        } else {
            rewardMatrix = new StoreRewardMatrix();
        }
    }

    //Get the purchase details for a customer and then calculate it rewards points and return back.
    public int calculatePoints() {
        //Calculate points for this order cost based on type
        return rewardMatrix.loyaltyPoints(orderDetails.orderCost());
    }

    public RewardType applyReward() {
        //Evaluate the reward
        return rewardMatrix.rewards(CustomerRepository.getPoints(orderDetails.customerId()));
    }

}
