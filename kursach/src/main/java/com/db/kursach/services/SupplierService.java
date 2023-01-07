package com.db.kursach.services;
import com.db.kursach.models.Employee;
import com.db.kursach.models.Supplier;
import com.db.kursach.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor

public class SupplierService {
    private final SupplierRepository supplierRepository;

    public List<Supplier> listSuppliers(){
        return supplierRepository.findAll();
    }
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }
}
