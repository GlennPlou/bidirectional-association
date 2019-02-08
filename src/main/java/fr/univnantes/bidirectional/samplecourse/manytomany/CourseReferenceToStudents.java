package fr.univnantes.bidirectional.samplecourse.manytomany;

import java.util.ArrayList;
import java.util.List;

class CourseReferenceToStudents {
    private final List<Student> students = new ArrayList<Student>();
    private final Course course;

    CourseReferenceToStudents(Course course) {
        this.course = course;
    }

    void basicAdd(Student student) {
        this.students.add(student);
    }

    void basicRemove(Student student) {
        this.students.remove(student);
    }

    void remove(Student student) {
        if (student.getCourses().getCourses().contains(this.course)) {
            student.getCourses().basicRemove(this.course);
            this.basicRemove(student);
        }
    }

    void add(Student student) {
        student.getCourses().basicAdd(this.course);
        this.basicAdd(student);
    }

    List<Student> getStudents() {
        return students;
    }
}
