package fr.univnantes.bidirectional.generics;

public class GenericTask implements Reference {
    private OneToOne<GenericTask, GenericEvent> event;

    public GenericTask() {
        event = new OneToOne<GenericTask, GenericEvent>(this);
    }

    public OneToOne<GenericTask, GenericEvent> getReference() {
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
