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

    public void enrollStudent(int courseId, Student s)
            throws CourseFullException, CourseNotFoundException, DuplicateEnrollmentException {

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

        for (int i = 0; i < course.students.size(); i++) {

            if (course.students.get(i).studentId == s.studentId) {
                throw new DuplicateEnrollmentException();
            }

        }

        if (course.students.size() >= course.maxSeats) {
            throw new CourseFullException();
        }

        course.students.add(s);

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("courses.txt", true));

            bw.write(courseId + " " + s.studentId + " " + s.studentName);
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