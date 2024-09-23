package learn.app.library.management.promotion;

import java.util.List;
import learn.app.library.management.model.Product;

public interface PromotionStrategy {

    String discount();

    String promotionType();

    void apply(List<Product> products);
}
