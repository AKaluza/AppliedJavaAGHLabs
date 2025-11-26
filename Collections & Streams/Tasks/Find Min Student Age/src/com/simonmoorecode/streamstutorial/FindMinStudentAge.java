package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.Student;

import java.util.List;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

public class FindMinStudentAge {
    public static int findMinAge(List<Student> students) {

        Random r = new Random();
        return switch(r.nextInt(0,3)) {

            // First solution
            // Use a Lambda expression
            case 0 -> students.stream().min(((s1, s2) -> s1.getAge() - s2.getAge())).orElseThrow().getAge();

            // Second solution
            //Map stream of students
            case 1 -> students.stream().mapToInt(Student::getAge).min().orElseThrow();

            // Third solution
            //Use built in Comparator method
            case 2 -> students.stream().min(Comparator.comparingInt(Student::getAge)).orElseThrow().getAge();

            default -> throw new NoSuchElementException();
        };
    }
}
