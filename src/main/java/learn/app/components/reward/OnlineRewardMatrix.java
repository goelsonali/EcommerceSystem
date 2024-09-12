package learn.app.components.reward;

import learn.app.components.model.RewardType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Requirement :
// loyalty points matrix - cost 5 == 1 point
// reward based on points -
//  a. points > 100 and points < 500 = 5% off next purchase.
//  b. points > 500 and points < 1000 = 10% off next purchase.
//  c. points > 1000 = 15% off next purchase.
@Component
public class OnlineRewardMatrix implements RewardMatrix {
    @Override
    public int loyaltyPoints(BigDecimal totalCost) {
        // every 5 unit equivalent to 1 point
        return totalCost.intValue()/5;
    }

    @Override
    public RewardType rewards(int totalPoints) {
        if(totalPoints > 10 && totalPoints < 50) {
            return RewardType.DISCOUNT_5;
        } else if(totalPoints > 100 && totalPoints < 1000) {
            return RewardType.DISCOUNT_10;
        } else if(totalPoints > 1000) {
            return RewardType.DISCOUNT_15;
        } else {
            return RewardType.NO_REWARD;
        }
    }
}
