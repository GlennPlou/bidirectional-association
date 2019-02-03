package fr.univnantes.bidirectional.oneToN;

public class Folder {
    private String name;
    private FolderReferenceToFiles files;

    public Folder(String name) {
        this.name = name;
        this.files = new FolderReferenceToFiles(this);
    }

    public FolderReferenceToFiles getFiles() {
        return this.files;
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void removeFile(File file) {
        this.files.remove(file);
    }
}
