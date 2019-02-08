package fr.univnantes.bidirectional.samplecourse.onetoone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Task {
    private String title;
    private TaskReferenceToEvent event;

    Task(String title) {
        this.title = title;
        this.event = new TaskReferenceToEvent(this);
    }

    void setEvent(Event event) {
        this.event.set(event);
    }

    TaskReferenceToEvent getEvent() {
        return event;
    }

    void unsetEvent() {
        this.event.unset();
    }
}
