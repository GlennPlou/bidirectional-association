package fr.univnantes.bidirectional.oneToN;

/**
 * Class representing the association between a file and its folder. (File --> Folder association)
 * A file has a reference to a single folder.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
public class FileReferenceToFolder {

    /**
     * The folder to which the file belongs.
     */
    private Folder folder;

    /**
     * The file we are managing.
     */
    private File file;

    /**
     * Constructor of FileReferenceToFolder. Initializes the file we are managing.
     * @param file the file we want to manage.
     */
    public FileReferenceToFolder(File file) {
        this.file = file;
    }

    /**
     * Check if the folder is set.
     * @return true if a folder is set.
     */
    public boolean isSet() {
        return folder != null;
    }

    /**
     * Makes a simple assignment of the folder.
     * @param folder the folder to assigns.
     */
    public void basicSet(Folder folder) {
        this.folder = folder;
    }

    /**
     * Makes a null assignments to the folder.
     */
    public void basicUnset() {
        folder = null;
    }

    /**
     * Breaks the association Folder --> File and then File --> Folder.
     */
    public void unset() {
        if (this.isSet()) {
            this.folder.getFiles().basicRemove(this.file);
            this.basicUnset();
        }
    }

    /**
     * Set the new folder reference by breaking old association if necessary, and using the "basicAdd/Set" functions
     * (notion and important order in this bi-directional association model).
     * @param folder the new Folder.
     */
    public void set(Folder folder) {
        if (this.isSet()) {
            this.unset();
        }
        folder.getFiles().basicAdd(this.file);
        this.basicSet(folder);
    }

    /**
     * Some useless getter for testing.
     * @return this.folder.
     */
    public Folder getFolder() {
        return this.folder;
    }
}
