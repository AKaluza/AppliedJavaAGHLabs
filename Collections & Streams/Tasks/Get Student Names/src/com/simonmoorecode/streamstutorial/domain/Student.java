package com.simonmoorecode.streamstutorial.domain;

import java.util.List;

public class Student {

    private String name;
    private int age;
    private City city;
    private double overallGrading;
    private List<Subject> subjects;

    public Student(String name, int age, City city, double overallGrading, List<Subject> subjects) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.overallGrading = overallGrading;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public City getCity() {
        return city;
    }

    public double getOverallGrading() {
        return overallGrading;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", overallGrading=" + overallGrading +
                ", subjects=" + subjects +
                '}';
    }
}
