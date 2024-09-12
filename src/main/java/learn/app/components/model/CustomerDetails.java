package learn.app.components.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDetails {

    private String customerId;
    private int loyaltyPoints;

    @Builder.Default
    private RewardType rewardType = RewardType.NO_REWARD;
    // No-argument constructor (Lombok generates it automatically)
}

