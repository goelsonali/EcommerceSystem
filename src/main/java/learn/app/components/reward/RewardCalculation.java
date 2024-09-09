package learn.app.components.reward;

import learn.app.components.model.OrderDetails;
import learn.app.components.model.OrderType;
import learn.app.components.data.CustomerRepository;

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

    public String getRewards() {
        //Evaluate the reward
        return rewardMatrix.rewards(CustomerRepository.getPoints(orderDetails.customerId()));
    }

}
