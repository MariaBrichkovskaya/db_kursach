package com.db.kursach.services;
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
    public void saveSupplier(Supplier supplier) {

        supplierRepository.save(supplier);
    }
    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }
    public void editSupplier(Long id, Supplier supplier){
        Supplier supplier1=supplierRepository.findById(id).orElseThrow();
        supplier1.setPhone(supplier.getPhone());
        supplier1.setCity(supplier.getCity());
        supplier1.setCountry(supplier.getCountry());
        supplier1.setAddress(supplier.getAddress());
        supplier1.setName(supplier.getName());
        supplierRepository.save(supplierRepository.findById(id).orElse(null));
    }
}
