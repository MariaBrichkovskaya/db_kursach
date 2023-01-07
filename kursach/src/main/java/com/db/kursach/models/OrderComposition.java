package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
class OrderCompositionKey implements Serializable {

    @Column(name = "order_id")
    Long order_id;

    @Column(name = "product_id")
    Long product_id;

}
@Entity
@Table(name = "order_composition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderComposition {
    @EmbeddedId
    OrderCompositionKey id;

    @Column(name = "product_amount")
    private int amount;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;
}
