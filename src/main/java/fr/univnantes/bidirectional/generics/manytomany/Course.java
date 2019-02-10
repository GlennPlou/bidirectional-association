package fr.univnantes.bidirectional.generics.manytomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.impl.ManyToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a course, taught by a teacher and followed by students, for the example of a many-to-many
 * bidirectional association.
 * A course has a reference to many students.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class Course implements BidirectionalReference {

    /**
     * The reference to all the students of this course.
     */
    private final BidirectionalAssociation<Student> students;

    /**
     * Constructor of Course. Initializes properties of this class. Initializes the students reference with "this", and
     * an ArrayList.
     */
    Course() {
        students = new ManyToMany<Student>(this, new ArrayList<Student>());
    }

    /**
     * Returns the students reference.
     * @return this.students.
     */
    public BidirectionalAssociation getReference() {
        return this.students;
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

    /**
     * Returns the list of students of this course.
     * @return the list of students of this course.
     */
    List<Student> getStudents() {
        return this.students.getList();
    }
}
