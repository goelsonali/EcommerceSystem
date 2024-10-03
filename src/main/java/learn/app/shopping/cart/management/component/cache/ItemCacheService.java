package learn.app.shopping.cart.management.component.cache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemCacheService implements ItemCache{

    private Map<String,Item> itemCache = new ConcurrentHashMap<>(2);

    private final List<String> itemQueue = Collections.synchronizedList(new LinkedList<>());
    @Override
    public Item get(String name) {
        Item item = null;
        synchronized (itemQueue) {
            if(itemQueue.size()>0 && itemQueue.contains(name)){
                item = itemCache.get(name);
                itemQueue.remove(name);
                itemQueue.add(name);
            }
        }
        return item;
    }

    @Override
    public void put(String name, Item item) {

          synchronized (itemQueue) {
            if(itemQueue.contains(name)){
                itemQueue.remove(name);
            } else if(itemQueue.size() >= 2){
                String lruItem = itemQueue.remove(0);
                itemCache.remove(lruItem);
            }
            itemQueue.add(name);
            itemCache.put(name, item);
         }
    }
}
