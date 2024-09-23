package learn.app.library.management.promotion;

import static learn.app.library.management.model.PromotionType.FLAT_DISCOUNT;

import java.util.List;
import learn.app.library.management.config.PromotionConfig;
import learn.app.library.management.model.Product;
import org.springframework.stereotype.Service;

@Service
public class FlatPromotion implements PromotionStrategy {

    private final PromotionConfig promotionConfig;

    public FlatPromotion(PromotionConfig promotionConfig) {
        this.promotionConfig = promotionConfig;
    }


    @Override
    public String discount() {
        return promotionConfig.discounts().get(FLAT_DISCOUNT.toString());
    }

    @Override
    public String promotionType() {
        return FLAT_DISCOUNT.toString();
    }

    @Override
    public void apply(List<Product> products) {
        products.forEach(p -> p.setPrice(p.getPrice() - Float.parseFloat(discount())));
    }
}
