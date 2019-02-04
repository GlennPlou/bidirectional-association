package fr.univnantes.bidirectional.manyToMany;

import java.util.ArrayList;
import java.util.List;

public class CourseReferenceToStudents {
    private List<Student> students = new ArrayList<Student>();
    private Course course;

    public CourseReferenceToStudents(Course course) {
        this.course = course;
    }

    public void basicAdd(Student student) {
        this.students.add(student);
    }

    public void basicRemove(Student student) {
        this.students.remove(student);
    }

    public void remove(Student student) {
        if (student.getCourses().getCourses().contains(this.course)) {
            student.getCourses().basicRemove(this.course);
            this.basicRemove(student);
        }
    }

    public void add(Student student) {
        student.getCourses().basicAdd(this.course);
        this.basicAdd(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
