package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;

import java.util.List;

/**
 * This ManyToMany bidirectional association is a way to manage a "many-to-many" association, where the T element
 * managed in this class has multiple associations with U elements, and U has also multiple associations to other T
 * elements.
 *
 * @param <U> the type of elements that will be added or deleted in the association.
 *
 * @author Glenn Plouhinec
 * @see ManyAssociation
 */
public class ManyToMany<U extends BidirectionalReference> extends ManyAssociation<U> {

    /**
     * {@inheritDoc}
     * @see ManyAssociation
     */
    public ManyToMany(BidirectionalReference element) {
        super(element);
    }

    /**
     * {@inheritDoc}
     * @see ManyAssociation
     */
    public ManyToMany(BidirectionalReference element, List<U> list) {
        super(element, list);
    }

    /**
     * {@inheritDoc}
     * @see fr.univnantes.bidirectional.generics.BidirectionalAssociation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void remove(U element) {
        if (element.getReference().getList().contains(this.t)) {
            element.getReference().basicRemove(this.t);
            this.basicRemove(element);
        }
    }

    /**
     * {@inheritDoc}
     * @see fr.univnantes.bidirectional.generics.BidirectionalAssociation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void add(U element) {
        element.getReference().basicAdd(this.t);
        this.basicAdd(element);
    }
}
