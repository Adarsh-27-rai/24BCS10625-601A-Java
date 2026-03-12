package com.course.exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        System.out.println("Course not found");
    }
}
