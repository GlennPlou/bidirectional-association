package fr.univnantes.bidirectional.oneToOne;

public class TaskReferenceToEvent {

    private Event event;
    private Task task;

    public TaskReferenceToEvent(Task task) {
        this.task = task;
    }

    public boolean isSet() {
        return this.event != null;
    }

    public void basicSet(Event event) {
        this.event = event;
    }

    public void basicUnset() {
        this.event = null;
    }

    public void unset() {
        if (this.isSet()) {
            this.event.getTask().basicUnset();
            this.basicUnset();
        }
    }

    public void set(Event event) {
        if (event.getTask().isSet()) {
            event.getTask().unset();
        }
        this.unset();
        event.getTask().basicSet(this.task);
        this.basicSet(event);
    }

    public Event getEvent() {
        return event;
    }
}
