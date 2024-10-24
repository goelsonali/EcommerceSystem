package learn.app.product.management.action;

import learn.app.product.management.exception.ProductNotFoundException;
import learn.app.product.management.model.ProductOnLine;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class Removing implements ActionStrategy{

    public final HashSet<ProductOnLine> products;

    public Removing(HashSet<ProductOnLine> products) {
        this.products = products;
    }

    @Override
    public String perform(ProductOnLine product) {
        ProductOnLine existingProduct = products.stream()
                .filter(p-> p.getName().equalsIgnoreCase(product.getName()))
                .findFirst().orElseThrow(() -> new ProductNotFoundException("Product do not exist"));
        products.remove(existingProduct);
        return "Product Removed Successfully";
    }
}
