package fr.univnantes.bidirectional.manyToMany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student studentA, studentB;
    private Course course1, course2, course3;

    @BeforeEach
    void setup() {
        studentA = new Student("Steve", 19);
        studentB = new Student("Mike", 18);

        course1 = new Course("Computer Science", 1234);
        course2 = new Course("Chemistry", 5678);
        course3 = new Course("English", 91011);
    }

    @Test
    void addCourseTest() {
        studentA.addCourse(course1);
        assertTrue(studentA.getCourses().getCourses().contains(course1));
        assertEquals(1, studentA.getCourses().getCourses().size());
    }

    @Test
    void addManyCoursesTest() {
        studentA.addCourse(course1);
        studentA.addCourse(course2);
        studentA.addCourse(course3);

        assertTrue(studentA.getCourses().getCourses().contains(course1));
        assertTrue(studentA.getCourses().getCourses().contains(course2));
        assertTrue(studentA.getCourses().getCourses().contains(course3));

        assertEquals(3, studentA.getCourses().getCourses().size());

        assertTrue(course1.getStudents().getStudents().contains(studentA));
        assertTrue(course2.getStudents().getStudents().contains(studentA));
        assertTrue(course3.getStudents().getStudents().contains(studentA));
    }

    @Test
    void addManyCoursesToManyStudentTest() {
        studentA.addCourse(course1);
        studentA.addCourse(course2);
        studentA.addCourse(course3);

        studentB.addCourse(course1);
        studentB.addCourse(course2);
        studentB.addCourse(course3);

        assertTrue(studentA.getCourses().getCourses().contains(course1));
        assertTrue(studentA.getCourses().getCourses().contains(course2));
        assertTrue(studentA.getCourses().getCourses().contains(course3));
        assertEquals(3, studentA.getCourses().getCourses().size());

        assertTrue(studentB.getCourses().getCourses().contains(course1));
        assertTrue(studentB.getCourses().getCourses().contains(course2));
        assertTrue(studentB.getCourses().getCourses().contains(course3));
        assertEquals(3, studentB.getCourses().getCourses().size());


        assertTrue(course1.getStudents().getStudents().contains(studentA));
        assertTrue(course1.getStudents().getStudents().contains(studentB));
        assertEquals(2, course1.getStudents().getStudents().size());

        assertTrue(course2.getStudents().getStudents().contains(studentA));
        assertTrue(course2.getStudents().getStudents().contains(studentB));
        assertEquals(2, course2.getStudents().getStudents().size());

        assertTrue(course3.getStudents().getStudents().contains(studentA));
        assertTrue(course3.getStudents().getStudents().contains(studentB));
        assertEquals(2, course3.getStudents().getStudents().size());
    }

    @Test
    void removeCourseTest() {
        studentA.addCourse(course1);
        studentA.removeCourse(course1);
        assertFalse(studentA.getCourses().getCourses().contains(course1));
        assertTrue(studentA.getCourses().getCourses().isEmpty());
    }

    @Test
    void removeManyCoursesTest() {
        studentA.addCourse(course1);
        studentA.addCourse(course2);
        studentA.addCourse(course3);

        studentA.removeCourse(course1);

        assertTrue(studentA.getCourses().getCourses().contains(course2));
        assertTrue(studentA.getCourses().getCourses().contains(course3));
        assertEquals(2, studentA.getCourses().getCourses().size());

        studentA.removeCourse(course2);


        assertTrue(studentA.getCourses().getCourses().contains(course3));
        assertEquals(1, studentA.getCourses().getCourses().size());

        studentA.removeCourse(course3);

        assertTrue(studentA.getCourses().getCourses().isEmpty());
    }
}