package learn.app.components.reward;

import learn.app.components.model.Constants;
import learn.app.components.model.RewardType;

import java.math.BigDecimal;

// Requirement :
// loyalty points matrix - cost 2 == 1 point
// reward based on points -
//  a. points > 100 and points < 500 = 10% off next purchase.
//  b. points > 500 = 15% off next purchase.
public class StoreRewardMatrix implements RewardMatrix {
    @Override
    public int loyaltyPoints(BigDecimal totalCost) {
        return totalCost.intValue()/2;
    }

    @Override
    public String rewards(int totalPoints) {
        if(totalPoints > 10 && totalPoints < 50) {
           return RewardType.DISCOUNT_10.label();
        } else if(totalPoints > 500) {
            return RewardType.DISCOUNT_15.label();
        } else {
            return Constants.NO_REWARDS;
        }
    }
}
