package fr.univnantes.bidirectional.generics.OneToOne;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;

public class GenericEvent implements BidirectionalReference {
    private BidirectionalAssociation<GenericEvent, GenericTask> task;

    public GenericEvent() {
        task = new OneToOne<GenericEvent, GenericTask>(this);
    }

    public BidirectionalAssociation getReference() {
        return task;
    }

    public void setTask(GenericTask task) {
        this.task.set(task);
    }

    public void unsetTask() {
        this.task.unset();
    }

    public GenericTask getTask() {
        return this.task.getU();
    }

}
