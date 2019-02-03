package fr.univnantes.bidirectional.oneToN;

public class File {
    private String name;
    private Integer size;
    private FileReferenceToFolder folder;

    public File(String name, Integer size) {
        this.name = name;
        this.size = size;
        this.folder = new FileReferenceToFolder(this);
    }

    public FileReferenceToFolder getFolder() {
        return this.folder;
    }

    public void setFolder(Folder folder) {
        this.folder.set(folder);
    }

    public void removeFolder() {
        this.folder.unset();
    }
}
