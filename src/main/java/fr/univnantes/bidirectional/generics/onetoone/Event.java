package fr.univnantes.bidirectional.generics.onetoone;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.impl.OneToOne;

/**
 * Class representing an event, such as a concert or festival, for the example of a one-to-one bidirectional association.
 * An event has a reference to a single task.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class Event implements BidirectionalReference {

    /**
     * The reference to the unique task.
     */
    private final BidirectionalAssociation<Task> task;

    /**
     * Constructor of Event. Initializes properties of this class. Initializes the task reference with "this".
     */
    Event() {
        task = new OneToOne<Task>(this);
    }

    /**
     * Returns the task reference.
     * @return this.task.
     */
    public BidirectionalAssociation getReference() {
        return task;
    }

    /**
     * Set the new task for this event, using the task reference.
     * @param task the new task.
     */
    void setTask(Task task) {
        this.task.set(task);
    }

    /**
     * Removes the reference of the existing task.
     */
    void unsetTask() {
        this.task.unset();
    }

    /**
     * Returns the task of this event.
     * @return the task of this event.
     */
    Task getTask() {
        return this.task.getU();
    }

}
