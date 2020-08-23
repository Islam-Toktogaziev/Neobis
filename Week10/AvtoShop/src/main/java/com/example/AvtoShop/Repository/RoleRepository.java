package com.example.AvtoShop.Repository;

import com.example.AvtoShop.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (String name);
}
