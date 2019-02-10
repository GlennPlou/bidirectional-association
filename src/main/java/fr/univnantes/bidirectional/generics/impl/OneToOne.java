package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;

/**
 * This OneToOne bidirectional association is a way to manage a "one-to-one" association, where the T element managed in
 * this class has only one association with a U element, and this U has also one unique association to a T element.
 *
 * @param <U> the type of elements that will be set or unset in the association.
 *
 * @author Glenn Plouhinec
 * @see SingleAssociation
 */
public class OneToOne<U extends BidirectionalReference> extends SingleAssociation<U> {

    /**
     * {@inheritDoc}
     * @see SingleAssociation
     */
    public OneToOne(BidirectionalReference element) {
        super(element);
    }

    /**
     * {@inheritDoc}
     * @see fr.univnantes.bidirectional.generics.BidirectionalAssociation
     */
    @Override
    public void unset() {
        if (this.isSet()) {
            this.u.getReference().basicUnset();
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
        if (element.getReference().isSet()) {
            element.getReference().unset();
        }
        this.unset();
        element.getReference().basicSet(this.t);
        this.basicSet(element);
    }
}
