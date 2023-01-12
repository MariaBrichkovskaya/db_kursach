package com.db.kursach.services;

import com.db.kursach.models.Delivery;
import com.db.kursach.repositories.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public List<Delivery> listDeliveries(){
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }
    public void saveDelivery(Delivery delivery) {

        deliveryRepository.save(delivery);
    }
    public void deleteDelivery(Long id){
        deliveryRepository.deleteById(id);
    }
    public void editDelivery(Long id, Delivery delivery){
        Delivery delivery1=deliveryRepository.findById(id).orElseThrow();
        delivery1.setDate(delivery.getDate());
        delivery1.setEmployee(delivery.getEmployee());
        delivery1.setAmount(delivery.getAmount());
        delivery1.setProduct(delivery.getProduct());
        delivery1.setSupplier(delivery.getSupplier());
        deliveryRepository.save(deliveryRepository.findById(id).orElse(null));
    }
}
