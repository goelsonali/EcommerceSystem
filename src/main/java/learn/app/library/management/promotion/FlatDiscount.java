package learn.app.library.management.promotion;

import java.util.List;

import learn.app.library.management.model.PromotionType;
import learn.app.library.management.model.Product;
import org.springframework.stereotype.Service;

@Service
public class FlatDiscount implements Promotion {

    @Override
    public void apply(List<Product> products, PromotionType type) {
        products.forEach(p -> p.setPrice(p.getPrice() - Float.parseFloat(type.getDiscount())));
    }
}
