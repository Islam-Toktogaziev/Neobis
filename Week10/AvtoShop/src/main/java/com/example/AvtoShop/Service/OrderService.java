package com.example.AvtoShop.Service;

import com.example.AvtoShop.Entity.Orders;
import com.example.AvtoShop.Exceptions.ResourceNotFoundException;
import com.example.AvtoShop.Repository.CustomerRepository;
import com.example.AvtoShop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;


    @Autowired
    public OrderService (OrderRepository orderRepository,
                            CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Orders> getAllFromOrders(){
        return orderRepository.findAll();
    }

    public List<Orders> getAllByCustomerIDFromOrders(Long customerID){
        return orderRepository.findByCustomerID(customerRepository.findById(customerID));
    }

    public Orders getOneByCustomerIDFromOrders(Long customerID, Long orderID){
        if (!customerRepository.existsById(customerID)){
            throw new ResourceNotFoundException("Could not find customer with ID ",customerID);
        }
        return orderRepository.findByOrderIDAndCustomerID(orderID,customerRepository.findById(customerID));
    }


    public Orders createOrder (Long customerID, Orders orders) {
        return customerRepository.findById(customerID).map(customer -> {
            orders.setCustomerID(customer);
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find customer with ID ",customerID));
    }


    public Orders updateOrder (Long customerID, Long orderID, Orders newOrders){
        if (!customerRepository.existsById(customerID)){
            throw new ResourceNotFoundException("Could not find customer with ID ",customerID);
        }

        return orderRepository.findById(orderID).map(orders -> {
            orders.setStatus(newOrders.getStatus());
            return orderRepository.save(orders);
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find order with ID ",orderID));
    }


    public ResponseEntity<?> deleteOrder (Long customerID, Long orderID){
        return orderRepository.findAllByOrderIDAndCustomerID(orderID,customerRepository.findById(customerID)).map(orders -> {
            orderRepository.delete(orders);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Could not find order with ID ",orderID));
    }

}
