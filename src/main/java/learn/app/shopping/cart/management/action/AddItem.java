package learn.app.shopping.cart.management.action;

import java.util.List;
import java.util.stream.Collectors;

import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

@Service
public class AddItem implements Action {

    @Override
    public List<Item> perform(Item item, List<Item> items) {
        boolean isItemExist = items.stream().anyMatch(i -> i.itemName().equalsIgnoreCase(item.itemName()));
        if(isItemExist) {
            items =  items.stream().map(i -> {
                if(i.itemName().equalsIgnoreCase(item.itemName())) {
                    return new Item(item.itemName(), i.quantity()+1, item.price_per_unit());
                } else {
                    return i;
                }
            }).collect(Collectors.toList());
        } else {
            items.add(item);
        }
        return items;
    }
}
