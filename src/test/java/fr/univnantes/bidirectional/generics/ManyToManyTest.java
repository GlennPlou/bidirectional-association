package fr.univnantes.bidirectional.generics;

import fr.univnantes.bidirectional.generics.ManyToMany.GenericCourse;
import fr.univnantes.bidirectional.generics.ManyToMany.GenericStudent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ManyToManyTest {

    private GenericCourse course1, course2, course3;
    private GenericStudent student1, student2, student3;

    @BeforeEach
    void setup() {
        course1 = new GenericCourse();
        course2 = new GenericCourse();
        course3 = new GenericCourse();

        student1 = new GenericStudent();
        student2 = new GenericStudent();
        student3 = new GenericStudent();
    }

    @Test
    void addCourseTest() {
        student1.addCourse(course1);

        assertTrue(student1.getCourses().contains(course1));
        assertTrue(course1.getStudents().contains(student1));
        assertEquals(1, student1.getCourses().size());
        assertEquals(1, course1.getStudents().size());
    }

    @Test
    void addManyCoursesTest() {
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

        assertTrue(student1.getCourses().contains(course1));
        assertTrue(student1.getCourses().contains(course2));
        assertTrue(student1.getCourses().contains(course3));
        assertTrue(course1.getStudents().contains(student1));
        assertTrue(course2.getStudents().contains(student1));
        assertTrue(course3.getStudents().contains(student1));
        assertEquals(3, student1.getCourses().size());
        assertEquals(1, course1.getStudents().size());
        assertEquals(1, course2.getStudents().size());
        assertEquals(1, course3.getStudents().size());
    }

    @Test
    void addStudentTest() {
        course1.addStudent(student1);

        assertTrue(student1.getCourses().contains(course1));
        assertTrue(course1.getStudents().contains(student1));
        assertEquals(1, student1.getCourses().size());
        assertEquals(1, course1.getStudents().size());
    }

    @Test
    void addManyStudentsTest() {
        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);

        assertTrue(course1.getStudents().contains(student1));
        assertTrue(course1.getStudents().contains(student2));
        assertTrue(course1.getStudents().contains(student3));
        assertTrue(student1.getCourses().contains(course1));
        assertTrue(student2.getCourses().contains(course1));
        assertTrue(student3.getCourses().contains(course1));
        assertEquals(3, course1.getStudents().size());
        assertEquals(1, student1.getCourses().size());
        assertEquals(1, student2.getCourses().size());
        assertEquals(1, student3.getCourses().size());
    }

    @Test
    void addAllStudentsToAllCoursesTest() {
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

        student2.addCourse(course1);
        student2.addCourse(course2);
        student2.addCourse(course3);

        student3.addCourse(course1);
        student3.addCourse(course2);
        student3.addCourse(course3);

        assertTrue(student1.getCourses().contains(course1));
        assertTrue(student1.getCourses().contains(course2));
        assertTrue(student1.getCourses().contains(course3));
        assertTrue(student2.getCourses().contains(course1));
        assertTrue(student2.getCourses().contains(course2));
        assertTrue(student2.getCourses().contains(course3));
        assertTrue(student3.getCourses().contains(course1));
        assertTrue(student3.getCourses().contains(course2));
        assertTrue(student3.getCourses().contains(course3));

        assertTrue(course1.getStudents().contains(student1));
        assertTrue(course1.getStudents().contains(student2));
        assertTrue(course1.getStudents().contains(student3));
        assertTrue(course2.getStudents().contains(student1));
        assertTrue(course2.getStudents().contains(student2));
        assertTrue(course2.getStudents().contains(student3));
        assertTrue(course3.getStudents().contains(student1));
        assertTrue(course3.getStudents().contains(student2));
        assertTrue(course3.getStudents().contains(student3));

        assertEquals(3, student1.getCourses().size());
        assertEquals(3, student2.getCourses().size());
        assertEquals(3, student3.getCourses().size());
        assertEquals(3, course1.getStudents().size());
        assertEquals(3, course2.getStudents().size());
        assertEquals(3, course3.getStudents().size());
    }

    @Test
    void removeStudentTest() {
        course1.addStudent(student1);
        course1.removeStudent(student1);

        assertTrue(course1.getStudents().isEmpty());
        assertTrue(student1.getCourses().isEmpty());
    }

    @Test
    void removeManyStudentsTest() {
        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);

        course1.removeStudent(student1);

        assertFalse(course1.getStudents().contains(student1));
        assertTrue(course1.getStudents().contains(student2));
        assertTrue(course1.getStudents().contains(student3));
        assertEquals(2, course1.getStudents().size());
        assertTrue(student1.getCourses().isEmpty());
        assertTrue(student2.getCourses().contains(course1));
        assertTrue(student3.getCourses().contains(course1));


        course1.removeStudent(student2);

        assertFalse(course1.getStudents().contains(student2));
        assertTrue(course1.getStudents().contains(student3));
        assertEquals(1, course1.getStudents().size());
        assertTrue(student1.getCourses().isEmpty());
        assertTrue(student2.getCourses().isEmpty());
        assertTrue(student3.getCourses().contains(course1));

        course1.removeStudent(student3);

        assertFalse(course1.getStudents().contains(student3));
        assertTrue(course1.getStudents().isEmpty());
        assertTrue(student1.getCourses().isEmpty());
        assertTrue(student2.getCourses().isEmpty());
        assertTrue(student3.getCourses().isEmpty());
    }

    @Test
    void removeCourseTest() {
        student1.addCourse(course1);
        student1.removeCourse(course1);

        assertTrue(student1.getCourses().isEmpty());
        assertTrue(course1.getStudents().isEmpty());
    }

    @Test
    void removeManyCoursesTest() {
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

        student1.removeCourse(course1);

        assertFalse(student1.getCourses().contains(course1));
        assertTrue(student1.getCourses().contains(course2));
        assertTrue(student1.getCourses().contains(course3));
        assertEquals(2, student1.getCourses().size());
        assertTrue(course1.getStudents().isEmpty());
        assertTrue(course2.getStudents().contains(student1));
        assertTrue(course3.getStudents().contains(student1));

        student1.removeCourse(course2);

        assertFalse(student1.getCourses().contains(course2));
        assertTrue(student1.getCourses().contains(course3));
        assertEquals(1, student1.getCourses().size());
        assertTrue(course1.getStudents().isEmpty());
        assertTrue(course2.getStudents().isEmpty());
        assertTrue(course3.getStudents().contains(student1));

        student1.removeCourse(course3);

        assertFalse(student1.getCourses().contains(course3));
        assertTrue(student1.getCourses().isEmpty());
        assertTrue(course1.getStudents().isEmpty());
        assertTrue(course2.getStudents().isEmpty());
        assertTrue(course3.getStudents().isEmpty());
    }
}
