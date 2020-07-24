package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
