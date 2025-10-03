package io.github.PercivalGebashe.shopping_cart_refactoring_assessment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final String cartId;
    private final List<Item> items = new ArrayList<>();

    public Cart(String cartId) {
        this.cartId = cartId;
    }

    public void addItem(Item newItem){
        for(Item item : items){
            if(item.getName().equals(newItem.getName()) && item.getPrice().equals(newItem.getPrice())){
                item.increaseQuantity(newItem.getQuantity());
                return;
            }
        }
        items.add(newItem);
    }

    public BigDecimal calculateTotal(){
        return items.stream()
                .map(Item::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}