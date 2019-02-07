package fr.univnantes.bidirectional.generics.OneToMany;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociations;

import java.util.List;

public class OneToMany<T extends BidirectionalReference, U extends BidirectionalReference> extends ManyAssociations<T, U> {

    public OneToMany(T element) {
        super(element);
    }

    public <E extends List<U>> OneToMany(T element, E list) {
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
    public void add(U element) {
        if (element.getReference().isSet()) {
            element.getReference().unset();
        }
        element.getReference().basicSet(this.t);
        this.basicAdd(element);
    }
}
