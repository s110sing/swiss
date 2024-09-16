package com.swiss.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private Integer managerId;
    private double salary;

    public Employee(int id, String name, Integer managerId, double salary) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.salary = salary;
    }
}

