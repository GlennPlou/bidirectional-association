package fr.univnantes.bidirectional.generics.onetomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.impl.OneToMany;

import java.util.List;

class Folder implements BidirectionalReference {

    private final BidirectionalAssociation<Folder, File> files;

    Folder() {
        this.files = new OneToMany<Folder, File>(this);
    }

    Folder(List<File> files) {
        this.files = new OneToMany<Folder, File>(this, files);
    }

    public BidirectionalAssociation getReference() {
        return this.files;
    }

    void addFile(File file) {
        this.files.add(file);
    }

    void removeFile(File file) {
        this.files.remove(file);
    }

    List<File> getFiles() {
        return this.files.getList();
    }
}
