package fr.univnantes.bidirectional.samplecourse.onetoone;

/**
 * Class representing the association between an event and its task. (Event --> Task association)
 * An event has a reference to a single task.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class EventReferenceToTask {

    /**
     * The task that belongs to the event we are managing.
     */
    private Task task;

    /**
     * The event we are managing.
     */
    private final Event event;

    /**
     * Constructor of EventReferenceToTask. Initializes the event we are managing.
     * @param event the event we want to manage.
     */
    EventReferenceToTask(Event event) {
        this.event = event;
    }

    /**
     * Check if the task is set.
     * @return true if a task is set.
     */
    boolean isSet() {
        return this.task != null;
    }

    /**
     * Makes a simple assignment of the task.
     * @param task the task to assigns.
     */
    void basicSet(Task task) {
        this.task = task;
    }

    /**
     * Makes a null assignments to the task.
     */
    void basicUnset() {
        this.task = null;
    }

    /**
     * Breaks the association Task --> (old) Event and then Event --> Task.
     */
    void unset() {
        if (this.isSet()) {
            this.task.getEvent().basicUnset();
            this.basicUnset();
        }
    }

    /**
     * Set the new task reference by breaking old association if necessary, and using the "basicAdd/Set" functions
     * (notion and important order in this bi-directional association model).
     * @param task the new task.
     */
    void set(Task task) {
        if (task.getEvent().isSet()) {
            task.getEvent().unset();
        }
        this.unset();
        task.getEvent().basicSet(this.event);
        this.basicSet(task);
    }

    /**
     * Returns the task associated to the event.
     * @return this.task.
     */
    Task getTask() {
        return this.task;
    }
}
