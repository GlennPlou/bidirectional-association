package fr.univnantes.bidirectional.generics;

import java.util.ArrayList;
import java.util.List;

public abstract class ManyAssociations<T extends BidirectionalReference, U extends BidirectionalReference> implements BidirectionalAssociation<T, U> {
    protected T t;
    protected List<U> uList;

    protected ManyAssociations() {

    }

    protected ManyAssociations(T element) {
        this.t = element;
        this.uList = new ArrayList<U>();
    }

    protected <E extends List<U>> ManyAssociations(T element, E newList) {
        this.t = element;
        if (!newList.isEmpty()) {
            newList.clear();
        }
        this.uList = newList;
    }

    public void basicAdd(U element) {
        this.uList.add(element);
    }

    public void basicRemove(U element) {
        this.uList.remove(element);
    }

    public abstract void remove(U element);

    public abstract void add(U element);

    public List<U> getList() {
        return this.uList;
    }

    public boolean isSet() {
        return false;
    }

    public void basicSet(U element) {}
    public void basicUnset() {}
    public void unset() {}
    public void set(U element) {}

    public U getU() {
        return null;
    }
}
