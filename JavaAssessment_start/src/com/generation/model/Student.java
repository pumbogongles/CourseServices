package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO - DONE - Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if (this.enrolledCourses.containsKey(course.getCode())) {       // check if HashMap enrolledCourses contains the input code
            return false;                                               // return false if course code already exist within enrolledCourses
        } else {                                                        // if input course code doesn't exist:
            EnrolledCourse newCourse = new EnrolledCourse(course);      // create a new instance of EnrolledCourse called newCourse
            this.enrolledCourses.put(course.getCode(), newCourse);      // insert input course code and content being newCourse
        }
        return true;

    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO - DONE - return a Hashmap of all the enrolledCourses
        return this.enrolledCourses;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO - DONE - set the grade for the enrolled Course
        this.getEnrolledCourses().get(courseCode).setGrade(grade);


    }

    public Course findCourseById( String courseId )
    {
        //TODO - DONE - return a Course from the course Id
        return this.enrolledCourses.get(courseId);
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade

       return null;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}\nEnrolled Courses: \n" + getEnrolledCourses() + ""; //adding the function getEnrolledCourses() behind for printing everything Student.java is called
    }
}
