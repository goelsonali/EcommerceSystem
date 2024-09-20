package learn.app.library.management.promotion;

import java.util.List;
import learn.app.library.management.model.Product;
import learn.app.library.management.model.PromotionType;

public interface Promotion {
    void apply(List<Product> products, PromotionType type);
}
