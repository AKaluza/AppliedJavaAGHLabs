package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

public class CompositeTests {
    @Test
    public void testEmployeeIsAbstract() {
        final int modifiers = Employee.class.getModifiers();
        Assertions.assertTrue(Modifier.isAbstract(modifiers), "Employee class is not abstract");
    }

    @Test
    public void testEmployeeHasCorrectConstructor() {
        final var declaredConstructor =
                Assertions.assertDoesNotThrow(() ->
                                Employee
                                        .class
                                        .getDeclaredConstructor(String.class, int.class),
                        "Employee class does not have constructor with (String, int) arguments");

        final int modifiers = declaredConstructor.getModifiers();
        Assertions.assertFalse(Modifier.isPrivate(modifiers), "Employee class constructor must not be private");
    }

    @Test
    public void testEmployeeHasOnlyTwoPrivateFields() {
        Assertions.assertEquals(2,
                Employee
                        .class
                        .getDeclaredFields().length,
                "Employee class does not have only two fields"
        );

        final var nameField =
                Assertions
                        .assertDoesNotThrow(() ->
                                        Employee
                                                .class
                                                .getDeclaredField("name"),
                                "Employee class does not have name field"
                        );

        final var salaryField =
                Assertions
                        .assertDoesNotThrow(() ->
                                        Employee
                                                .class
                                                .getDeclaredField("salary"),
                                "Employee class does not have salary field"
                        );

        Assertions.assertTrue(Modifier.isPrivate(nameField.getModifiers()), "Employee field name is not private");
        Assertions.assertTrue(Modifier.isFinal(nameField.getModifiers()), "Employee field name is not final");
        Assertions.assertTrue(Modifier.isPrivate(salaryField.getModifiers()), "Employee salary name is not private");
        Assertions.assertTrue(Modifier.isFinal(salaryField.getModifiers()), "Employee salary name is not final");
    }

    @Test
    public void testManagerIsSubclassOfEmployee() {
        Assertions.assertTrue(Employee.class.isAssignableFrom(Manager.class), "Manager is not subclass of Employee");
    }

    @Test
    public void testDeveloperIsSubclassOfEmployee() {
        Assertions.assertTrue(Employee.class.isAssignableFrom(Developer.class), "Developer is not subclass of Employee");
    }

    @Test
    public void testIfDeveloperHasCorrectConstructor() {
        Assertions.assertDoesNotThrow(() ->
                        Developer
                                .class
                                .getDeclaredConstructor(String.class, int.class),
                "Developer class does not have constructor with (String, int) arguments"
        );
    }

    @Test
    public void testIfManagerHasCorrectConstructor() {
        Assertions.assertDoesNotThrow(() ->
                        Manager
                                .class
                                .getDeclaredConstructor(String.class, int.class),
                "Manager class does not have constructor with (String, int) arguments"
        );
    }

    @Test
    public void testIfDeveloperIsInitializedCorrectly() {
        Developer john = Assertions.assertDoesNotThrow(() ->
                        Developer
                                .class
                                .getDeclaredConstructor(String.class, int.class)
                                .newInstance("John", 10000),
                "Instance of Developer class with arguments (John, 10000) was not created"
        );

        final var getSalary =
                Assertions.assertDoesNotThrow(() ->
                                Developer.class.getMethod("getSalary"),
                        "Developer class does not have getSalary method"
                );

        final var getName =
                Assertions.assertDoesNotThrow(() ->
                                Developer.class.getMethod("getName"),
                        "Developer class does not have getSalary method"
                );

        Assertions.assertEquals(10000, Assertions.assertDoesNotThrow(() -> getSalary.invoke(john)), "John's salary is not 10000");
        Assertions.assertEquals("John", Assertions.assertDoesNotThrow(() -> getName.invoke(john)), "Developer's name is not John");
    }

    @Test
    public void testSolution() {
        Developer john = Assertions.assertDoesNotThrow(() ->
                Developer
                        .class
                        .getConstructor(String.class, int.class)
                        .newInstance("John", 10000)
        );

        Developer david = Assertions.assertDoesNotThrow(() ->
                Developer
                        .class
                        .getConstructor(String.class, int.class)
                        .newInstance("David", 15000)
        );

        Developer michael = Assertions.assertDoesNotThrow(() ->
                Developer
                        .class
                        .getConstructor(String.class, int.class)
                        .newInstance("Michael", 15000)
        );

        Manager manager1 = Assertions.assertDoesNotThrow(() ->
                Manager
                        .class
                        .getConstructor(String.class, int.class)
                        .newInstance("Daniel", 25000)
        );

        Method addMethod =
                Assertions.assertDoesNotThrow(() ->
                                Manager
                                        .class
                                        .getMethod("add", Employee.class),
                        "Manager class does not have add method with Employee argument");

        Assertions.assertDoesNotThrow(() ->
                        addMethod
                                .invoke(manager1, david),
                "Cannot invoke Manager add method with Employee argument"
        );

        Assertions.assertDoesNotThrow(() ->
                        addMethod
                                .invoke(manager1, john),
                "Cannot invoke Manager add method with Employee argument"
        );

        final var findMethod =
                Assertions.assertDoesNotThrow(() ->
                                Manager
                                        .class
                                        .getMethod("find", String.class),
                        "Manager class does not have find method with developer name argument"
                );
        final var findJohn =
                Assertions.assertDoesNotThrow(() ->
                                findMethod.invoke(manager1, "John"),
                        "Cannot call Manager find method with developer name argument"
                );

        final var findDavid =
                Assertions.assertDoesNotThrow(() ->
                                findMethod.invoke(manager1, "David"),
                        "Cannot call Manager find method with developer name argument"
                );

        final var findMichael =
                Assertions.assertDoesNotThrow(() ->
                                findMethod.invoke(manager1, "Michael"),
                        "Cannot call Manager find method with Developer argument"
                );

        Assertions.assertNotNull(findJohn, "developer John not found");
        Assertions.assertNotNull(findDavid, "developer David not found");
        Assertions.assertNull(findMichael, "developer Michael found");
    }
}