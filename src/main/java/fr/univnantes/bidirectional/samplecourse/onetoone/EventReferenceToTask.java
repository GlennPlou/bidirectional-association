package fr.univnantes.bidirectional.samplecourse.onetoone;

class EventReferenceToTask {

    private Task task;
    private final Event event;

    EventReferenceToTask(Event event) {
        this.event = event;
    }

    boolean isSet() {
        return this.task != null;
    }

    void basicSet(Task task) {
        this.task = task;
    }

    void basicUnset() {
        this.task = null;
    }

    void unset() {
        if (this.isSet()) {
            this.task.getEvent().basicUnset();
            this.basicUnset();
        }
    }

    void set(Task task) {
        if (task.getEvent().isSet()) {
            task.getEvent().unset();
        }
        this.unset();
        task.getEvent().basicSet(this.event);
        this.basicSet(task);
    }

    Task getTask() {
        return this.task;
    }
}
