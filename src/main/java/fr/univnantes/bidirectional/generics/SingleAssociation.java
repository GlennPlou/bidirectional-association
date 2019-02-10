package fr.univnantes.bidirectional.generics;

import java.util.List;

/**
 * This abstract class gives the skeleton of bidirectional association that are connected to only one element.
 * The T element is connected to a single U element, its "parent" in a way.
 *
 * @param <U> the type of elements that will be set or unset in the association.
 *
 * @author Glenn Plouhinec
 * @see fr.univnantes.bidirectional.generics.impl.ManyToOne
 * @see fr.univnantes.bidirectional.generics.impl.OneToOne
 */
public abstract class SingleAssociation<U extends BidirectionalReference> implements BidirectionalAssociation<U> {

    /**
     * The T element we are managing.
     */
    protected BidirectionalReference t;

    /**
     * The U element with which T is connected.
     */
    protected U u;

    /**
     * Default empty constructor needed for extended classes.
     */
    protected SingleAssociation() {

    }

    /**
     * SingleAssociation constructor, initializes the T element.
     *
     * @param element the element we want to manage.
     */
    protected SingleAssociation(BidirectionalReference element) {
        this.t = element;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSet() {
        return this.u != null;
    }

    /**
     * {@inheritDoc}
     */
    public void basicSet(U element) {
        this.u = element;
    }

    /**
     * {@inheritDoc}
     */
    public void basicUnset() {
        this.u = null;
    }

    /**
     * {@inheritDoc}
     */
    public abstract void unset();

    /**
     * {@inheritDoc}
     */
    public abstract void set(U element);

    /**
     * {@inheritDoc}
     */
    public U getU() {
        return this.u;
    }

    /**
     * {@inheritDoc}
     */
    public final void basicAdd(U element) {}

    /**
     * {@inheritDoc}
     */
    public final void basicRemove(U element) {}

    /**
     * {@inheritDoc}
     */
    public final void remove(U element) {}

    /**
     * {@inheritDoc}
     */
    public final void add(U element) {}

    /**
     * {@inheritDoc}
     */
    public final List<U> getList() {
        return null;
    }
}
