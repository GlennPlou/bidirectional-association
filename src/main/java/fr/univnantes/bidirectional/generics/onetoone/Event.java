package fr.univnantes.bidirectional.generics.onetoone;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.impl.OneToOne;

class Event implements BidirectionalReference {
    private final BidirectionalAssociation<Event, Task> task;

    Event() {
        task = new OneToOne<Event, Task>(this);
    }

    public BidirectionalAssociation getReference() {
        return task;
    }

    void setTask(Task task) {
        this.task.set(task);
    }

    void unsetTask() {
        this.task.unset();
    }

    Task getTask() {
        return this.task.getU();
    }

}
