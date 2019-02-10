package fr.univnantes.bidirectional.generics.manytomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;
import fr.univnantes.bidirectional.generics.impl.ManyToMany;

import java.util.List;

class Student implements BidirectionalReference  {

    private final ManyAssociation<Course> courses;

    Student() {
        courses = new ManyToMany<Course>(this);
    }

    public BidirectionalAssociation getReference() {
        return this.courses;
    }

    void addCourse(Course course) {
        this.courses.add(course);
    }

    void removeCourse(Course course) {
        this.courses.remove(course);
    }

    List<Course> getCourses() {
        return this.courses.getList();
    }
}
