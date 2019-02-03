package fr.univnantes.bidirectional.oneToOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class EventTest {

    private Event event1;
    private Task task1, task2;

    @BeforeEach
    void setup() {
        event1 = new Event(1,"event1","test");

        task1 = new Task("task1");
        task2 = new Task("task2");
    }

    @Test
    void setTaskTest() {
        event1.setTask(task1);
        assertTrue(event1.getTask().isSet());
        assertTrue(task1.getEvent().isSet());
        assertSame(task1, event1.getTask().getTask());

        event1.setTask(task2);
        assertTrue(event1.getTask().isSet());
        assertTrue(task2.getEvent().isSet());
        assertFalse(task1.getEvent().isSet());
        assertSame(task2, event1.getTask().getTask());
    }

    @Test
    void unsetTaskTest() {
        event1.setTask(task1);
        event1.unsetTask();

        assertFalse(event1.getTask().isSet());
        assertFalse(task1.getEvent().isSet());
    }
}
