package fr.univnantes.bidirectional.generics;

/**
 * This interface ensures that a bidirectional association is used by the classes that implement it.
 *
 * @author Glenn Plouhinec
 * @see BidirectionalAssociation
 */
public interface BidirectionalReference {

    /**
     * Returns the bidirectional association used.
     * (usually ManyToMany<U>, ManyToOne<U>, OneToMany<U>, or OneToOne<U>)
     *
     * @return the bidirectional association used.
     */
    BidirectionalAssociation getReference();
}
