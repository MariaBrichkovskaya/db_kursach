package com.db.kursach.services;

import com.db.kursach.models.Employee;
import com.db.kursach.models.Product;
import com.db.kursach.repositories.EmployeeRepository;
import com.db.kursach.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    public void editProduct(Long id,Product product){
        Product product1=productRepository.findById(id).orElseThrow();
        product1.setAmount(product.getAmount());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setName(product.getName());
        product1.setCalories(product.getCalories());
        product1.setUnitWeight(product.getUnitWeight());
        productRepository.save(productRepository.findById(id).orElse(null));
    }
}
