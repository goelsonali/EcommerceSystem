package learn.app.shopping.cart.management.action;

import java.util.List;
import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

import static learn.app.shopping.cart.management.action.ActionType.REMOVE;

@Service
public class RemoveItem implements Action {

    @Override
    public List<Item> perform(Item item, List<Item> items) {
        items.remove(item);
        return items;
    }

    @Override
    public ActionType getAction() {
        return REMOVE;
    }
}
