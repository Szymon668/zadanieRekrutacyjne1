package com.example.zadanie.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetEmployeesResponse {
    private final List<EmployeeDto> activeEmployees;
    private final List<EmployeeDto> Employees;
}
