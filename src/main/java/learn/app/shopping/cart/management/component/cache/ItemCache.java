package learn.app.shopping.cart.management.component.cache;

import learn.app.shopping.cart.management.model.Item;

//Build LRU based cache
public interface ItemCache {

    Item get(String name);
    void put(String name, Item item);

}
