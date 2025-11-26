package org.example;

import java.time.Instant;
import java.util.Objects;

public class Person {
    private final Instant created;
    private final String name;
    private final Integer age;
    private final Address address;

    public Person(Instant created, String name, Integer age, Address address) {
        this.created = created;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return name.equals(that.name) &&
                age.equals(that.age) &&
                address.equals(that.address);
    }
}
