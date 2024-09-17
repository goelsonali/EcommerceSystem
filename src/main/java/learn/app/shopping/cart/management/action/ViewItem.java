package learn.app.shopping.cart.management.action;

import learn.app.shopping.cart.management.model.CartView;
import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewItem {

    public List<CartView> view(List<Item> cartArrayListItems) {
        return cartArrayListItems.stream().map(item -> {
            double total = item.quantity() * item.price_per_unit();
            return new CartView(item, total);
        }).collect(Collectors.toList());
    }
}
