package learn.app.library.management.model;

public enum PromotionType {
    PERCENTAGE_DISCOUNT("20"),
    FLAT_DISCOUNT("5"),
    BUY_ONE_GET_ONE("1"),
    NO_DISCOUNT("0");

    private final String discount;

    PromotionType(String discount) {
        this.discount = discount;
    }
    public String getDiscount(){
        return discount;
    }
}
