package com.course.model;

public class Student {
    private int studentId;
    private String studentName;

    public Student(int id, String name) {
        studentId = id;
        studentName = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}