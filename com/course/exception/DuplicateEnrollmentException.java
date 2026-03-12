package com.course.exception;

public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException() {
        System.out.println("Student already enrolled");
    }
}
