package learn.app.library.management.promotion;

import static learn.app.library.management.model.PromotionType.PERCENTAGE_DISCOUNT;

import java.util.List;
import learn.app.library.management.config.PromotionConfig;
import learn.app.library.management.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PercentagePromotion implements PromotionStrategy{


    private final PromotionConfig config;

    public PercentagePromotion(@Qualifier("promotionConfig") PromotionConfig config) {
        this.config = config;
    }



    @Override
    public String discount() {
        return config.discounts().get(PERCENTAGE_DISCOUNT.toString());
    }

    @Override
    public String promotionType() {
        return PERCENTAGE_DISCOUNT.toString();
    }

    @Override
    public void apply(List<Product> products) {
        products.forEach(p -> p.setPrice(p.getPrice() * ((100 - Float.parseFloat(discount()))/100)));
    }
}
