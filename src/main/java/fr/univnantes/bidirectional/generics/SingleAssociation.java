package fr.univnantes.bidirectional.generics;

import java.util.List;

public abstract class SingleAssociation<T extends BidirectionalReference, U extends BidirectionalReference> implements BidirectionalAssociation<T, U> {
    protected T t;
    protected U u;

    protected SingleAssociation() {

    }

    protected SingleAssociation(T element) {
        this.t = element;
    }

    public boolean isSet() {
        return this.u != null;
    }

    public void basicSet(U element) {
        this.u = element;
    }

    public void basicUnset() {
        this.u = null;
    }

    public abstract void unset();

    public abstract void set(U element);

    public U getU() {
        return this.u;
    }

    public final void basicAdd(U element) {}
    public final void basicRemove(U element) {}
    public final void remove(U element) {}
    public final void add(U element) {}

    public final List<U> getList() {
        return null;
    }
}
