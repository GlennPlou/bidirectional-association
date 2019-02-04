package fr.univnantes.bidirectional.oneToN;

/**
 * Class representing a computer file, for the example of a one-to-many bidirectional association.
 * A file has a reference to a single folder.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
public class File {
    /**
     * The name of this file.
     */
    private String name;

    /**
     * The size of this file.
     */
    private Integer size;

    /**
     * The reference to the unique folder.
     */
    private FileReferenceToFolder folder;

    /**
     * Constructor of File. Initializes properties of this class. Initializes the folder reference with "this".
     * @param name the name of this file.
     * @param size the size of this file.
     */
    public File(String name, Integer size) {
        this.name = name;
        this.size = size;
        this.folder = new FileReferenceToFolder(this);
    }

    /**
     * Returns the folder reference.
     * @return this.folder.
     */
    public FileReferenceToFolder getFolder() {
        return this.folder;
    }

    /**
     * Set the new folder of this file, using the folder reference.
     * @param folder the new folder.
     */
    public void setFolder(Folder folder) {
        this.folder.set(folder);
    }

    /**
     * Removes the reference of the existing folder.
     */
    public void unsetFolder() {
        this.folder.unset();
    }
}
