package com.db.kursach.services;



import com.db.kursach.models.Order;
import com.db.kursach.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> listOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    public void saveOrder(Order order) {

        orderRepository.save(order);
    }
}
