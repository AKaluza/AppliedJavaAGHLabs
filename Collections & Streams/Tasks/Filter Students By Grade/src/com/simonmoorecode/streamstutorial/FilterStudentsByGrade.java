package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStudentsByGrade {
    public static List<Student> filterByGrade(List<Student> students, final double gradeThreshold) {
        return students.stream().filter(s -> s.getOverallGrading() > gradeThreshold).collect(Collectors.toList());
    }
}
