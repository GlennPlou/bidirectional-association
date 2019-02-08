package fr.univnantes.bidirectional.samplecourse.manytomany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Course {
    private String name;
    private Integer id;
    private CourseReferenceToStudents students;

    Course(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.students = new CourseReferenceToStudents(this);
    }

    CourseReferenceToStudents getStudents() {
        return students;
    }

    void addStudent(Student student) {
        this.students.add(student);
    }

    void removeStudent(Student student) {
        this.students.remove(student);
    }


}
