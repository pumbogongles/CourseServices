package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO - DONE - Add new student to the students hashmap
        this.students.put(student.getId(), student);        //using .put() to insert student. Parameters are student.getId,
                                                            //                                                         ^ inherited from Person Class to obtain a person/student's ID
    }

    public Student findStudent( String studentId )
    {
        //TODO - DONE - Find the student from the Hashmap with the student id
        return this.students.get(studentId);

    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO - DONE - Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        boolean enrolled = this.students.get(studentId).enrollToCourse(course);     // create a variable enrolled as a boolean, and assign it the same value as this.students.get(studentId).enrollToCourse(course) that is performed in Student Class file
        if (!enrolled) {                                                            // if enrolled returns false, print out something
            System.out.println("Already enrolled into course");
        }

    }

    public void showSummary()
    {
        //TODO - DONE - Loop through students hashmap and print out students' details including the enrolled courses
        System.out.println("Student Summary Info: ");
        for (String key: students.keySet()) {           //loops through all data within the students HashMap
            Student studentSummary = students.get(key);
            System.out.println(studentSummary);
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO - DONE? - return a HashMap of all the enrolledCourses
        HashMap<String, EnrolledCourse> getAllEnrolledCourse = student.getEnrolledCourses();
        return getAllEnrolledCourse;
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO - DONE - return the course enrolled by the student from the course Id
        //return this.students.get(student).getEnrolledCourses().get(courseId);
        return this.students.get(student).findCourseById(courseId);
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
