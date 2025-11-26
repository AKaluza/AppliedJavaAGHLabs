package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class Tests {
    @Test
    public void testIfDistinctPersonsAreNotEqual() {
        final var person0 = new Person(Instant.now(), "Jan Kowalski", 34, new Address("Czarnowiejska", "Kraków"));
        final var person1 = new Person(Instant.now(), "Robert Nowak", 41, new Address("Żegańska", "Warszawa"));

        Assertions.assertNotEquals(person0, person1,"Different persons must not be considered as equal");
    }

    @Test
    public void testIfSamePersonsAreEqual() {
        final var now = Instant.now();
        final var address = new Address("Czarnowiejska", "Kraków");
        final var person0 = new Person(now, "Jan Kowalski", 34, address);
        final var person1 = new Person(now, "Jan Kowalski", 34, address);

        Assertions.assertEquals(person0, person1,"Exactly same persons must be considered as equal");
    }

    @Test
    public void testIfAlmostSamePersonsAreEqual() {
        final var address = new Address("Czarnowiejska", "Kraków");
        final var person0 = new Person(Instant.ofEpochSecond(0), "Jan Kowalski", 34, address);
        final var person1 = new Person(Instant.now(), "Jan Kowalski", 34, address);

        Assertions.assertEquals(person0, person1,"Almost same (created at different times) persons must be considered as equal");
    }

    @Test
    public void testIfPersonsLivingAtSameAddressAreEqual() {
        Instant now = Instant.now();
        final var person0 = new Person(now, "Jan Kowalski", 34, new Address("Czarnowiejska", "Kraków"));
        final var person1 = new Person(now, "Jan Kowalski", 34, new Address("Czarnowiejska", "Kraków"));

        Assertions.assertEquals(person0, person1,"Same persons (living at same address) must be considered as equal");
    }

    @Test
    public void testIfPersonHashCodeIsImplemented() {
        Instant now = Instant.now();
        final var person0 = new Person(now, "Jan Kowalski", 34, new Address("Czarnowiejska", "Kraków"));
        final var person1 = new Person(now, "Jan Kowalski", 34, new Address("Czarnowiejska", "Kraków"));

        Assertions.assertEquals(person0.hashCode(), person1.hashCode(),"Same persons (living at same address) must be considered as equal");
    }
}