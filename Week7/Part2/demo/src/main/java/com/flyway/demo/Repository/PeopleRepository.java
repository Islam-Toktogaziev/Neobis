package com.flyway.demo.Repository;

import com.flyway.demo.Entity.People;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeopleRepository extends JpaRepository<People, Long> {
}
