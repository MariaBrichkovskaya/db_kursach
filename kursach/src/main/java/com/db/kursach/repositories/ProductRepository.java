package com.db.kursach.repositories;


import com.db.kursach.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNameContaining(String name);
}
