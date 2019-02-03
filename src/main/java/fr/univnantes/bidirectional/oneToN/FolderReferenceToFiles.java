package fr.univnantes.bidirectional.oneToN;

import java.util.ArrayList;
import java.util.List;

public class FolderReferenceToFiles {
    private Folder folder;
    private List<File> files = new ArrayList<File>();

    public FolderReferenceToFiles(Folder folder) {
        this.folder = folder;
    }

    public void basicAdd(File file) {
        this.files.add(file);
    }

    public void basicRemove(File file) {
        this.files.remove(file);
    }

    public void remove(File file) {
        if (file.getFolder().getFolder() == this.folder) {
//            file.getFolder().unset();                                         // You can do this
            if (file.getFolder().isSet()) { file.getFolder().basicUnset(); }    // OR this. Attention to details.

            this.basicRemove(file);
        }
    }

    public void add(File file) {
        if (file.getFolder().isSet()) {
            file.getFolder().unset();
        }
        file.getFolder().basicSet(this.folder);
//        file.getFolder().set(this.folder);    // Especially don't call the general "set" of the other reference class,
                                                // you just have to do the "basic" work.
        this.basicAdd(file);
    }

    public List<File> getFiles() {
        return files;
    }
}
