package org.example;



public class Employee extends Person
{
    private int salary;

    public Employee(String firstName, String lastName, Address address, int salary) {
        super(firstName, lastName, address);
        this.salary = salary;
    }
    public void promote(int increment) {
        salary += increment;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
