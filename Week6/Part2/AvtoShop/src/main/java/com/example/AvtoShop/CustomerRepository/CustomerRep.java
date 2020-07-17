package com.example.AvtoShop.CustomerRepository;

import com.example.AvtoShop.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRep extends JpaRepository <Customer, Long> {
}
