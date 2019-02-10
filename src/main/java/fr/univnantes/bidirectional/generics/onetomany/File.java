package fr.univnantes.bidirectional.generics.onetomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;
import fr.univnantes.bidirectional.generics.impl.ManyToOne;

/**
 * Class representing a computer file, for the example of a one-to-many bidirectional association.
 * A file has a reference to a single folder.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class File implements BidirectionalReference {

    /**
     * The reference to the unique folder.
     */
    private final SingleAssociation<Folder> folder;

    /**
     * Constructor of File. Initializes properties of this class. Initializes the folder reference with "this".
     */
    File() {
        this.folder = new ManyToOne<Folder>(this);
    }

    /**
     * Returns the folder reference.
     * @return this.folder.
     */
    public BidirectionalAssociation getReference() {
        return this.folder;
    }

    /**
     * Set the new folder of this file, using the folder reference.
     * @param folder the new folder.
     */
    void setFolder(Folder folder) {
        this.folder.set(folder);
    }

    /**
     * Removes the reference of the existing folder.
     */
    void unsetFolder() {
        this.folder.unset();
    }

    /**
     * Returns the folder of this file.
     * @return the folder of this file.
     */
    Folder getFolder() {
        return this.folder.getU();
    }
}