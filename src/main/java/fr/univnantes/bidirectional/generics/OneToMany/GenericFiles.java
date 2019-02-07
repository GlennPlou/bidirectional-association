package fr.univnantes.bidirectional.generics.OneToMany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;

public class GenericFiles implements BidirectionalReference {

    private BidirectionalAssociation<GenericFiles, GenericFolder> folder;

    public GenericFiles() {
        this.folder = new ManyToOne<GenericFiles, GenericFolder>(this);
    }

    public BidirectionalAssociation getReference() {
        return this.folder;
    }

    public void setFolder(GenericFolder folder) {
        this.folder.set(folder);
    }

    public void unsetFolder() {
        this.folder.unset();
    }
}
