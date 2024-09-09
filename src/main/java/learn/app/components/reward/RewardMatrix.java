package learn.app.components.reward;

import java.math.BigDecimal;

public interface RewardMatrix {
    public int loyaltyPoints(BigDecimal totalCost);
    public String rewards(int totalPoints);

}
