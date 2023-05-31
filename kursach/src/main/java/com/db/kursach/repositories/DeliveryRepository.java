package com.db.kursach.repositories;

import com.db.kursach.models.Delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    List<Delivery> findByDate(LocalDate date);
}
