package fr.univnantes.bidirectional.generics.onetoone;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;
import fr.univnantes.bidirectional.generics.impl.OneToOne;

/**
 * Class representing a task to do for en event, for the example of a one-to-one bidirectional association.
 * A task has a reference to a single event.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class Task implements BidirectionalReference {

    /**
     * The reference to the unique event.
     */
    private final SingleAssociation<Event> event;

    /**
     * Constructor of Task. Initializes properties of this class. Initializes the event reference with "this".
     */
    Task() {
        event = new OneToOne<Event>(this);
    }

    /**
     * Returns the event reference.
     * @return this.event.
     */
    public BidirectionalAssociation getReference() {
        return event;
    }

    /**
     * Set the new event of this task, using the event reference.
     * @param event the new event.
     */
    void setEvent(Event event) {
        this.event.set(event);
    }

    /**
     * Removes the reference of the existing event.
     */
    void unsetEvent() {
        this.event.unset();
    }

    /**
     * Returns the event of this task.
     * @return the event of this task.
     */
    Event getEvent() {
        return this.event.getU();
    }

}
