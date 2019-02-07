package fr.univnantes.bidirectional.generics.ManyToMany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;

import java.util.List;

public class GenericStudent implements BidirectionalReference  {

    private BidirectionalAssociation<GenericStudent, GenericCourse> courses;

    public GenericStudent() {
        courses = new ManyToMany<GenericStudent, GenericCourse>(this);
    }

    public BidirectionalAssociation getReference() {
        return this.courses;
    }

    public void addCourse(GenericCourse course) {
        this.courses.add(course);
    }

    public void removeCourse(GenericCourse course) {
        this.courses.remove(course);
    }

    public List<GenericCourse> getCourses() {
        return this.courses.getList();
    }
}
