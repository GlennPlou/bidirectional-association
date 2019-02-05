package fr.univnantes.bidirectional.generics;

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
        assertSame(event1, task2.getEvent());


        assertFalse(task1.getReference().isSet()); //TODO: Check that we do "unset u.getReference.basicUnset()" BEFORE "this.basicUnset();" (+ Note that some this.t.getReference().basicUnset();" is totally useless.)
        assertSame(task2, event1.getTask());
    }
}
