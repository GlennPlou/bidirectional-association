package fr.univnantes.bidirectional.samplecourse.manytomany;

import java.util.ArrayList;
import java.util.List;

class StudentReferenceToCourses {
    private final List<Course> courses = new ArrayList<Course>();
    private final Student student;

    StudentReferenceToCourses(Student student) {
        this.student = student;
    }

    void basicAdd(Course course) {
        this.courses.add(course);
    }

    void basicRemove(Course course) {
        this.courses.remove(course);
    }

    void remove(Course course) {
        if (course.getStudents().getStudents().contains(this.student)) {
            course.getStudents().basicRemove(this.student);
            this.basicRemove(course);
        }
    }

    void add(Course course) {
        course.getStudents().basicAdd(this.student);
        this.basicAdd(course);
    }

    List<Course> getCourses() {
        return courses;
    }
}
