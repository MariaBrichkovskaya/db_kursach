package com.db.kursach.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Comparable<Order>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "order_time")
    @DateTimeFormat
    private Date time;
    @Column(name = "order_price")
    private Double price;
    @Column(name = "other_info", columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee waiter;

    @OneToMany(mappedBy = "id.order",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderComposition> orderComposition;

    @Override
    public int compareTo(Order order) {
        return order.time.compareTo(time);
    }
}
