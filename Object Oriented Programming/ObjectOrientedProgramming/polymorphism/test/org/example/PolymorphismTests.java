package org.example;

import org.example.behavior.Descriptable;
import org.example.behavior.Traceable;
import org.example.domain.Description;
import org.example.domain.Identifier;
import org.example.vehicles.Automobile;
import org.example.vehicles.Car;
import org.example.vehicles.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Set;

public class PolymorphismTests {
    @Test
    public void testAutomobileIsAbstract() {
        final var modifiers = Automobile.class.getModifiers();
        Assertions.assertTrue(Modifier.isAbstract(modifiers), "Automobile class is not final");
    }

    @Test
    public void testAutomobileImplementsDescriptable() {
        Assertions.assertTrue(Descriptable.class.isAssignableFrom(Automobile.class), "Automobile does not implement HavingDescription");
    }

    @Test
    public void testAutomobileImplementsTraceable() {
        Assertions.assertTrue(Traceable.class.isAssignableFrom(Automobile.class), "Automobile does not implement HavingDescription");
    }

    @Test
    public void testCarExtendsAutomobile() {
        Assertions.assertTrue(Automobile.class.isAssignableFrom(Car.class), "Car does not extends Automobile");
    }

    @Test
    public void testTruckExtendsAutomobile() {
        Assertions.assertTrue(Automobile.class.isAssignableFrom(Truck.class), "Truck does not extends Automobile");
    }

    private Description getDescription(Car car) {
        return Assertions.assertDoesNotThrow(car::getDescription, "getDescription method of class Car must not throw an exception");
    }

    private Description getDescription(Truck truck) {
        return Assertions.assertDoesNotThrow(truck::getDescription, "getDescription method of class Truck must not throw an exception");
    }

    @Test
    public void testSolution() {
        final var car0 = new Car();
        final var car1 = new Car();
        final var truck0 = new Truck();
        final var truck1 = new Truck();

        Assertions.assertEquals(new Identifier(100), getDescription(car0).vin(), "First automobile (car) VIN is not 100");
        Assertions.assertEquals(new Identifier(101), getDescription(car1).vin(), "Second automobile (car) VIN is not 101");
        Assertions.assertEquals(new Identifier(102), getDescription(truck0).vin(), "Third automobile (truck) VIN is not 102");
        Assertions.assertEquals(new Identifier(103), getDescription(truck1).vin(), "Fourth automobile (truck) is not 103");

        Assertions.assertEquals("Car", getDescription(car0).name(), "First automobile (car) name is not \"Car\"");
        Assertions.assertEquals("Car", getDescription(car0).name(), "Second automobile (car) name is not \"Car\"");
        Assertions.assertEquals("Truck", getDescription(truck0).name(), "Third automobile (truck) name is not \"Truck\"");
        Assertions.assertEquals("Truck", getDescription(truck1).name(), "Fourth automobile (truck) name is not \"Truck\"");

        Assertions.assertDoesNotThrow(
                () -> Inventory.class.getMethod("add", Automobile.class),
                "Inventory class does not implement method add with argument of type Automobile"
        );

        final var inventory = new Inventory();

        inventory.add(car0);
        inventory.add(car1);
        inventory.add(truck0);
        inventory.add(truck1);
        inventory.add(car0);
        inventory.add(car1);
        inventory.add(truck0);
        inventory.add(truck1);

        Assertions.assertEquals(4, inventory.stockSize(), "Vehicle stock size is not 4");
        Assertions.assertEquals(Set.of(new Identifier(100), new Identifier(101), new Identifier(102), new Identifier(103)), inventory.identifiers(), "Stock identifiers are not 100, 101, 102, 103");
    }
}