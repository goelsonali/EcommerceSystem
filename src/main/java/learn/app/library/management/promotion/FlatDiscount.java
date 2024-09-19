package learn.app.library.management.promotion;

import java.util.List;

import learn.app.library.management.model.PromotionType;
import learn.app.library.management.model.Product;

public class FlatDiscount implements Promotion {

    @Override
    public void apply(List<Product> products, float discount) {
        products = products.stream().filter(p -> p.getPromotionType().equals(PromotionType.FLAT_DISCOUNT)).toList();
        products.forEach(p -> p.setPrice(p.getPrice() - discount));
    }
}
