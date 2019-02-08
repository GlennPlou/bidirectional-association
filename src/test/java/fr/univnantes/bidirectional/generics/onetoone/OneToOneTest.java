package fr.univnantes.bidirectional.generics.onetoone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class OneToOneTest {
    private Task task1, task2;
    private Event event1, event2;

    @BeforeEach
    void setup() {
        task1 = new Task();
        task2 = new Task();

        event1 = new Event();
        event2 = new Event();
    }

    @Test
    void setTaskTest() {
        event1.setTask(task1);
        assertTrue(event1.getReference().isSet());
        assertTrue(task1.getReference().isSet());
        assertSame(task1, event1.getTask());

        assertTrue(event1.getReference().getU().getReference().isSet());

        event1.setTask(task2);
        assertTrue(event1.getReference().isSet());
        assertTrue(task2.getReference().isSet());
        assertFalse(task1.getReference().isSet());
        assertSame(task2, event1.getTask());
        assertSame(event1, task2.getEvent());
    }

    @Test
    void unsetTaskTest() {
        event1.setTask(task1);
        event1.unsetTask();

        assertFalse(event1.getReference().isSet());
        assertFalse(task1.getReference().isSet());
    }

    @Test
    void setEventTest() {
        task1.setEvent(event1);
        assertTrue(task1.getReference().isSet());
        assertTrue(event1.getReference().isSet());
        assertSame(event1, task1.getEvent());
        assertSame(task1, event1.getTask());

        task1.setEvent(event2);
        assertTrue(task1.getReference().isSet());
        assertTrue(event2.getReference().isSet());
        assertFalse(event1.getReference().isSet());
        assertSame(event2, task1.getEvent());
        assertSame(task1, event2.getTask());
    }

    @Test
    void unsetEventTest() {
        task1.setEvent(event1);
        task1.unsetEvent();

        assertFalse(task1.getReference().isSet());
        assertFalse(event1.getReference().isSet());
    }
}
