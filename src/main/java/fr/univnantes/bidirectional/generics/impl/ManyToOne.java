package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;

/**
 * This ManyToOne bidirectional association is a way to manage a "many-to-one" association, where the T element managed
 * in this class has only one association with a U element, but this U has multiple associations to other T elements.
 *
 * @param <U> the type of elements that will be set or unset in the association.
 *
 * @author Glenn Plouhinec
 * @see SingleAssociation
 */
public class ManyToOne<U extends BidirectionalReference> extends SingleAssociation<U> {

    /**
     * {@inheritDoc}
     * @see SingleAssociation
     */
    public ManyToOne(BidirectionalReference element) {
        super(element);
    }

    /**
     * {@inheritDoc}
     * @see fr.univnantes.bidirectional.generics.BidirectionalAssociation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void unset() {
        if (this.isSet()) {
            this.u.getReference().basicRemove(this.t);
            this.basicUnset();
        }
    }

    /**
     * {@inheritDoc}
     * @see fr.univnantes.bidirectional.generics.BidirectionalAssociation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void set(U element) {
        if (this.isSet()) {
            this.unset();
        }
        element.getReference().basicAdd(this.t);
        this.basicSet(element);
    }
}
