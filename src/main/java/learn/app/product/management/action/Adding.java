package learn.app.product.management.action;

import learn.app.product.management.model.ProductOnLine;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class Adding implements ActionStrategy{

    public final HashSet<ProductOnLine> products;

    public Adding(HashSet<ProductOnLine> products) {
        this.products = products;
    }

    @Override
    public String perform(ProductOnLine product) {
        boolean productExists = products.stream().anyMatch(p-> product.getName().equalsIgnoreCase(p.getName()));
        if(productExists) {
            return "Product already exists";
        } else {
            products.add(product);
            return "Product now added";
        }
    }
}
