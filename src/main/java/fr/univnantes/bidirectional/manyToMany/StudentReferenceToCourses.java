package fr.univnantes.bidirectional.manyToMany;

import java.util.ArrayList;
import java.util.List;

public class StudentReferenceToCourses {
    private List<Course> courses = new ArrayList<Course>();
    private Student student;

    public StudentReferenceToCourses(Student student) {
        this.student = student;
    }

    public void basicAdd(Course course) {
        this.courses.add(course);
    }

    public void basicRemove(Course course) {
        this.courses.remove(course);
    }

    public void remove(Course course) {
        if (course.getStudents().getStudents().contains(this.student)) {
            course.getStudents().basicRemove(this.student);
            this.basicRemove(course);
        }
    }

    public void add(Course course) {
        course.getStudents().basicAdd(this.student);
        this.basicAdd(course);
    }

    public List<Course> getCourses() {
        return courses;
    }
}
