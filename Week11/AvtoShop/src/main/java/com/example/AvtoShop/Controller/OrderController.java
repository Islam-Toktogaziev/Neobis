package com.example.AvtoShop.Controller;


import com.example.AvtoShop.Entity.Orders;
import com.example.AvtoShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping ("/orders")
    public List<Orders> all(){
        return orderService.getAllFromOrders();
    }

    @GetMapping ("/customers/{customerID}/orders")
    public List<Orders> getAllByCustomerID(@PathVariable (value = "customerID") Long customerID){
        return orderService.getAllByCustomerIDFromOrders(customerID);
    }

    @GetMapping ("/customers/{customerID}/orders/{orderID}")
    public Orders one(@PathVariable (value = "customerID") Long customerID,
                      @PathVariable (value = "orderID") Long orderID){
        return orderService.getOneByCustomerIDFromOrders(customerID,orderID);
    }


    @PostMapping ("/customers/{customerID}/orders")
    public Orders createOrder (@PathVariable (value = "customerID") Long customerID,
                            @RequestBody Orders orders) {
        return orderService.createOrder(customerID,orders);
    }


    @PutMapping("/customers/{customerID}/orders/{orderID}")
    public Orders updateOrder (@PathVariable (value = "customerID") Long customerID,
                               @PathVariable (value = "orderID") Long orderID,
                               @RequestBody Orders newOrders){
        return orderService.updateOrder(customerID,orderID,newOrders);
    }


    @DeleteMapping("/customers/{customerID}/orders/{orderID}")
    public ResponseEntity<?> deleteOrder (@PathVariable (value = "customerID") Long customerID,
                                          @PathVariable (value = "orderID") Long orderID){
        return orderService.deleteOrder(customerID,orderID);
    }
}
