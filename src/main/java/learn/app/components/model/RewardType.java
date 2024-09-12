package learn.app.components.model;

public enum RewardType {

    NO_REWARD("No Reward"),
    DISCOUNT_5("5% OFF"),
    DISCOUNT_10("10% OFF"),
    DISCOUNT_15("15% OFF");

    private final String discount_label;
    RewardType(String discountLabel) {
        this.discount_label = discountLabel;
    }
    public String label() { return discount_label;}
}
