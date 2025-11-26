package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;
import com.simonmoorecode.streamstutorial.domain.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestGetDistinctListOfSubjects {
    private static List<Student> testStudents;

    @BeforeEach
    public void before() throws IOException {
        testStudents = LoadStudents.loadStudentsFromFile();
    }

    @Test
    public void testGetDistinctListOfSubjects() {
        List<Subject> subjects = GetDistinctListOfSubjects.getDistinctListOfSubjects(testStudents);

        //Build a list of the expected values
        List<Subject> expectedSubjects = new LinkedList<>();
        expectedSubjects.add(Subject.MATHEMATICS);
        expectedSubjects.add(Subject.COMPUTER_SCIENCE);
        expectedSubjects.add(Subject.PHYSICS);
        expectedSubjects.add(Subject.ART_HISTORY);
        expectedSubjects.add(Subject.JOURNALISM);

        //assert the list of subjects returned is the same as the list of expected subjects
        Assertions.assertEquals(expectedSubjects, subjects);
    }
}
