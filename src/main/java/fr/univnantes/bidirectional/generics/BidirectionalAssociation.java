package fr.univnantes.bidirectional.generics;

import java.util.List;

/**
 * The root interface in the BidirectionalAssociation hierarchy. A bidirectional association is a binary association
 * that connects objects yo each other. We often talk about a parent/child relation. Classes that implement this
 * interface manage two objects of different types: T and U. Constructors must be initialized with the T-type object as
 * a parameter, and an association with U-type objects will be realized with the methods of adding and deleting of this
 * interface.
 *
 * @param <U> the type of elements that will be added or deleted in the association.
 *
 * @author Glenn Plouhinec
 * @see ManyAssociation
 * @see SingleAssociation
 * @see fr.univnantes.bidirectional.generics.impl.ManyToMany
 * @see fr.univnantes.bidirectional.generics.impl.ManyToOne
 * @see fr.univnantes.bidirectional.generics.impl.OneToMany
 * @see fr.univnantes.bidirectional.generics.impl.OneToOne
 */
public interface BidirectionalAssociation<U extends BidirectionalReference> {

    /**
     * Returns true if this bidirectional association is associated to a single U element.
     * This method can only be used by classes that extend SingleAssociation.
     *
     * @return true if this bidirectional association is associated to an element.
     */
    boolean isSet();

    /**
     * Makes a simple assignment of an element of type U.
     * This method can only be used by classes that extend SingleAssociation.
     *
     * @param element the element to assign.
     */
    void basicSet(U element);

    /**
     * Makes a null assignment to the U element.
     * This method can only be used by classes that extend SingleAssociation.
     */
    void basicUnset();

    /**
     * Breaks the association between the U element and its other association, and then between the T element and its
     * association to U.
     * This method can only be used by classes that extend SingleAssociation.
     */
    void unset();

    /**
     * Sets the new association between T and U.
     * This method can only be used by classes that extend SingleAssociation.
     *
     * @param element the element to associate.
     */
    void set(U element);

    /**
     * Allows T object to access its association with U.
     * This method can only be used by classes that extend SingleAssociation.
     *
     * @return this.u.
     */
    U getU();

    /**
     * Makes an addition of a U element to the list of U elements.
     * This method can only be used by classes that extend ManyAssociation.
     *
     * @param element the element to add.
     */
    void basicAdd(U element);

    /**
     * Makes a deletion of a U element from a list of U elements.
     * This method can only be used by classes that extend ManyAssociation.
     *
     * @param element the element to remove.
     */
    void basicRemove(U element);

    /**
     * Adds a new U element to the to the list of U elements, and adds our T element to U's list of elements.
     * This method can only be used by classes that extend ManyAssociation.
     *
     * @param element the element to add.
     */
    void add(U element);

    /**
     * Breaks the association between U and our T element, and then between T and U.
     * This method can only be used by classes that extend ManyAssociation.
     *
     * @param element the element to remove.
     */
    void remove(U element);

    /**
     * Allows T object to access its list of associations with U.
     * This method can only be used by classes that extend ManyAssociation.
     *
     * @return this.uList.
     */
    List<U> getList();
}
