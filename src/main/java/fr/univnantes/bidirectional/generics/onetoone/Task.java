package fr.univnantes.bidirectional.generics.onetoone;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;
import fr.univnantes.bidirectional.generics.impl.OneToOne;

class Task implements BidirectionalReference {
    private final SingleAssociation<Event> event;

    Task() {
        event = new OneToOne<Event>(this);
    }

    public BidirectionalAssociation getReference() {
        return event;
    }

    void setEvent(Event event) {
        this.event.set(event);
    }

    void unsetEvent() {
        this.event.unset();
    }

    Event getEvent() {
        return this.event.getU();
    }

}
