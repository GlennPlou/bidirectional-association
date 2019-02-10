package fr.univnantes.bidirectional.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class gives the skeleton of bidirectional association that are connected to many elements.
 * The T element is connected to many U elements, its "children" in a way.
 *
 * @param <U> the type of elements that will be added or deleted in the association.
 *
 * @author Glenn Plouhinec
 * @see fr.univnantes.bidirectional.generics.impl.ManyToMany
 * @see fr.univnantes.bidirectional.generics.impl.OneToMany
 */
public abstract class ManyAssociation<U extends BidirectionalReference> implements BidirectionalAssociation<U> {

    /**
     * The T element we are managing.
     */
    protected BidirectionalReference t;

    /**
     * The list of U elements to which T is connected.
     */
    private List<U> uList;

    /**
     * Default empty constructor needed for extended classes.
     */
    protected ManyAssociation() {

    }

    /**
     * ManyAssociation constructor, initializes the T element and the list by creating a new ArrayList by default.
     *
     * @param element the element we want to manage.
     */
    protected ManyAssociation(BidirectionalReference element) {
        this.t = element;
        this.uList = new ArrayList<U>();
    }

    /**
     * ManyAssociation constructor, initializes the T element and the type of List used.
     * The new list is cleared before assignment.
     *
     * @param element the element we want to manage.
     * @param newList the new list to use. Only the type is using.
     * @param <E> the type of List that will be used.
     */
    protected <E extends List<U>> ManyAssociation(BidirectionalReference element, E newList) {
        this.t = element;
        if (!newList.isEmpty()) {
            newList.clear();
        }
        this.uList = newList;
    }

    /**
     * {@inheritDoc}
     */
    public void basicAdd(U element) {
        this.uList.add(element);
    }

    /**
     * {@inheritDoc}
     */
    public void basicRemove(U element) {
        this.uList.remove(element);
    }

    /**
     * {@inheritDoc}
     */
    public abstract void remove(U element);

    /**
     * {@inheritDoc}
     */
    public abstract void add(U element);

    /**
     * {@inheritDoc}
     */
    public List<U> getList() {
        return this.uList;
    }

    /**
     * {@inheritDoc}
     */
    public final boolean isSet() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public final void basicSet(U element) {}

    /**
     * {@inheritDoc}
     */
    public final void basicUnset() {}

    /**
     * {@inheritDoc}
     */
    public final void unset() {}

    /**
     * {@inheritDoc}
     */
    public final void set(U element) {}

    /**
     * {@inheritDoc}
     */
    public final U getU() {
        return null;
    }
}
