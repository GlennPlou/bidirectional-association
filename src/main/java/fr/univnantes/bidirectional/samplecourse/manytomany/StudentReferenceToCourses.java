package fr.univnantes.bidirectional.samplecourse.manytomany;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the association between a student and its courses. (Student --> Courses association)
 * A student has a reference to many courses.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class StudentReferenceToCourses {

    /**
     * The list of courses that belong to the student we are managing.
     */
    private final List<Course> courses = new ArrayList<Course>();

    /**
     * The student we are managing.
     */
    private final Student student;

    /**
     * Constructor of StudentReferenceToCourses. Initializes the student we are managing.
     * @param student the student we want to manage.
     */
    StudentReferenceToCourses(Student student) {
        this.student = student;
    }

    /**
     * Makes a simple addition to the list.
     * @param course the course to add.
     */
    void basicAdd(Course course) {
        this.courses.add(course);
    }

    /**
     * Makes a simple removal from the list.
     * @param course the course to remove.
     */
    void basicRemove(Course course) {
        this.courses.remove(course);
    }

    /**
     * Breaks the association Course --> Student and then Student --> Course.
     * @param course the course to remove.
     */
    void remove(Course course) {
        if (course.getStudents().getStudents().contains(this.student)) {
            course.getStudents().basicRemove(this.student);
            this.basicRemove(course);
        }
    }

    /**
     * Add a new course to the courses reference by adding the student we are managing to the course's student, and
     * using the "basicAdd" functions.
     * @param course the course to add.
     */
    void add(Course course) {
        course.getStudents().basicAdd(this.student);
        this.basicAdd(course);
    }

    /**
     * Returns the list of courses associated to the student.
     * @return this.courses.
     */
    List<Course> getCourses() {
        return courses;
    }
}
