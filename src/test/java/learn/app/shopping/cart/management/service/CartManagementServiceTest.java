package learn.app.shopping.cart.management.service;

import static learn.app.shopping.cart.management.data.ItemData.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import learn.app.shopping.cart.management.action.*;
import learn.app.shopping.cart.management.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CartManagementServiceTest {

  @Mock private Action mockAction;

  @Mock private ViewItem viewItems;

  @Mock private List<Action> mockActions;

  private CartManagementService classToTest;

  private List<Item> mockCartItem;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockCartItem = new ArrayList<>();
        mockActions = List.of(mockAction);
        classToTest = new CartManagementService(mockActions,viewItems);
    }

    @Test
    void whenAddAnItem() {
        Item mockItem = createItem();
        when(mockAction.getAction()).thenReturn(ActionType.ADD);
        when(mockAction.perform(any(), any())).thenReturn(mockCartItem);
        

        classToTest.performAction(ActionType.ADD, mockItem);
        verify(mockAction, times(1)).perform(mockItem, mockCartItem);
    }

   @Test
    void whenRemoveAnItem() {
        Item mockItem = createItem();
       when(mockAction.getAction()).thenReturn(ActionType.REMOVE);
       when(mockAction.perform(any(), any())).thenReturn(mockCartItem);
       
        classToTest.performAction(ActionType.REMOVE, mockItem);
        verify(mockAction, times(1)).perform(mockItem, mockCartItem);
    }

    @Test
    void whenViewCart() {
        when(viewItems.view(mockCartItem)).thenReturn(cartContent());

        classToTest.viewCart();
        verify(viewItems, times(1)).view(mockCartItem);

    }
}
