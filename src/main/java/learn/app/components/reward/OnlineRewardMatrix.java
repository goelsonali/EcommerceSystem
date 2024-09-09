package learn.app.components.reward;

import learn.app.components.model.Constants;
import learn.app.components.model.RewardType;

import java.math.BigDecimal;

// Requirement :
// loyalty points matrix - cost 5 == 1 point
// reward based on points -
//  a. points > 100 and points < 500 = 5% off next purchase.
//  b. points > 500 and points < 1000 = 10% off next purchase.
//  c. points > 1000 = 15% off next purchase.
public class OnlineRewardMatrix implements RewardMatrix {
    @Override
    public int loyaltyPoints(BigDecimal totalCost) {
        // every 5 unit equivalent to 1 point
        return totalCost.intValue()/5;
    }

    @Override
    public String rewards(int totalPoints) {
        if(totalPoints > 10 && totalPoints < 50) {
            return RewardType.DISCOUNT_5.label();
        } else if(totalPoints > 500 && totalPoints < 1000) {
            return RewardType.DISCOUNT_10.label();
        } else if(totalPoints > 1000) {
            return RewardType.DISCOUNT_15.label();
        } else {
            return Constants.NO_REWARDS;
        }
    }
}
