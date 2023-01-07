package com.db.kursach.repositories;

import com.db.kursach.models.Employee;
import com.db.kursach.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
