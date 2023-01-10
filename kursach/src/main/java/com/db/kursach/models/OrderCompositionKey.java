package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
public class OrderCompositionKey implements Serializable {
    private Order order;
    private Product product;
    public OrderCompositionKey(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
