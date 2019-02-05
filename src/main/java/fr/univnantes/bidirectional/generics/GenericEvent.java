package fr.univnantes.bidirectional.generics;

public class GenericEvent implements Reference {
    private OneToOne<GenericEvent, GenericTask> task;

    public GenericEvent() {
        task = new OneToOne<GenericEvent, GenericTask>(this);
    }

    public OneToOne<GenericEvent, GenericTask> getReference() {
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
