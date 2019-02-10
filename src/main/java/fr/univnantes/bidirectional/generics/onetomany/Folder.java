package fr.univnantes.bidirectional.generics.onetomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;
import fr.univnantes.bidirectional.generics.impl.OneToMany;

import java.util.List;

/**
 * Class representing a directory, for the example of a one-to-many bidirectional association.
 * A directory, or folder, has a reference to many files.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class Folder implements BidirectionalReference {

    /**
     * The reference to all the files of this folder.
     */
    private final ManyAssociation<File> files;

    /**
     * Constructor of Folder. Initializes properties of this class. Initializes the files reference with "this".
     */
    Folder() {
        this.files = new OneToMany<File>(this);
    }

    /**
     * Another constructor of Folder, just for testing. Initializes the files reference with "this", and the list of
     * files with another list.
     *
     * @param files a simple list of files.
     */
    Folder(List<File> files) {
        this.files = new OneToMany<File>(this, files);
    }

    /**
     * Returns the files reference.
     * @return this.files.
     */
    public BidirectionalAssociation getReference() {
        return this.files;
    }

    /**
     * Add a new file for this folder, using the files reference.
     * @param file the new file to add.
     */
    void addFile(File file) {
        this.files.add(file);
    }

    /**
     * Removes the reference to a file.
     * @param file the file to remove.
     */
    void removeFile(File file) {
        this.files.remove(file);
    }

    /**
     * Returns the list of files of this folder.
     * @return the list of files of this folder.
     */
    List<File> getFiles() {
        return this.files.getList();
    }
}
