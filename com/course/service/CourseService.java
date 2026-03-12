package com.course.service;

import java.util.ArrayList;
import java.io.*;
import com.course.model.*;
import com.course.exception.*;

public class CourseService {
    ArrayList<Course> courses = new ArrayList<Course>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enrollStudent(int courseId, Student s) throws CourseFullException, CourseNotFoundException, DuplicateEnrollmentException {
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == courseId) {
                course = courses.get(i);
                break;
            }
        }

        if (course == null) {
            throw new CourseNotFoundException();
        }

        // check for duplicate enrollment using accessor with normal loop
        ArrayList<Student> list = course.getEnrolledStudents();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentId() == s.getStudentId()) {
                throw new DuplicateEnrollmentException();
            }
        }

        // verify seat availability through getter
        if (list.size() >= course.getMaxSeats()) {
            throw new CourseFullException();
        }
        list.add(s);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("courses.txt", true));
            bw.write(courseId + " " + s.getStudentId() + " " + s.getStudentName());
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }

    public void viewCourses() {
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).display();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("courses.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }
}