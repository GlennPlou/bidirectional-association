package fr.univnantes.bidirectional.generics;

public class OneToOne<T extends Reference, U extends Reference> {

    private T t;
    private U u;

    public OneToOne(T t) {
        this.t = t;
    }

    public boolean isSet() {
        return this.u != null;
    }

    public void basicSet(U u) {
        this.u = u;
    }

    public void basicUnset() {
        this.u = null;
    }

    public void unset() {
        if (this.isSet()) {
            //if (this.u.getReference().isSet())
                this.u.getReference().basicUnset();
            //this.t.getReference().basicUnset();


            this.basicUnset();
        }
    }

    public void set(U u) {
        if (u.getReference().isSet()) {
            u.getReference().unset();
        }
        this.unset();
        u.getReference().basicSet(this.t);
        this.basicSet(u);
    }

    public U getU() {
        return this.u;
    }

    public T getT() {
        return this.t;
    }
}
