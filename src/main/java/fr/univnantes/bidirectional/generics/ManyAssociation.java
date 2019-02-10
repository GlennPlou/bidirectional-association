package fr.univnantes.bidirectional.generics;

import java.util.ArrayList;
import java.util.List;

public abstract class ManyAssociation<U extends BidirectionalReference> implements BidirectionalAssociation<U> {
    protected BidirectionalReference t;
    private List<U> uList;

    protected ManyAssociation() {

    }

    protected ManyAssociation(BidirectionalReference element) {
        this.t = element;
        this.uList = new ArrayList<U>();
    }

    protected <E extends List<U>> ManyAssociation(BidirectionalReference element, E newList) {
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

    public final boolean isSet() {
        return false;
    }

    public final void basicSet(U element) {}
    public final void basicUnset() {}
    public final void unset() {}
    public final void set(U element) {}

    public final U getU() {
        return null;
    }
}
