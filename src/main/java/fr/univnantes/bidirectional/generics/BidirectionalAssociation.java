package fr.univnantes.bidirectional.generics;

import java.util.List;

public interface BidirectionalAssociation<T extends BidirectionalReference, U extends BidirectionalReference> {

    boolean isSet();
    void basicSet(U element);
    void basicUnset();
    void unset();
    void set(U element);

    void basicAdd(U element);
    void basicRemove(U element);
    void remove(U element);
    void add(U element);

    U getU();
    List<U> getList();
}
