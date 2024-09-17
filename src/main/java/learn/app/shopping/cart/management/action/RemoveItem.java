package learn.app.shopping.cart.management.action;

import java.util.List;
import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

@Service
public class RemoveItem implements Action {

    @Override
    public List<Item> perform(Item item, List<Item> items) {
        items.remove(item);
        return items;
    }
}
