package com.example.zadanie.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private final Long Id;
    private final Date employmentDate;
    private final Double salary;
    private final String name;
}