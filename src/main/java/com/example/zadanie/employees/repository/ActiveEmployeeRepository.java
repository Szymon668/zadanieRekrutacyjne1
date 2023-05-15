package com.example.zadanie.employees.repository;

import com.example.zadanie.employees.entity.ActiveEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveEmployeeRepository extends JpaRepository<ActiveEmployeeEntity, Long> {
}
