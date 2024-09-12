package learn.app.components.reward;

import learn.app.components.model.RewardType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Requirement :
// loyalty points matrix - cost 2 == 1 point
// reward based on points -
//  a. points > 100 and points < 500 = 10% off next purchase.
//  b. points > 500 = 15% off next purchase.
@Component
public class StoreRewardMatrix implements RewardMatrix {
    @Override
    public int loyaltyPoints(BigDecimal totalCost) {
        return totalCost.intValue()/2;
    }

    @Override
    public RewardType rewards(int totalPoints) {
        if(totalPoints > 10 && totalPoints < 50) {
           return RewardType.DISCOUNT_10;
        } else if(totalPoints > 500) {
            return RewardType.DISCOUNT_15;
        } else {
            return RewardType.NO_REWARD;
        }
    }
}
