package learn.app.components.reward;

import learn.app.components.model.RewardType;

import java.math.BigDecimal;

public interface RewardMatrix {
    public int loyaltyPoints(BigDecimal totalCost);
    public RewardType rewards(int totalPoints);

}
