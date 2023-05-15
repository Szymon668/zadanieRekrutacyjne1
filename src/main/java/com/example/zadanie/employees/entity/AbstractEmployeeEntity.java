package com.example.zadanie.employees.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractEmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long  id;
    @Column(length = 50,name = "NAME")
    protected String name;
    @ManyToMany()
    protected List<TeamEntity> teams;
    public AbstractEmployeeEntity(String name, List<TeamEntity> teamEntityList) {
        this.name = name;
        this.teams = teamEntityList;
    }
}
