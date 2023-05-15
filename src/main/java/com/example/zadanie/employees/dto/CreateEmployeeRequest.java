package com.example.zadanie.employees.dto;

import com.example.zadanie.employees.entity.TeamEntity;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class CreateEmployeeRequest implements EmploymentDetails {
    private final String name;
    private final Optional<Date> employmentDate;
    private final Optional<Double> salary;

    public CreateEmployeeRequest(String name, Date employmentDate, Double salary) {
        this.name = name;
        this.employmentDate = Optional.ofNullable(employmentDate);
        this.salary = Optional.ofNullable(salary);
    }
}
