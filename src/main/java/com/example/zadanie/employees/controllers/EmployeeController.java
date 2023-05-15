package com.example.zadanie.employees.controllers;


import com.example.zadanie.employees.dto.CreateEmployeeRequest;
import com.example.zadanie.employees.dto.GetEmployeesResponse;
import com.example.zadanie.employees.dto.UpdateEmployeeRequest;
import com.example.zadanie.employees.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es = es;
    }


    @PostMapping
    public void createEmployee(@RequestBody CreateEmployeeRequest cr) {
        es.createEmployee(cr);
    }

    @GetMapping
    public GetEmployeesResponse getEmployee(@RequestParam(required = false) Boolean active) {
      return es.getEmployee(active);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody UpdateEmployeeRequest ur) {
        es.updateEmployee(id, ur);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id, @RequestParam boolean active) {
        es.deleteEmployee(id, active);
    }

}
