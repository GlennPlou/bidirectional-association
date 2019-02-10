package fr.univnantes.bidirectional.samplecourse.onetoone;

/**
 * Class representing the association between a task and its event. (Task --> Event association)
 * A task has a reference to a single event.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class TaskReferenceToEvent {

    /**
     * The event that belongs to the task we are managing.
     */
    private Event event;

    /**
     * The task we are managing.
     */
    private final Task task;

    /**
     * Constructor of TaskReferenceToEvent. Initializes the task we are managing.
     * @param task the task we want to manage.
     */
    TaskReferenceToEvent(Task task) {
        this.task = task;
    }

    /**
     * Check if the event is set.
     * @return true if an event is set.
     */
    boolean isSet() {
        return this.event != null;
    }

    /**
     * Makes a simple assignment of the event.
     * @param event the event to assigns.
     */
    void basicSet(Event event) {
        this.event = event;
    }

    /**
     * Makes a null assignments to the folder.
     */
    void basicUnset() {
        this.event = null;
    }

    /**
     * Breaks the association Event --> (old) Task and then Task --> Event.
     */
    void unset() {
        if (this.isSet()) {
            this.event.getTask().basicUnset();
            this.basicUnset();
        }
    }

    /**
     * Set the new event reference by breaking old association if necessary, and using the "basicAdd/Set" functions,
     * (notion and important order in this bi-directional association model).
     * @param event the new event.
     */
    void set(Event event) {
        if (event.getTask().isSet()) {
            event.getTask().unset();
        }
        this.unset();
        event.getTask().basicSet(this.task);
        this.basicSet(event);
    }

    /**
     * Returns the event associated to the task.
     * @return this.event.
     */
    Event getEvent() {
        return event;
    }
}
