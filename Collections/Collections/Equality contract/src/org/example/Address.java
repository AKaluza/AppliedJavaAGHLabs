package org.example;

import java.util.Objects;

public class Address {
    private final String street;
    private final String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return street.equals(that.street) && city.equals(that.city);
    }
}
