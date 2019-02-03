package fr.univnantes.bidirectional.oneToOne;

public class Task {
    private String title;
    private TaskReferenceToEvent event;

    public Task(String title) {
        this.title = title;
        this.event = new TaskReferenceToEvent(this);
    }

    public void setEvent(Event event) {
        this.event.set(event);
    }

    public TaskReferenceToEvent getEvent() {
        return event;
    }

    public void unsetEvent() {
        this.event.unset();
    }
}
