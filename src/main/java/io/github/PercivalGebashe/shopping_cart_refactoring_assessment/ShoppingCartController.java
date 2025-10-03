package io.github.PercivalGebashe.shopping_cart_refactoring_assessment;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/shop")
public class ShoppingCartController {
    // Store carts in memory (in real app, this would be a database)
    private final Map<String, Cart> carts = new HashMap<>();


    // Add item to cart
    @PostMapping("/addItem")
    public String addItem(@RequestParam("cartId") String cartId,
                          @RequestParam("itemName") String itemName,
                          @RequestParam("price") BigDecimal price,
                          @RequestParam("quantity") int quantity) {

        // Get or create cart if not exist
        Cart cart = carts.computeIfAbsent(cartId, Cart::new);

        cart.addItem(new Item(itemName, price, quantity));

        return "Item Added. Total: " + cart.calculateTotal();
    }

    // Get cart total
    @GetMapping("/getTotal")
    public String getTotal(@RequestParam("cartId") String cartId) {
        Cart cart = carts.get(cartId);

        if (cart == null) {
            return "Cart not found";
        }

        // Calculate and return total
        return "Total: " + cart.calculateTotal();
    }
}