package learn.app.shopping.cart.management.service;

import static learn.app.shopping.cart.management.action.ActionType.ADD;
import static learn.app.shopping.cart.management.action.ActionType.REMOVE;

import java.util.ArrayList;
import java.util.List;
import learn.app.shopping.cart.management.action.*;
import learn.app.shopping.cart.management.model.CartView;
import learn.app.shopping.cart.management.model.Item;
import org.springframework.stereotype.Service;

@Service
public class CartManagementService {

    final private ViewItem viewItems;
    final private List<Action> actions;

    final private List<Item> cartArrayListItems = new ArrayList<>(1000);

    CartManagementService(List<Action> actions, final ViewItem viewItems) {
        this.viewItems = viewItems;
        this.actions = actions;
    }

    public void performAction(ActionType actionType, Item item) {
        for (Action action : actions) {
            if(ADD.equals(actionType) && action.getAction().equals(ADD)){
                action.perform(item,cartArrayListItems);
            } else if(REMOVE.equals(actionType) && action.getAction().equals(REMOVE)){
                action.perform(item,cartArrayListItems);
            }
        }
    }

    public List<CartView> viewCart() {
        return viewItems.view(cartArrayListItems);
    }
}
