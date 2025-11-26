package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.City;
import com.simonmoorecode.streamstutorial.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCountStudentsByCity {
    private static List<Student> testStudents;

    @BeforeEach
    public void before() throws IOException {
        testStudents = LoadStudents.loadStudentsFromFile();
    }

    @Test
    /*
    Make this test pass by implementig CountStudentsByCity.getMapOfCityToNumberOfStudents
     */
    public void testCountStudentsByCity() {
        Map<City, Long> cityToNumberOfStudents = CountStudentsByCity.getMapOfCityToNumberOfStudents(testStudents);
        Assertions.assertNotNull(cityToNumberOfStudents.get(City.Warsaw));
        Assertions.assertNotNull(cityToNumberOfStudents.get(City.Krakow));
        Assertions.assertNotNull(cityToNumberOfStudents.get(City.Poznan));

        Assertions.assertEquals(3, cityToNumberOfStudents.get(City.Krakow).longValue());
        Assertions.assertEquals(3, cityToNumberOfStudents.get(City.Warsaw).longValue());
        Assertions.assertEquals(2, cityToNumberOfStudents.get(City.Poznan).longValue());
    }
}
