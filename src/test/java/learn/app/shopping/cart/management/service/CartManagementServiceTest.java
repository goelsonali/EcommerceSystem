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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CartManagementServiceTest {

  @Mock private AddItem addItem;

  @Mock private RemoveItem removeItem;

  @Mock private ViewItem viewItems;

  @InjectMocks private CartManagementService classToTest;

  private List<Item> mockCartItem;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockCartItem = new ArrayList<>();
    }

    @Test
    void whenAddAnItem() {
        Item mockItem = createItem();
        when(addItem.perform(any(), any())).thenReturn(mockCartItem);

        classToTest.performAction(ActionType.ADD, mockItem);
        verify(addItem, times(1)).perform(mockItem, mockCartItem);
    }

    @Test
    void whenRemoveAnItem() {
        Item mockItem = createItem();
        when(removeItem.perform(any(), any())).thenReturn(mockCartItem);

        classToTest.performAction(ActionType.REMOVE, mockItem);
        verify(removeItem, times(1)).perform(mockItem, mockCartItem);
    }

    @Test
    void whenViewCart() {
        when(viewItems.view(mockCartItem)).thenReturn(cartContent());

        classToTest.viewCart();
        verify(viewItems, times(1)).view(mockCartItem);

    }
}
