package fr.univnantes.bidirectional.generics.onetomany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;
import fr.univnantes.bidirectional.generics.SingleAssociation;
import fr.univnantes.bidirectional.generics.impl.ManyToOne;

class File implements BidirectionalReference {

    private final SingleAssociation<Folder> folder;

    File() {
        this.folder = new ManyToOne<Folder>(this);
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