package learn.app.product.management.action;

import learn.app.product.management.model.ProductOnLine;

public interface ActionStrategy {
    String perform(ProductOnLine product);
}
