package fr.univnantes.bidirectional.manyToMany;

public class Student {
    private String name;
    private Integer age;
    private StudentReferenceToCourses courses;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.courses = new StudentReferenceToCourses(this);
    }

    public StudentReferenceToCourses getCourses() {
        return this.courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }
}
