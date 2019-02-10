package fr.univnantes.bidirectional.generics.onetomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.ManyAssociation;
import fr.univnantes.bidirectional.generics.impl.OneToMany;

import java.util.List;

class Folder implements BidirectionalReference {

    private final ManyAssociation<File> files;

    Folder() {
        this.files = new OneToMany<File>(this);
    }

    Folder(List<File> files) {
        this.files = new OneToMany<File>(this, files);
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
