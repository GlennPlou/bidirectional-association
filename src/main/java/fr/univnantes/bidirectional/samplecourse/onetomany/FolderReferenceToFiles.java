package fr.univnantes.bidirectional.samplecourse.onetomany;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the association between a folder and its files. (Folder --> Files association)
 * A directory, or folder, has a reference to many files.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class FolderReferenceToFiles {

    /**
     * The list of files that belong to the directory we are managing.
     */
    private final List<File> files = new ArrayList<File>();

    /**
     * The folder we are managing.
     */
    private final Folder folder;

    /**
     * Constructor of FolderReferenceToFiles. Initializes the folder we are managing.
     * @param folder the folder we want to manage.
     */
    FolderReferenceToFiles(Folder folder) {
        this.folder = folder;
    }

    /**
     * Makes a simple addition to the list.
     * @param file the file to add.
     */
    void basicAdd(File file) {
        this.files.add(file);
    }

    /**
     * Makes a simple removal from the list.
     * @param file the file to remove.
     */
    void basicRemove(File file) {
        this.files.remove(file);
    }

    /**
     * Breaks the association File --> Folder and then Folder --> File.
     * @param file the file to remove.
     */
    void remove(File file) {
        if (file.getFolder().getFolder() == this.folder) {
//            file.getFolder().unset();                                         // You can do this
            if (file.getFolder().isSet()) { file.getFolder().basicUnset(); }    // OR this. Attention to details.

            this.basicRemove(file);
        }
    }

    /**
     * Add a new file to the files references by unset the old folder reference of the file if necessary, and using the
     * "basicAdd/Set" functions (notion and important order in this bi-directional association model).
     * @param file the file to add.
     */
    void add(File file) {
        if (file.getFolder().isSet()) {
            file.getFolder().unset();
        }
        file.getFolder().basicSet(this.folder);
//        file.getFolder().set(this.folder);    // Especially don't call the general "set" of the other reference class,
                                                // you just have to do the "basic" work.
        this.basicAdd(file);
    }

    /**
     * SReturns the list of files associated to the folder.
     * @return this.files
     */
    List<File> getFiles() {
        return this.files;
    }
}
