package fr.univnantes.bidirectional.generics.ManyToMany;

import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociations;

import java.util.List;

public class ManyToMany<T extends BidirectionalReference, U extends BidirectionalReference> extends ManyAssociations<T, U> {

    public ManyToMany(T element) {
        super(element);
    }

    public <E extends List<U>> ManyToMany(T element, E list) {
        super(element, list);
    }

    @Override
    public void remove(U element) {
        if (element.getReference().getList().contains(this.t)) {
            element.getReference().basicRemove(this.t);
            this.basicRemove(element);
        }
    }

    @Override
    public void add(U element) {
        element.getReference().basicAdd(this.t);
        this.basicAdd(element);
    }
}
