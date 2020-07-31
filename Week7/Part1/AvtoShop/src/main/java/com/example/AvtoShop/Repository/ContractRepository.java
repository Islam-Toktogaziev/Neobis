package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository <Contracts,Long> {

    List<Contracts> findByCustomerID(Long id);

    List<Contracts> findByEmployeeID(Long id);

}
