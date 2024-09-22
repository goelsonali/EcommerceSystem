package learn.app.LoyaltyProgramManagement.components.reward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import learn.app.LoyaltyProgramManagement.components.data.CustomerRepository;
import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.model.OrderType;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;
import org.springframework.stereotype.Component;

@Component
public class RewardCalculation {
    Map<OrderType, RewardMatrix> orderTypeByReward;

    public RewardCalculation(List<RewardMatrix> rewardMatrixList) {
        this.orderTypeByReward = new HashMap<>();
        for (RewardMatrix rewardMatrix : rewardMatrixList ) {
            if(rewardMatrix instanceof OnlineRewardMatrix) {
                orderTypeByReward.put(OrderType.ONLINE, rewardMatrix);
            } else if(rewardMatrix instanceof StoreRewardMatrix){
                orderTypeByReward.put(OrderType.STORE, rewardMatrix);
            }
        }
    }

    //Get the purchase details for a customer and then calculate it rewards points and return back.
    public int calculatePoints(OrderDetails orderDetails) {
        //Calculate points for this order cost based on type
        RewardMatrix rewardMatrix = orderTypeByReward.get(orderDetails.orderType());
        return rewardMatrix.loyaltyPoints(orderDetails.orderCost());
    }

    public RewardType applyReward(OrderDetails orderDetails) {
        //Evaluate the reward
        RewardMatrix rewardMatrix = orderTypeByReward.get(orderDetails.orderType());
        return rewardMatrix.rewards(CustomerRepository.getPoints(orderDetails.customerId()));
    }

}
