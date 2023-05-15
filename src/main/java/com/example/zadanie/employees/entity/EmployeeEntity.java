package com.example.zadanie.employees.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends AbstractEmployeeEntity {
    public EmployeeEntity(String name, List<TeamEntity> teamEntityList) {
        super(name, teamEntityList);
    }

    public EmployeeEntity(Long id, String s, List<TeamEntity> teamEntities) {
        super(id, s, teamEntities);
    }
}
