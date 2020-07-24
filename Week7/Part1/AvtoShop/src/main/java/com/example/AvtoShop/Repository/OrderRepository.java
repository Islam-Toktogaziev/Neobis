package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {


    List<Orders> getAllByCustomer_CustomerID(Long id);

    List<Orders> findByCustomer_CustomerID(Long id);

    Optional<Orders> findByCustomer_CustomerIDAndOrderID(Long id, Long customerID);
}
