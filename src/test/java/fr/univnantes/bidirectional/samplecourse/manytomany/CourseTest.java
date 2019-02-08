package fr.univnantes.bidirectional.samplecourse.manytomany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class CourseTest {

    private Course myCourseA, myCourseB;
    private Student student1, student2, student3;

    @BeforeEach
    void setup() {
        myCourseA = new Course("Computer Science", 1234);
        myCourseB = new Course("Biology", 5678);

        student1 = new Student("John", 19);
        student2 = new Student("Ben", 20);
        student3 = new Student("Mark", 19);
    }

    @Test
    void addStudentTest() {
        myCourseA.addStudent(student1);
        assertTrue(myCourseA.getStudents().getStudents().contains(student1));
        assertEquals(1, myCourseA.getStudents().getStudents().size());
    }

    @Test
    void addManyStudentsTest() {
        myCourseA.addStudent(student1);
        myCourseA.addStudent(student2);
        myCourseA.addStudent(student3);

        assertTrue(myCourseA.getStudents().getStudents().contains(student1));
        assertTrue(myCourseA.getStudents().getStudents().contains(student2));
        assertTrue(myCourseA.getStudents().getStudents().contains(student3));

        assertEquals(3, myCourseA.getStudents().getStudents().size());

        assertTrue(student1.getCourses().getCourses().contains(myCourseA));
        assertTrue(student2.getCourses().getCourses().contains(myCourseA));
        assertTrue(student3.getCourses().getCourses().contains(myCourseA));
    }

    @Test
    void addManyStudentsOnManyCoursesTest() {
        myCourseA.addStudent(student1);
        myCourseA.addStudent(student2);
        myCourseA.addStudent(student3);

        myCourseB.addStudent(student1);
        myCourseB.addStudent(student2);
        myCourseB.addStudent(student3);

        assertTrue(myCourseA.getStudents().getStudents().contains(student1));
        assertTrue(myCourseA.getStudents().getStudents().contains(student2));
        assertTrue(myCourseA.getStudents().getStudents().contains(student3));
        assertEquals(3, myCourseA.getStudents().getStudents().size());

        assertTrue(myCourseB.getStudents().getStudents().contains(student1));
        assertTrue(myCourseB.getStudents().getStudents().contains(student2));
        assertTrue(myCourseB.getStudents().getStudents().contains(student3));
        assertEquals(3, myCourseB.getStudents().getStudents().size());


        assertTrue(student1.getCourses().getCourses().contains(myCourseA));
        assertTrue(student1.getCourses().getCourses().contains(myCourseB));
        assertEquals(2, student1.getCourses().getCourses().size());

        assertTrue(student2.getCourses().getCourses().contains(myCourseA));
        assertTrue(student2.getCourses().getCourses().contains(myCourseB));
        assertEquals(2, student2.getCourses().getCourses().size());

        assertTrue(student3.getCourses().getCourses().contains(myCourseA));
        assertTrue(student3.getCourses().getCourses().contains(myCourseB));
        assertEquals(2, student3.getCourses().getCourses().size());
    }

    @Test
    void removeStudentTest() {
        myCourseA.addStudent(student1);
        myCourseA.removeStudent(student1);

        assertFalse(myCourseA.getStudents().getStudents().contains(student1));
        assertTrue(myCourseA.getStudents().getStudents().isEmpty());
    }

    @Test
    void removeManyStudentsTest() {
        myCourseA.addStudent(student1);
        myCourseA.addStudent(student2);
        myCourseA.addStudent(student3);

        myCourseA.removeStudent(student1);

        assertEquals(2, myCourseA.getStudents().getStudents().size());
        assertTrue(myCourseA.getStudents().getStudents().contains(student2));
        assertTrue(myCourseA.getStudents().getStudents().contains(student3));

        myCourseA.removeStudent(student2);

        assertEquals(1, myCourseA.getStudents().getStudents().size());
        assertTrue(myCourseA.getStudents().getStudents().contains(student3));

        myCourseA.removeStudent(student3);

        assertTrue(myCourseA.getStudents().getStudents().isEmpty());
    }
}