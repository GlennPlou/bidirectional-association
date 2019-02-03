package fr.univnantes.bidirectional.oneToN;

public class FileReferenceToFolder {
    private Folder folder;
    private File file;

    public FileReferenceToFolder(File file) {
        this.file = file;
    }

    public boolean isSet() {
        return folder != null;
    }

    public void basicSet(Folder folder) {
        this.folder = folder;
    }

    public void basicUnset() {
        folder = null;
    }

    public void unset() {
        if (this.isSet()) {
            this.folder.getFiles().basicRemove(this.file);
            this.basicUnset();
        }
    }

    public void set(Folder folder) {
        if (this.isSet()) {
            this.unset();
        }
        folder.getFiles().basicAdd(this.file);
        this.basicSet(folder);
    }

    public Folder getFolder() {
        return this.folder;
    }
}
