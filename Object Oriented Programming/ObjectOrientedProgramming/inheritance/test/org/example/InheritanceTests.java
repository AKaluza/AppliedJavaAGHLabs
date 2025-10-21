package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class InheritanceTests {
    // Person Tests
    @Test
    @DisplayName("org.example.Person class is abstract")
    public void testPersonIsAbstract() {
        Assertions.assertTrue(Modifier.isAbstract(Person.class.getModifiers()));
    }

    @Test
    @DisplayName("org.example.Person has an address")
    public void testPersonHasAddress() {
        var field = Assertions.assertDoesNotThrow(() -> Person.class.getDeclaredField("address"));
        Assertions.assertEquals(Address.class, field.getType());
    }

    @Test
    @DisplayName("org.example.Person has an firstName")
    public void testPersonHasFirstName() {
        var field = Assertions.assertDoesNotThrow(() -> Person.class.getDeclaredField("firstName"));
        Assertions.assertEquals(String.class, field.getType());
    }

    @Test
    @DisplayName("org.example.Person has an lastName")
    public void testPersonHasLastName() {
        var field = Assertions.assertDoesNotThrow(() -> Person.class.getDeclaredField("lastName"));
        Assertions.assertEquals(String.class, field.getType());
    }

    // Emplyee tests
    @Test
    @DisplayName("org.example.Employee class is a subclass of org.example.Person class")
    public void testEmployeeIsPersonSubclass() {
        Assertions.assertTrue(Person.class.isAssignableFrom(Employee.class));
    }

    @Test
    @DisplayName("org.example.Employee class has Salary")
    public void testEmployHasSalary() {
        var field = Assertions.assertDoesNotThrow(() -> Employee.class.getDeclaredField("salary"));
        Assertions.assertEquals(int.class, field.getType());
    }

    @Test
    @DisplayName("org.example.Employee class constructor")
    public void testEmployConstructor() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        String firstName = "Jan";
        String lastName = "kowalski";
        Address myAddress = new Address(address, postCode, city);
        int salary = 1000;
        Assertions.assertDoesNotThrow(() -> new Employee(firstName, lastName, myAddress, salary), "Exception thrown when constructor Employee(firstName,lastName,myAddress,salary)");
    }

    @Test
    @DisplayName("org.example.Employee promote")
    public void testEmployPromote() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        String firstName = "Jan";
        String lastName = "kowalski";
        Address myAddress = new Address(address, postCode, city);
        int salary = 1000;
        Employee me = new Employee(firstName, lastName, myAddress, salary);
        me.promote(100);
        Assertions.assertEquals(me.getSalary(), 1100);
    }


    //// Address tests
    @Test
    @DisplayName("org.example.Address adress")
    public void testAdressadress() {
        var field = Assertions.assertDoesNotThrow(() -> Address.class.getDeclaredField("address"));
        Assertions.assertEquals(String.class, field.getType());
    }

    @Test
    @DisplayName("org.example.Address postCode")
    public void testAddressPostCode() {
        var field = Assertions.assertDoesNotThrow(() -> Address.class.getDeclaredField("postCode"));
        Assertions.assertEquals(String.class, field.getType());
    }

    @Test
    @DisplayName("org.example.Address city")
    public void testAddressCity() {
        var field = Assertions.assertDoesNotThrow(() -> Address.class.getDeclaredField("city"));
        Assertions.assertEquals(String.class, field.getType());
    }

    @Test
    @DisplayName("org.example.Address city")
    public void testConstructorAndadressGetters() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        Address myAddress = new Address(address, postCode, city);
        Assertions.assertEquals(myAddress.getAddress(), address);
    }

    @Test
    @DisplayName("Create Address instance")
    public void testAddressConstructor() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        Assertions.assertDoesNotThrow(() -> new Address(address, postCode, city), "Exception thrown when constructor Address(address, postCode, city)");
    }

    @Test
    @DisplayName("org.example.Address city")
    public void testAddressadressGetters() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        Address myAddress = new Address(address, postCode, city);
        Assertions.assertEquals(myAddress.getAddress(), address);
    }

    @Test
    @DisplayName("org.example.Address postcode")
    public void testAddresspostCodeGetters() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        Address myAddress = new Address(address, postCode, city);
        Assertions.assertEquals(myAddress.getPostCode(), postCode);
    }

    @Test
    @DisplayName("org.example.Address city")
    public void testAddresscityGetters() {
        String address = "al Mickiewicza 1234";
        String postCode = "32-084";
        String city = "Kraków";
        Address myAddress = new Address(address, postCode, city);
        Assertions.assertEquals(myAddress.getCity(), city);
    }

}