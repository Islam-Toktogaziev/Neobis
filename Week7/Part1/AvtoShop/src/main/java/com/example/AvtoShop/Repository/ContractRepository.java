package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository <Contracts,Long> {
}
