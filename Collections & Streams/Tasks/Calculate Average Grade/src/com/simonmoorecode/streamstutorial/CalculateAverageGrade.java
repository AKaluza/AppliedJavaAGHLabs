package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;

import java.util.List;
import java.util.OptionalDouble;

public class CalculateAverageGrade {
    public static OptionalDouble findAverageGrade(List<Student> students) {
        return students.stream().mapToDouble(Student::getOverallGrading).average();
    }
}
