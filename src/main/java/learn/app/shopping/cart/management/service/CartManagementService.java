package learn.app.shopping.cart.management.service;

import java.util.ArrayList;
import java.util.List;

import learn.app.shopping.cart.management.action.ActionType;
import learn.app.shopping.cart.management.action.AddItem;
import learn.app.shopping.cart.management.action.RemoveItem;
import learn.app.shopping.cart.management.action.ViewItem;
import learn.app.shopping.cart.management.model.CartView;
import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

@Service
public class CartManagementService {

    private AddItem add;
    private RemoveItem remove;

    private ViewItem viewItems;

    private List<Item> cartArrayListItems = new ArrayList<>(1000);

    CartManagementService(final AddItem addItem, final RemoveItem removeItem, final ViewItem viewItems) {
        this.add = addItem;
        this.remove = removeItem;
        this.viewItems = viewItems;
    }

    public void performAction(ActionType actionType, Item item) {
        switch(actionType) {
            case ADD:
                cartArrayListItems = add.perform(item, cartArrayListItems);
                break;
            case REMOVE:
                cartArrayListItems = remove.perform(item, cartArrayListItems);
                break;
            default:
                throw new UnsupportedOperationException("Action not supported: " + actionType);

        }
    }

    public List<CartView> viewCart() {
        return viewItems.view(cartArrayListItems);
    }
}
