package learn.app.shopping.cart.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import learn.app.shopping.cart.management.action.ActionType;
import learn.app.shopping.cart.management.model.CartView;
import learn.app.shopping.cart.management.model.Item;
import learn.app.shopping.cart.management.service.CartManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "API for the shoppingCart")
public class ShoppingCartController {

    private CartManagementService service;

    @Autowired
    public ShoppingCartController(CartManagementService cartManagementService) {
        this.service = cartManagementService;
    }


    @PostMapping("/add")
    ResponseEntity<String> addItem(@RequestBody Item item) {
        service.performAction(ActionType.ADD, item);
        return ResponseEntity.ok("The item added to the cart successfully");
    }

    @PostMapping("/remove")
    ResponseEntity<String> removeItem(@RequestBody Item item) {
        service.performAction(ActionType.REMOVE, item);
        return ResponseEntity.ok("The item removed from the cart successfully");
    }

    @GetMapping("/view_cart")
    ResponseEntity<List<CartView>> view() {
       return ResponseEntity.ok(service.viewCart());
    }
}
