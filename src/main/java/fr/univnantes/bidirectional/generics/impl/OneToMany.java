package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;

import java.util.List;

/**
 * This OneToMany bidirectional association is a way to manage a "one-to-many" association, where the T element managed
 * in this class has multiple associations with U elements, but each U has only one association to a T element.
 *
 * @param <U> the type of elements that will be added or deleted in the association.
 *
 * @author Glenn Plouhinec
 * @see ManyAssociation
 */
public class OneToMany<U extends BidirectionalReference> extends ManyAssociation<U> {

    /**
     * {@inheritDoc}
     * @see ManyAssociation
     */
    public OneToMany(BidirectionalReference element) {
        super(element);
    }

    /**
     * {@inheritDoc}
     * @see ManyAssociation
     */
    public OneToMany(BidirectionalReference element, List<U> list) {
        super(element, list);
    }

    /**
     * {@inheritDoc}
     * @see fr.univnantes.bidirectional.generics.BidirectionalAssociation
     */
    @Override
    public void remove(U element) {
        if (element.getReference().getU() == this.t) {
            if (element.getReference().isSet()) {
                element.getReference().basicUnset();
            }
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
        if (element.getReference().isSet()) {
            element.getReference().unset();
        }
        element.getReference().basicSet(this.t);
        this.basicAdd(element);
    }
}
