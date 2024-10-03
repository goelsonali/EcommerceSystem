package learn.app.shopping.cart.management.action;

import learn.app.shopping.cart.management.model.Item;

import java.util.List;

public interface Action {

    List<Item> perform (Item item, List<Item> items);

    ActionType getAction();

}
