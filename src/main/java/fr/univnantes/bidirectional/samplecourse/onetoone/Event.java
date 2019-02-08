package fr.univnantes.bidirectional.samplecourse.onetoone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Event {
    private Integer id;
    private String name, location;
    private EventReferenceToTask task;

    Event(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.task = new EventReferenceToTask(this);
    }

    void setTask(Task task) {
        this.task.set(task);
    }

    EventReferenceToTask getTask() {
        return this.task;
    }

    void unsetTask() {
        this.task.unset();
    }
}
