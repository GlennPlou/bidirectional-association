package fr.univnantes.bidirectional.samplecourse.onetoone;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing a task to do for en event, for the example of a one-to-one bidirectional association.
 * A task has a reference to a single event.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
@Getter
@Setter
class Task {

    /**
     * The title of this task.
     */
    private String title;

    /**
     * The reference to the unique event.
     */
    private TaskReferenceToEvent event;

    /**
     * Constructor of Task. Initializes properties of this class. Initializes the event reference with "this".
     * @param title the title of this task.
     */
    Task(String title) {
        this.title = title;
        this.event = new TaskReferenceToEvent(this);
    }

    /**
     * Set the new event of this task, using the event reference.
     * @param event
     */
    void setEvent(Event event) {
        this.event.set(event);
    }

    /**
     * Returns the event reference.
     * @return this.event.
     */
    TaskReferenceToEvent getEvent() {
        return event;
    }

    /**
     * Removes the reference of the existing event.
     */
    void unsetEvent() {
        this.event.unset();
    }
}
