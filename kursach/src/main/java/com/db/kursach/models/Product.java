package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
    private Long amount= Long.valueOf(0);
    @Column(name = "calories")
    private Integer calories;
    @Column(name = "unit_weight")
    private Integer unitWeight;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_price")
    private Float price;

    @OneToMany(mappedBy = "id.product",
            cascade = CascadeType.ALL)
    private List<OrderComposition> orderComposition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Delivery> deliveries;
    public String toStringCalories()
    {return calories.toString();}
    public String toStringWeight()
    {return unitWeight.toString();}
    public String toStringAmount(){return amount.toString(); }
}
