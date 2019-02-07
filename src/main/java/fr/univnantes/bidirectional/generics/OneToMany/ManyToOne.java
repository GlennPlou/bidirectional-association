package fr.univnantes.bidirectional.generics.OneToMany;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;

public class ManyToOne<T extends BidirectionalReference, U extends BidirectionalReference> extends SingleAssociation<T, U> {

    public ManyToOne(T element) {
        super(element);
    }

    @Override
    public void unset() {

    }

    @Override
    public void set(U element) {

    }
}
