package fr.univnantes.bidirectional.oneToOne;

public class Event {
    private Integer id;
    private String name, location;
    private EventReferenceToTask task;

    public Event(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.task = new EventReferenceToTask(this);
    }

    public void setTask(Task task) {
        this.task.set(task);
    }

    public EventReferenceToTask getTask() {
        return this.task;
    }

    public void unsetTask() {
        this.task.unset();
    }
}
