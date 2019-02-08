package fr.univnantes.bidirectional.samplecourse.onetoone;

class TaskReferenceToEvent {

    private Event event;
    private final Task task;

    TaskReferenceToEvent(Task task) {
        this.task = task;
    }

    boolean isSet() {
        return this.event != null;
    }

    void basicSet(Event event) {
        this.event = event;
    }

    void basicUnset() {
        this.event = null;
    }

    void unset() {
        if (this.isSet()) {
            this.event.getTask().basicUnset();
            this.basicUnset();
        }
    }

    void set(Event event) {
        if (event.getTask().isSet()) {
            event.getTask().unset();
        }
        this.unset();
        event.getTask().basicSet(this.task);
        this.basicSet(event);
    }

    Event getEvent() {
        return event;
    }
}
