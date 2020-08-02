package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Orders;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CustomerRepository;
import com.example.AvtoShop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;


    @Autowired
    public OrderController (OrderRepository orderRepository,
                            CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping ("/orders")
    public List<Orders> all(){
        return orderRepository.findAll();
    }

    @GetMapping ("/customers/{customerID}/orders")
    public List<Orders> getAllByCustomerID(@PathVariable (value = "customerID") Long customerID){
        return orderRepository.findAllByCustomerID(customerID);
    }

    @GetMapping ("/customers/{customerID}/orders/{orderID}")
    public Orders one(@PathVariable (value = "customerID") Long customerID,
                      @PathVariable (value = "orderID") Long orderID){
        if (!customerRepository.existsById(customerID)){
            throw new ResourceNotFoundException("Could not find customer ",customerID);
        }
        return orderRepository.findById(orderID)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find order ",orderID));

    }


    @PostMapping ("/customers/{customerID}/orders")
    public Orders createOrder (@PathVariable (value = "customerID") Long customerID,
                            @RequestBody Orders orders) {
        return customerRepository.findById(customerID).map(customer -> {
            orders.setCustomerID(customer);
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find customer ",customerID));
    }


    @PutMapping("/customers/{customerID}/orders/{orderID}")
    public Orders updateOrder (@PathVariable (value = "customerID") Long customerID,
                               @PathVariable (value = "orderID") Long orderID,
                               @RequestBody Orders newOrders){
        if (!customerRepository.existsById(customerID)){
            throw new ResourceNotFoundException("Could not find customer ",customerID);
        }

        return orderRepository.findById(orderID).map(orders -> {
            orders.setStatus(newOrders.getStatus());
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find order ",orderID));
    }


    @DeleteMapping("/customers/{customerID}/orders/{orderID}")
    public ResponseEntity<?> deleteOrder (@PathVariable (value = "customerID") Long customerID,
                                          @PathVariable (value = "orderID") Long orderID){
        return orderRepository.findByCustomerIDAndOrderID(orderID,customerID).map(orders -> {
            orderRepository.delete(orders);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find order ",orderID));
    }
}
