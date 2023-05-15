package com.example.zadanie.employees.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ACTIVE_EMPLOYEE")
public class ActiveEmployeeEntity extends AbstractEmployeeEntity {
    @Column(name = "EMPLOYMENT_DATE")
    private Date employmentDate;
    @Column(name = "SALARY")
    private Double salary;

    public ActiveEmployeeEntity(String name, List<TeamEntity> teamEntityList, Date employmentDate, Double salary) {
        super(name, teamEntityList);
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    public ActiveEmployeeEntity(Long id, String name, List<TeamEntity> teamEntityList, Date employmentDate, Double salary) {
        super(id, name, teamEntityList);
        this.employmentDate = employmentDate;
        this.salary = salary;
    }
}
