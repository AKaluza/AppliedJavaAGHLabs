package org.example;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected Address address;

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
