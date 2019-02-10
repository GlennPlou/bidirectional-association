package fr.univnantes.bidirectional.generics.impl;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;

import java.util.List;

public class ManyToMany<U extends BidirectionalReference> extends ManyAssociation<U> {

    public ManyToMany(BidirectionalReference element) {
        super(element);
    }

    public <E extends List<U>> ManyToMany(BidirectionalReference element, E list) {
        super(element, list);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(U element) {
        if (element.getReference().getList().contains(this.t)) {
            element.getReference().basicRemove(this.t);
            this.basicRemove(element);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(U element) {
        element.getReference().basicAdd(this.t);
        this.basicAdd(element);
    }
}
