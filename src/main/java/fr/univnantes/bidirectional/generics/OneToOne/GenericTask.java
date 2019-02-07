package fr.univnantes.bidirectional.generics.OneToOne;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;

public class GenericTask implements BidirectionalReference {
    private BidirectionalAssociation<GenericTask, GenericEvent> event;

    public GenericTask() {
        event = new OneToOne<GenericTask, GenericEvent>(this);
    }

    public BidirectionalAssociation getReference() {
        return event;
    }

    public void setEvent(GenericEvent event) {
        this.event.set(event);
    }

    public void unsetEvent() {
        this.event.unset();
    }

    public GenericEvent getEvent() {
        return this.event.getU();
    }

}
