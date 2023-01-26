package com.db.kursach.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "employee_full_name")
    private String fullName;
    @Column(name = "work_experience")
    private int experience;
    @Column(name = "employee_phone_number")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name = "salary")
    private Integer salary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "employment_date")
    private LocalDate date;
    @Lob
    private byte[] image_bytes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "waiter")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private List<Delivery> deliveries;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position1;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private User user;

    public String toStringSalary(){return salary.toString();}



}
