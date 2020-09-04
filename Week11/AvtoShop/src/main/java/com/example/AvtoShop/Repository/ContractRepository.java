package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository <Contracts,Long> {

    List<Contracts> findByCustomerID(Optional customerID);

    List<Contracts> findByEmployeeID(Optional employeeID);

    Contracts findByContractIDAndCustomerID (Long contractID, Optional customerID);

    Contracts findByContractIDAndEmployeeID(Long contractID, Optional employeeID);

}
