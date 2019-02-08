package fr.univnantes.bidirectional.generics.onetomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.impl.ManyToOne;

class File implements BidirectionalReference {

    private final BidirectionalAssociation<File, Folder> folder;

    File() {
        this.folder = new ManyToOne<File, Folder>(this);
    }

    public BidirectionalAssociation getReference() {
        return this.folder;
    }

    void setFolder(Folder folder) {
        this.folder.set(folder);
    }

    void unsetFolder() {
        this.folder.unset();
    }

    Folder getFolder() {
        return this.folder.getU();
    }
}