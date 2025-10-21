package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements HavingTeam {
    private List<Employee> employees = new ArrayList<>();

    public Manager(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee find(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
