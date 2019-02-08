package fr.univnantes.bidirectional.generics.manytomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.impl.ManyToMany;

import java.util.ArrayList;
import java.util.List;

class Course implements BidirectionalReference {

    private final BidirectionalAssociation<Course, Student> students;

    Course() {
        students = new ManyToMany<Course, Student>(this, new ArrayList<Student>());
    }

    public BidirectionalAssociation getReference() {
        return this.students;
    }

    void addStudent(Student student) {
        this.students.add(student);
    }

    void removeStudent(Student student) {
        this.students.remove(student);
    }

    List<Student> getStudents() {
        return this.students.getList();
    }
}
