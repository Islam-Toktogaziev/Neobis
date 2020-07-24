package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Orders;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping ("/orders")
    public List<Orders> all(){
        return orderRepository.findAll();
    }

    @GetMapping ("/customers/{customerID}/orders")
    public List<Orders> getAllByCustomer_CustomerID(@PathVariable (value = "customerID") Long id){
        return orderRepository.findByCustomer_CustomerID(id);
    }


    @PostMapping ("/customers/{customerID}/orders")
    public Orders createOrder (@PathVariable (value = "customerID") Long customerid,
                            @RequestBody Orders newOrders) {
        return orderRepository.findById(customerid).map(orders -> {
            orders.setCustomer(newOrders.getCustomer());
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException(customerid));
    }


    @PutMapping("/customers/{customerID}/orders/{orderID}")
    public Orders updateOrder (@PathVariable (value = "customerID") Long customerid,
                               @PathVariable (value = "orderID") Long orderID,
                               @RequestBody Orders newOrders){
        if (!orderRepository.existsById(customerid)){
            throw new ResourceNotFoundException(customerid);
        }

        return orderRepository.findById(orderID).map(orders -> {
            orders.setStatus(newOrders.getStatus());
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException(orderID));
    }


    @DeleteMapping("/customers/{customerID}/orders/{orderID}")
    public ResponseEntity<?> deleteOrder (@PathVariable (value = "customerID") Long customerid,
                                          @PathVariable (value = "orderID") Long orderID){
        return orderRepository.findByCustomer_CustomerIDAndOrderID(orderID,customerid).map(orders -> {
            orderRepository.delete(orders);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(orderID));
    }
}
