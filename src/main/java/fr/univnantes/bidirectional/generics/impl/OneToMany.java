package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;

import java.util.List;

public class OneToMany<U extends BidirectionalReference> extends ManyAssociation<U> {

    public OneToMany(BidirectionalReference element) {
        super(element);
    }

    public <E extends List<U>> OneToMany(BidirectionalReference element, E list) {
        super(element, list);
    }

    @Override
    public void remove(U element) {
        if (element.getReference().getU() == this.t) {
            if (element.getReference().isSet()) {
                element.getReference().basicUnset();
            }
            this.basicRemove(element);
        }
    }

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
