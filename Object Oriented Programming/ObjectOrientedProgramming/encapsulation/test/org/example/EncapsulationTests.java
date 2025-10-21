package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class EncapsulationTests {
    @Test
    @DisplayName("MyDate must have only private fields")
    public void testDateUserHasOnlyPrivateFields() throws NoSuchFieldException {
        var fields = MyDate.class.getDeclaredFields();
        var names = Arrays.stream(fields).map(Field::getName).toList();

        Assertions.assertTrue(names.contains("day"), "day is missing");
        Assertions.assertTrue(names.contains("month"), "month is missing");
        Assertions.assertTrue(names.contains("year"), "year is missing");

        Assertions.assertTrue(Modifier.isPrivate(MyDate.class.getDeclaredField("day").getModifiers()), "day is not private");
        Assertions.assertTrue(Modifier.isPrivate(MyDate.class.getDeclaredField("month").getModifiers()), "month is not private");
        Assertions.assertTrue(Modifier.isPrivate(MyDate.class.getDeclaredField("year").getModifiers()), "year is not private");
    }


    @Test
    @DisplayName("MyDate has getters")
    public void testDateUserHasGetters() throws NoSuchMethodException {
        var names = Arrays.stream(MyDate.class.getMethods()).map(Method::getName).toList();

        Assertions.assertTrue(names.contains("getDay"), "getDay is missing");
        Assertions.assertTrue(names.contains("getMonth"), "getMonth is missing");
        Assertions.assertTrue(names.contains("getYear"), "getYear is missing");

        Assertions.assertTrue(MyDate.class.getMethod("getDay").getParameterCount() == 0, "getDay is not parameter-less");
        Assertions.assertTrue(MyDate.class.getMethod("getMonth").getParameterCount() == 0, "getMonth is not parameter-less");
        Assertions.assertTrue(MyDate.class.getMethod("getYear").getParameterCount() == 0, "getYear is not parameter-less");
    }

    @Test
    @DisplayName("MyDate has setters")
    public void testDateUserHasSetters() throws NoSuchFieldException, IllegalAccessException {
        final var myDate = new MyDate();

        final var methodSetDay = Assertions.assertDoesNotThrow(() -> myDate.getClass().getMethod("setDay", int.class), "no setter for day");
        final var methodSetMonth = Assertions.assertDoesNotThrow(() -> myDate.getClass().getMethod("setMonth", int.class), "no setter for month");
        final var methodSetYear = Assertions.assertDoesNotThrow(() -> myDate.getClass().getMethod("setYear", int.class), "no setter for year");

        Assertions.assertDoesNotThrow(() -> methodSetDay.invoke(myDate, 6));
        Assertions.assertDoesNotThrow(() -> methodSetMonth.invoke(myDate, 01));
        Assertions.assertDoesNotThrow(() -> methodSetYear.invoke(myDate, 2021));

        final Field actualDay = myDate.getClass().getDeclaredField("day");
        actualDay.setAccessible(true);
        Assertions.assertEquals(actualDay.get(myDate), 6, "Days didn't match");

        final Field actualMonth = myDate.getClass().getDeclaredField("month");
        actualMonth.setAccessible(true);
        Assertions.assertEquals(actualMonth.get(myDate), 1, "Months didn't match");

        final Field actualYear = myDate.getClass().getDeclaredField("year");
        actualYear.setAccessible(true);
        Assertions.assertEquals(actualYear.get(myDate), 2021, "Years didn't match");
    }
}