package com.simonmoorecode.streamstutorial;

import com.simonmoorecode.streamstutorial.domain.City;
import com.simonmoorecode.streamstutorial.domain.Student;
import com.simonmoorecode.streamstutorial.domain.Subject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LoadStudents {
    public static List<Student> loadStudentsFromFile() {
        try {
            final var path = Paths.get(Objects.requireNonNull(LoadStudents.class.getResource("/students.csv")).toURI());
            final var students = Files.readAllLines(path).stream().map(LoadStudents::mapToStudent).collect(Collectors.toList());
            return students;
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private static Student mapToStudent(String fileLine) {
        String[] parsedLine = fileLine.split(",");
        return new Student(parsedLine[0],
                Integer.parseInt(parsedLine[1]),
                City.valueOf(parsedLine[2]),
                Double.parseDouble(parsedLine[3]),
                Arrays.stream(parsedLine).skip(4).map(Subject::valueOf).collect(Collectors.toList()));
    }
}
