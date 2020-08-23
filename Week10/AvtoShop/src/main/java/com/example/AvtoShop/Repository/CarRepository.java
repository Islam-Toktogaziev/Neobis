package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
