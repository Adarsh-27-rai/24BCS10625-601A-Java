package com.course.model;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private String courseName;
    private int maxSeats;
    private ArrayList<Student> enrolledStudents;

    public Course(int id, String name, int seats) {
        courseId = id;
        courseName = name;
        maxSeats = seats;
        enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public String getCourseName() {
        return courseName;
    }

    // pluralised getter for clarity
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void display() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Max Seats: " + maxSeats);
        System.out.println("Enrolled Students: " + enrolledStudents.size());
    }
}