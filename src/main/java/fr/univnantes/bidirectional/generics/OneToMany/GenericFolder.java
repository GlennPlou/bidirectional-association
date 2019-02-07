package fr.univnantes.bidirectional.generics.OneToMany;

import fr.univnantes.bidirectional.generics.BidirectionalAssociation;
import fr.univnantes.bidirectional.generics.BidirectionalReference;

import java.util.ArrayList;

public class GenericFolder implements BidirectionalReference {

    private BidirectionalAssociation<GenericFolder, GenericFiles> files;

    public GenericFolder() {
        this.files = new OneToMany<GenericFolder, GenericFiles>(this, new ArrayList<GenericFiles>());
    }

    public BidirectionalAssociation getReference() {
        return this.files;
    }

    public void addFile(GenericFiles file) {
        this.files.add(file);
    }

    public void removeFile(GenericFiles file) {
        this.files.remove(file);
    }
}
