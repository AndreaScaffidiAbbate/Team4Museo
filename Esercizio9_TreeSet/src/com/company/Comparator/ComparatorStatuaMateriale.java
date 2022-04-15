package com.company.Comparator;

import com.company.Statua;

import java.util.Comparator;

public class ComparatorStatuaMateriale implements Comparator<Statua> {

    private int ordine;

    public ComparatorStatuaMateriale(int ordine){
        this.ordine= ordine;
    }

    @Override
    public int compare(Statua o1, Statua o2) {
        int result= 0;
        result= o1.getMateriale().compareTo(o2.getMateriale());
        if(result==0){
            result= o1.getTitolo().compareTo(o2.getTitolo());
        }
        if(ordine==1)
            return result;
        else
            return -result;
    }
}
