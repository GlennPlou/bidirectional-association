package fr.univnantes.bidirectional.samplecourse.onetomany;

/**
 * Class representing the association between a file and its folder. (File --> Folder association)
 * A file has a reference to a single folder.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class FileReferenceToFolder {

    /**
     * The folder that belongs to the file we are managing.
     */
    private Folder folder;

    /**
     * The file we are managing.
     */
    private final File file;

    /**
     * Constructor of FileReferenceToFolder. Initializes the file we are managing.
     * @param file the file we want to manage.
     */
    FileReferenceToFolder(File file) {
        this.file = file;
    }

    /**
     * Check if the folder is set.
     * @return true if a folder is set.
     */
    boolean isSet() {
        return folder != null;
    }

    /**
     * Makes a simple assignment of the folder.
     * @param folder the folder to assigns.
     */
    void basicSet(Folder folder) {
        this.folder = folder;
    }

    /**
     * Makes a null assignments to the folder.
     */
    void basicUnset() {
        folder = null;
    }

    /**
     * Breaks the association Folder --> (old) File and then File --> Folder.
     */
    void unset() {
        if (this.isSet()) {
            this.folder.getFiles().basicRemove(this.file);
            this.basicUnset();
        }
    }

    /**
     * Set the new folder reference by breaking old association if necessary, and using the "basicAdd/Set" functions,
     * (notion and important order in this bi-directional association model).
     * @param folder the new Folder.
     */
    void set(Folder folder) {
        if (this.isSet()) {
            this.unset();
        }
        folder.getFiles().basicAdd(this.file);
        this.basicSet(folder);
    }

    /**
     * Returns the folder associated to the file.
     * @return this.folder.
     */
    Folder getFolder() {
        return this.folder;
    }
}
