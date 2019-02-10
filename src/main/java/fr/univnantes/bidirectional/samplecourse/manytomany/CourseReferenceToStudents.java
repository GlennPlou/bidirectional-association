package fr.univnantes.bidirectional.samplecourse.manytomany;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the association between a course and its students. (Course --> Students association)
 * A course has a reference to many students.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class CourseReferenceToStudents {

    /**
     * The list of students that belong to the course we are managing.
     */
    private final List<Student> students = new ArrayList<Student>();

    /**
     * The course we are managing.
     */
    private final Course course;

    /**
     * Constructor of CourseReferenceToStudents. Initializes the course we are managing.
     * @param course the course we want to manage.
     */
    CourseReferenceToStudents(Course course) {
        this.course = course;
    }

    /**
     * Makes a simple addition to the list.
     * @param student the student to add.
     */
    void basicAdd(Student student) {
        this.students.add(student);
    }

    /**
     * Makes a simple removal from the list.
     * @param student the student to remove.
     */
    void basicRemove(Student student) {
        this.students.remove(student);
    }

    /**
     * Breaks the association Student --> Course and then Course --> Student.
     * @param student the student to remove.
     */
    void remove(Student student) {
        if (student.getCourses().getCourses().contains(this.course)) {
            student.getCourses().basicRemove(this.course);
            this.basicRemove(student);
        }
    }

    /**
     * Add a new student to the students reference by adding the course we are managing to the student's courses, and
     * using the "basicAdd" functions.
     * @param student the student to add.
     */
    void add(Student student) {
        student.getCourses().basicAdd(this.course);
        this.basicAdd(student);
    }

    /**
     * Returns the list of students associated to the course.
     * @return this.students.
     */
    List<Student> getStudents() {
        return students;
    }
}
