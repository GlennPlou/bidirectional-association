package fr.univnantes.bidirectional.oneToOne;

public class EventReferenceToTask {

    private Task task;
    private Event event;

    public EventReferenceToTask(Event event) {
        this.event = event;
    }

    public boolean isSet() {
        return this.task != null;
    }

    public void basicSet(Task task) {
        this.task = task;
    }

    public void basicUnset() {
        this.task = null;
    }

    public void unset() {
        if (this.isSet()) {
            this.task.getEvent().basicUnset();
            this.basicUnset();
        }
    }

    public void set(Task task) {
        if (task.getEvent().isSet()) {
            task.getEvent().unset();
        }
        this.unset();
        task.getEvent().basicSet(this.event);
        this.basicSet(task);
    }

    public Task getTask() {
        return this.task;
    }
}
