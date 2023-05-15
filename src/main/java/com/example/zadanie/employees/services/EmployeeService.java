package com.example.zadanie.employees.services;

import com.example.zadanie.employees.EmployeeDao;
import com.example.zadanie.employees.dto.CreateEmployeeRequest;
import com.example.zadanie.employees.dto.EmploymentDetails;
import com.example.zadanie.employees.dto.GetEmployeesResponse;
import com.example.zadanie.employees.dto.UpdateEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void createEmployee(CreateEmployeeRequest cr) {
        employeeDao.createEmployee(cr, isEmployeeActive(cr));
    }

    public void updateEmployee(Long id, UpdateEmployeeRequest ur) {
        employeeDao.updateEmployee(id, ur, isEmployeeActive(ur));
    }

    public void deleteEmployee(Long id, boolean active) {
        employeeDao.deleteEmployee(id, active);
    }

    public GetEmployeesResponse getEmployee(Boolean active) {
        return employeeDao.getEmployee(active);
    }

    private boolean isEmployeeActive(EmploymentDetails ed) {
        if (ed.getEmploymentDate().isPresent() && ed.getSalary().isPresent()) {
            return true;
        } else if (ed.getEmploymentDate().isEmpty() && ed.getSalary().isEmpty()) {
            return false;
        } else throw new RuntimeException("Unknown activity state");
    }
}
