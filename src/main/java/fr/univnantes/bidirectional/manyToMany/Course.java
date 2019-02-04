package fr.univnantes.bidirectional.manyToMany;

public class Course {
    private String name;
    private Integer id;
    private CourseReferenceToStudents students;

    public Course(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.students = new CourseReferenceToStudents(this);
    }

    public CourseReferenceToStudents getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
}
