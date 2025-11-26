package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.City;
import com.simonmoorecode.streamstutorial.domain.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountStudentsByCity {
    public static Map<City, Long> getMapOfCityToNumberOfStudents(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
    }
}
