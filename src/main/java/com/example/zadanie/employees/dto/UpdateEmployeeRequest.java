package com.example.zadanie.employees.dto;

import com.example.zadanie.employees.entity.TeamEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class UpdateEmployeeRequest implements EmploymentDetails {

    private final Optional<String> name;
    private final Optional<Date> employmentDate;
    private final Optional<Double> salary;

    public UpdateEmployeeRequest(String name, Date employmentDate, Double salary) {
        this.name = Optional.ofNullable(name);
        this.employmentDate = Optional.ofNullable(employmentDate);
        this.salary = Optional.ofNullable(salary);
    }
}
