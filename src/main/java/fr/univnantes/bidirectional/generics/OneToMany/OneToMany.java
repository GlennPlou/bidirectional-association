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

    }

    @Override
    public void add(U element) {

    }
}
