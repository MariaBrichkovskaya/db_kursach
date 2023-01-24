package com.db.kursach.models.viewsModels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name="well_paid_employees")
@AllArgsConstructor
@NoArgsConstructor
@Immutable
public class WellPaidEmployee {
    @Id
    @Column(name = "ФИО работника")
    private String fullName;
    @Column(name = "Должность")
    private String position;
    @Column(name = "Зарплата")
    private Integer salary;
}
