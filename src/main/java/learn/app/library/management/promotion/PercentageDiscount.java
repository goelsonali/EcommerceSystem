package learn.app.library.management.promotion;

import java.util.List;
import learn.app.library.management.model.PromotionType;
import learn.app.library.management.model.Product;

public class PercentageDiscount implements Promotion {

  @Override
  public void apply(List<Product> products, float discount) {
    List<Product> productsToApplyDiscounts =
        products.stream()
            .filter(p -> p.getPromotionType().equals(PromotionType.PERCENTAGE_DISCOUNT))
            .toList();
    productsToApplyDiscounts.forEach(p -> p.setPrice(p.getPrice() * ((100 - discount)/100)));
  }
}

