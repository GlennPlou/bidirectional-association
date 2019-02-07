package fr.univnantes.bidirectional.generics.ManyToMany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;

import java.util.List;

public class GenericCourse implements BidirectionalReference {

    private BidirectionalAssociation<GenericCourse, GenericStudent> students;

    public GenericCourse() {
        students = new ManyToMany<GenericCourse, GenericStudent>(this);
    }

    public BidirectionalAssociation getReference() {
        return this.students;
    }

    public void addStudent(GenericStudent student) {
        this.students.add(student);
    }

    public void removeStudent(GenericStudent student) {
        this.students.remove(student);
    }

    public List<GenericStudent> getStudents() {
        return this.students.getList();
    }
}
