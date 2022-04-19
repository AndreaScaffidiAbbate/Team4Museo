package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Comparator;

import ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Autore;

import java.util.Comparator;

public class ComparatorAutoreNascita implements Comparator<Autore>{

    private int ordine;

    public ComparatorAutoreNascita(int ordine){
        this.ordine= ordine;
    }

    @Override
    public int compare(Autore o1, Autore o2) {
        int result= 0;
        result= o1.getNascita().compareTo(o2.getNascita());
        if(result==0)
            result= o1.getNome().compareTo(o2.getNome());
        if(ordine==1)
            return result;
        else
            return -result;
    }
}
