package com.example.zadanie.employees.dto;

import java.util.Date;
import java.util.Optional;

public interface EmploymentDetails {
    Optional<Date> getEmploymentDate();

    Optional<Double> getSalary();
}
