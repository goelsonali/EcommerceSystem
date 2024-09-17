package learn.app.shopping.cart.management.action;

import learn.app.shopping.cart.management.model.CartView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static learn.app.shopping.cart.management.data.ItemData.cartContent;
import static learn.app.shopping.cart.management.data.ItemData.createItemsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewItemTest {

  ViewItem classToTest = new ViewItem();

    @Test
    void whenListItemIsEmpty() {
        classToTest.view(new ArrayList<>());
        assertTrue(classToTest.view(new ArrayList<>()).isEmpty());
    }

    @Test
    void validateTotalItemCostWhenQtyMoreThanOne() {
        List<CartView> cartViewResult = classToTest.view(createItemsList());
        List<CartView> expectedResult = cartContent();

        assertEquals(expectedResult, cartViewResult);
    }
}
