package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
