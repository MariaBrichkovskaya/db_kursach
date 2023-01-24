package com.db.kursach.repositories.viewsRepository;

import com.db.kursach.models.viewsModels.WellPaidEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WellPaidEmployeesRepository extends JpaRepository<WellPaidEmployee, Long> {
}
