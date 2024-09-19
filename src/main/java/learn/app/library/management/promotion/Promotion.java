package learn.app.library.management.promotion;

import java.util.List;
import learn.app.library.management.model.Product;

public interface Promotion {
    void apply(List<Product> products, float discount);
}
