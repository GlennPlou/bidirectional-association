package fr.univnantes.bidirectional.samplecourse.onetoone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class TaskTest {

    private Task task1;
    private Event event1, event2;

    @BeforeEach
    void setup() {
        task1 = new Task("task1");

        event1 = new Event(1, "event1", "test1");
        event2 = new Event(2, "event2", "test2");
    }

    @Test
    void setEventTest() {
        task1.setEvent(event1);
        assertTrue(task1.getEvent().isSet());
        assertTrue(event1.getTask().isSet());
        assertSame(event1, task1.getEvent().getEvent());

        task1.setEvent(event2);
        assertTrue(task1.getEvent().isSet());
        assertTrue(event2.getTask().isSet());
        assertFalse(event1.getTask().isSet());
        assertSame(event2, task1.getEvent().getEvent());
    }

    @Test
    void unsetEventTest() {
        task1.setEvent(event1);
        task1.unsetEvent();

        assertFalse(task1.getEvent().isSet());
        assertFalse(event1.getTask().isSet());
    }
}
