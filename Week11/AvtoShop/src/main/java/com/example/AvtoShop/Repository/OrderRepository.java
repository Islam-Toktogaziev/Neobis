package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

    List<Orders>  findByCustomerID(Optional customerID);

    Orders findByOrderIDAndCustomerID (Long orderID, Optional customerID);

    Optional<Orders> findAllByOrderIDAndCustomerID (Long orderID, Optional customerID);
}
