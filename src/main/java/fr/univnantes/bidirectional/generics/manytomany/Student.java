package fr.univnantes.bidirectional.generics.manytomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;
import fr.univnantes.bidirectional.generics.impl.ManyToMany;

import java.util.List;

/**
 * Class representing a student taking courses, for the example of a many-to-many bidirectional association.
 * A student has a reference to many courses.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class Student implements BidirectionalReference  {

    /**
     * The reference to all the courses of this student.
     */
    private final ManyAssociation<Course> courses;

    /**
     * Constructor of Student. Initializes properties of this class. Initializes the courses reference with "this".
     */
    Student() {
        courses = new ManyToMany<Course>(this);
    }

    /**
     * Returns the courses reference.
     * @return this.courses.
     */
    public BidirectionalAssociation getReference() {
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

    /**
     * Returns the list of courses of this student.
     * @return the list of courses of this student.
     */
    List<Course> getCourses() {
        return this.courses.getList();
    }
}
