package com.example.zadanie.employees.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "TEAM")
@NoArgsConstructor
public class TeamEntity {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(length = 50, name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "teams")
    private List<EmployeeEntity> employees;

}
