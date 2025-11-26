package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestGetStudentNames {
    private static List<Student> testStudents;

    @BeforeEach
    public void before() throws IOException {
        testStudents = LoadStudents.loadStudentsFromFile();
    }

    @Test
    public void testGetStudentNames() {
        //Call the method being tested
        List<String> actualStudentNames = GetStudentNames.getStudentNames(testStudents);
        //Make a list of expectedNames
        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("Kasia");
        expectedNames.add("Basia");
        expectedNames.add("Piotr");
        expectedNames.add("Krzysztof");
        expectedNames.add("Gosia");
        expectedNames.add("Artur");
        expectedNames.add("Marcin");
        expectedNames.add("Marta");

        //Assert actual names returned by getStudentNames is the same as the list of expectedNames
        Assertions.assertEquals(expectedNames, actualStudentNames);
    }
}
