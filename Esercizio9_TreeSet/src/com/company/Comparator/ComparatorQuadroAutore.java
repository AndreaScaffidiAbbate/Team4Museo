package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Comparator;

import ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Quadro;

import java.util.Comparator;

public class ComparatorQuadroAutore implements Comparator<Quadro> {

    private int ordine;

    public ComparatorQuadroAutore(int ordine){
        this.ordine= ordine;
    }

    @Override
    public int compare(Quadro o1, Quadro o2) {
        int result = 0;
        result = o1.getAutore().getNome().compareTo(o2.getAutore().getNome());
        if (result == 0)
            result = o1.getAutore().getCognome().compareTo(o2.getAutore().getCognome());
        if (result == 0)
            result= o1.getTitolo().compareTo(o2.getTitolo());
        if(ordine==1)
            return result;
        else
            return -result;
    }
}
