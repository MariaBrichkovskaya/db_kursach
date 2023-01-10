package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "order_composition")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name = "id.order",
                joinColumns = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "id.product",
                joinColumns = @JoinColumn(name = "product_id")) })
public class OrderComposition {
    OrderCompositionKey id = new OrderCompositionKey();
    private int amount;
    @Column(name="product_id")
    private Product product;
    @Column(name="order_id")
    private Order order;
    @EmbeddedId
    public OrderCompositionKey getId() {
        return id;
    }
    public void setId(OrderCompositionKey id) {
        this.id = id;
    }
    @Column(name="product_amount")
    public int getAmount() {
        return amount;
    }
    @Column(name="product_amount")
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Transient
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Transient
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }


}
