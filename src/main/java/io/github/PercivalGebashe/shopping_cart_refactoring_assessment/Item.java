package io.github.PercivalGebashe.shopping_cart_refactoring_assessment;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private final BigDecimal price;
    private int quantity;

    public Item(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int additionalQuantity){
        this.quantity += additionalQuantity;
    }

    public BigDecimal getTotalPrice(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}