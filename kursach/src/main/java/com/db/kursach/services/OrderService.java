package com.db.kursach.services;



import com.db.kursach.models.*;
import com.db.kursach.repositories.OrderCompRepository;
import com.db.kursach.repositories.OrderRepository;
import com.db.kursach.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderCompRepository orderCompRepository;
    private final UserRepository userRepository;
    public List<Order> listOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    public Order addProductInOrder(Order order, Product product, int productAmount) {
        OrderComposition orderComposition = new OrderComposition();
        orderComposition.setOrder(order);
        orderComposition.setProduct(product);
        orderComposition.setAmount(productAmount);
        orderComposition.setId(new OrderCompositionKey(order, product));
        order.getOrderComposition().add(orderComposition);
        return order;
    }
    public void saveOrder(Order order) {
        orderRepository.save(order);
        //orderCompRepository.saveAll(order.getOrderComposition());
    }
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    public Order deleteOrderPosition(int positionIndex, Order order) {
        order.getOrderComposition().remove(positionIndex);
        return order;
    }


}
