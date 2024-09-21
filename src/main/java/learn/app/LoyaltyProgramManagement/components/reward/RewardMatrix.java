package learn.app.LoyaltyProgramManagement.components.reward;

import learn.app.LoyaltyProgramManagement.components.model.RewardType;

import java.math.BigDecimal;

public interface RewardMatrix {
    int loyaltyPoints(BigDecimal totalCost);
    RewardType rewards(int totalPoints);

}
