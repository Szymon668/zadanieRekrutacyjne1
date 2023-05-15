package com.example.zadanie.employees;

import com.example.zadanie.employees.dto.CreateEmployeeRequest;
import com.example.zadanie.employees.dto.EmployeeDto;
import com.example.zadanie.employees.dto.GetEmployeesResponse;
import com.example.zadanie.employees.dto.UpdateEmployeeRequest;
import com.example.zadanie.employees.entity.ActiveEmployeeEntity;
import com.example.zadanie.employees.entity.EmployeeEntity;
import com.example.zadanie.employees.entity.TeamEntity;
import com.example.zadanie.employees.repository.ActiveEmployeeRepository;
import com.example.zadanie.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {
    private final EmployeeRepository employeeRepository;
    private final ActiveEmployeeRepository activeEmployeeRepository;

    public EmployeeDao(EmployeeRepository employeeRepository, ActiveEmployeeRepository activeEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.activeEmployeeRepository = activeEmployeeRepository;
    }

    @Transactional
    public Long createEmployee(CreateEmployeeRequest cr, boolean isActive) {
        if (isActive) {
            return activeEmployeeRepository.save(new ActiveEmployeeEntity(cr.getName(), List.of(), cr.getEmploymentDate().get(), cr.getSalary().get())).getId();
        } else {
            return employeeRepository.save(new EmployeeEntity(cr.getName(), List.of())).getId();
        }
    }

    @Transactional
    public void updateEmployee(Long id, UpdateEmployeeRequest ur, boolean isActive) {
        if (isActive) {
            activeEmployeeRepository.save(new ActiveEmployeeEntity(id, ur.getName().orElse(null), List.of(), ur.getEmploymentDate().get(), ur.getSalary().get()));
        } else {
            employeeRepository.save(new EmployeeEntity(id, ur.getName().orElse(null), List.of()));
        }
    }

    @Transactional
    public GetEmployeesResponse getEmployee(Boolean active) {
        if (active == null) {
            List<EmployeeDto> activeEmployees = activeEmployeeRepository.findAll().stream().map((x) -> new EmployeeDto(x.getId(), x.getEmploymentDate(), x.getSalary(), x.getName())).toList();
            List<EmployeeDto> employees = employeeRepository.findAll().stream().map((x) -> new EmployeeDto(x.getId(), null, null, x.getName())).toList();
            return new GetEmployeesResponse(activeEmployees, employees);
        } else if (active) {
            List<EmployeeDto> activeEmployees = activeEmployeeRepository.findAll().stream().map((x) -> new EmployeeDto(x.getId(), x.getEmploymentDate(), x.getSalary(), x.getName())).toList();
            return new GetEmployeesResponse(activeEmployees, null);
        } else {
            List<EmployeeDto> employees = employeeRepository.findAll().stream().map((x) -> new EmployeeDto(x.getId(), null, null, x.getName())).toList();
            return new GetEmployeesResponse(null, employees);
        }
    }

    @Transactional
    public void deleteEmployee(long id, boolean active) {
        if (active) {
            activeEmployeeRepository.deleteById(id);
        } else {
            employeeRepository.deleteById(id);
        }
    }
}
