package learn.app.shopping.cart.management.data;

import learn.app.shopping.cart.management.model.CartView;
import learn.app.shopping.cart.management.model.Item;

import java.util.Arrays;
import java.util.List;

public class ItemData {


    public static Item createItem() {
        return new Item("Book_1", 2, 10.12);
    }

    public static List<Item> createItemsList() {
        return List.of(createItem());
    }
    public static List<CartView> cartContent() {
        return List.of(new CartView(createItem(), 20.24));
    }
}
