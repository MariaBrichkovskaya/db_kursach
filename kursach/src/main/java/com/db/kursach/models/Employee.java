package com.db.kursach.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
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
    /*@Column(name = "preview_image_id")
    private Long previewImageId;*/
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "employee")
    private List<Image> images=new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "waiter")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private List<Delivery> deliveries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position1;
    /*@Column(name = "salary")
    private String salary;*/
    /*@Column(name = "employment_date")
    private String employmentDate;*/
    public void addImageToEmployee(Image image){
        image.setEmployee(this);
        images.add(image);
    }

}
