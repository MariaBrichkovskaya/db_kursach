package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;
    @Column(name = "company_name")
    private String name;
    @Column(name = "supplier_country")
    private String country;
    @Column(name = "supplier_city")
    private String city;
    @Column(name = "supplier_address")
    private String address;
    @Column(name = "supplier_phone_number")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier")
    private List<Delivery> deliveries;

}
