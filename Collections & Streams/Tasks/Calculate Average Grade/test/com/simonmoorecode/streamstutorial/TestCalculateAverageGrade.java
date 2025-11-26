package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestCalculateAverageGrade {
    private static List<Student> testStudents;

    @BeforeEach
    public void before() throws IOException {
        testStudents = LoadStudents.loadStudentsFromFile();
    }

    @Test
    //Make this test pass by implementing CalculateAverageGrade.findAverageGrade.
    public void testCalculateAverageGrade() {
        Assertions.assertEquals(84.25, CalculateAverageGrade.findAverageGrade(testStudents).getAsDouble(), 0);
    }

}
