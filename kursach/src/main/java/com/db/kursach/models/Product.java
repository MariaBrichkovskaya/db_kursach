package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "amount_in_stock")
    private Long amount;
    @Column(name = "calories")
    private Long calories;
    @Column(name = "unit_weight")
    private int unitWeight;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_price")
    private Double price;
    //private String priceStr=String.format("%.2f", price);;
    /*@Column(name = "order_price")
    private Double price;
    @Column(name = "other_info", columnDefinition = "text")
    private String description;*/
    @OneToMany(mappedBy = "product")
    private List<OrderComposition> orderComposition;
}
