package fr.univnantes.bidirectional.samplecourse.manytomany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Student {
    private String name;
    private Integer age;
    private StudentReferenceToCourses courses;

    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.courses = new StudentReferenceToCourses(this);
    }

    StudentReferenceToCourses getCourses() {
        return this.courses;
    }

    void addCourse(Course course) {
        this.courses.add(course);
    }

    void removeCourse(Course course) {
        this.courses.remove(course);
    }
}
