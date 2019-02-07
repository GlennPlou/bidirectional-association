package fr.univnantes.bidirectional.generics;

import fr.univnantes.bidirectional.generics.OneToOne.GenericEvent;
import fr.univnantes.bidirectional.generics.OneToOne.GenericTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class OneToOneTest {
    private GenericTask task1, task2;
    private GenericEvent event1, event2;

    @BeforeEach
    void setup() {
        task1 = new GenericTask();
        task2 = new GenericTask();

        event1 = new GenericEvent();
        event2 = new GenericEvent();
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
