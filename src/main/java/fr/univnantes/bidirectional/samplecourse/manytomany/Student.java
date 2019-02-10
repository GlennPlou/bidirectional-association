package fr.univnantes.bidirectional.samplecourse.manytomany;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing a student taking courses, for the example of a many-to-many bidirectional association.
 * A student has a reference to many courses.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
@Getter
@Setter
class Student {

    /**
     * The name of this student.
     */
    private String name;

    /**
     * The age of this student.
     */
    private Integer age;

    /**
     * The reference to all the courses of this student.
     */
    private StudentReferenceToCourses courses;

    /**
     * Constructor of Student. Initializes properties of this class. Initializes the courses reference with "this".
     * @param name the name of this student.
     * @param age the name of this student.
     */
    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.courses = new StudentReferenceToCourses(this);
    }

    /**
     * Returns the courses reference.
     * @return this.courses.
     */
    StudentReferenceToCourses getCourses() {
        return this.courses;
    }

    /**
     * Add a new course for this student, using the courses reference.
     * @param course the new course to add.
     */
    void addCourse(Course course) {
        this.courses.add(course);
    }

    /**
     * Removes the reference to a course.
     * @param course the course to remove.
     */
    void removeCourse(Course course) {
        this.courses.remove(course);
    }
}
