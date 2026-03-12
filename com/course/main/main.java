package com.course.main;

import com.course.model.*;
import com.course.service.*;
import com.course.exception.Exception.java;

public class Main {

    public static void main(String[] args) {

        CourseService service = new CourseService();

        Course c1 = new Course(1, "Java", 2);
        service.addCourse(c1);

        try {

            Student s1 = new Student(101, "Adarsh");
            Student s2 = new Student(102, "Rahul");

            service.enrollStudent(1, s1);
            service.enrollStudent(1, s2);

            service.viewCourses();

        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}