package fr.univnantes.bidirectional.samplecourse.manytomany;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing a course, taught by a teacher and followed by students, for the example of a many-to-many
 * bidirectional association.
 * A course has a reference to many students.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
@Getter
@Setter
class Course {

    /**
     * The name of this course.
     */
    private String name;

    /**
     * The ID of this course.
     */
    private Integer id;

    /**
     * The reference to all the students of this course.
     */
    private CourseReferenceToStudents students;

    /**
     * Constructor of Course. Initializes properties of this class. Initializes the students reference with "this".
     * @param name the name of this course.
     * @param id the ID of this course.
     */
    Course(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.students = new CourseReferenceToStudents(this);
    }

    /**
     * Returns the students reference.
     * @return this.students.
     */
    CourseReferenceToStudents getStudents() {
        return students;
    }

    /**
     * Add a new student for this course, using the students reference.
     * @param student the new student to add.
     */
    void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Removes the reference to a student.
     * @param student the student to remove.
     */
    void removeStudent(Student student) {
        this.students.remove(student);
    }
}
