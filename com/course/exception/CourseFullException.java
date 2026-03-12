package com.course.exception;

public class CourseFullException extends Exception {
    public CourseFullException() {
        System.out.println("Course is full");
    }
}
