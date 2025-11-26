package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestFindMinStudentAge {
    private static List<Student> testStudents;

    @BeforeEach
    public void before() throws IOException {
        testStudents = LoadStudents.loadStudentsFromFile();
    }

    @RepeatedTest(9)
    //Make this test pass by implementing FindMinStudentAge.findMinAge
    public void findMinAge() {
        Assertions.assertEquals(19, FindMinStudentAge.findMinAge(testStudents));
    }
}
