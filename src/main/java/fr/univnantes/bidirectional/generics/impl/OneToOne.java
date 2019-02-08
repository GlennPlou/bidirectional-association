package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;

public class OneToOne<T extends BidirectionalReference, U extends BidirectionalReference> extends SingleAssociation<T, U> {

    public OneToOne(T element) {
        super(element);
    }

    @Override
    public void unset() {
        if (this.isSet()) {
            this.u.getReference().basicUnset();
            this.basicUnset();
        }
    }

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
