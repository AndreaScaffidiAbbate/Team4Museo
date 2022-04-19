package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company;

import ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Exception.NullAuthorException;

import java.util.UUID;

public class Opera {
    private final UUID id;
    private String titolo;
    private Autore autore;

    public Opera() {
        this.id= UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) throws NullAuthorException {
        if(autore.getNome()!=null && autore.getCognome()!=null)
            this.autore = autore;
        else
            throw new NullAuthorException();
    }

    @Override
    public String toString() {
            return " ID=" + id + ", TITOLO='" + titolo + ", " + getAutore().toString() + ", ";
    }
}
