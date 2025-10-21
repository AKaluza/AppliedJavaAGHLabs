package org.example;

public abstract class Employee {
    private final String name;
    private final int salary;

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

}
