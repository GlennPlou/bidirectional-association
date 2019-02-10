package fr.univnantes.bidirectional.samplecourse.onetoone;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing an event, such as a concert or festival, for the example of a one-to-one bidirectional association.
 * An event has a reference to a single task.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
@Getter
@Setter
class Event {

    /**
     * The ID of this event.
     */
    private Integer id;

    /**
     * The name and location of this event.
     */
    private String name, location;

    /**
     * The reference to the unique task.
     */
    private EventReferenceToTask task;

    /**
     * Constructor of Event. Initializes properties of this class. Initializes the task reference with "this".
     * @param id the ID of this event.
     * @param name the name of this event.
     * @param location the location of this event.
     */
    Event(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.task = new EventReferenceToTask(this);
    }

    /**
     * Set the new task for this event, using the task reference.
     * @param task the new task.
     */
    void setTask(Task task) {
        this.task.set(task);
    }

    /**
     * Returns the task reference.
     * @return this.task.
     */
    EventReferenceToTask getTask() {
        return this.task;
    }

    /**
     * Removes the reference of the existing task.
     */
    void unsetTask() {
        this.task.unset();
    }
}
