package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;

public class ManyToOne<U extends BidirectionalReference> extends SingleAssociation<U> {

    public ManyToOne(BidirectionalReference element) {
        super(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void unset() {
        if (this.isSet()) {
            this.u.getReference().basicRemove(this.t);
            this.basicUnset();
        }
    }

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
