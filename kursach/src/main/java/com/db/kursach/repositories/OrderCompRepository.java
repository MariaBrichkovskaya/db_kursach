package com.db.kursach.repositories;

import com.db.kursach.models.OrderComposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCompRepository extends JpaRepository<OrderComposition, Long> {
}
