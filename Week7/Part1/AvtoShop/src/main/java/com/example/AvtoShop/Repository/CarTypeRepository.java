package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository <CarType, Long> {
}
