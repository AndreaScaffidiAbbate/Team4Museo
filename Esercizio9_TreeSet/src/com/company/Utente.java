package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company;

import ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Comparator.*;

public class Utente {

    private int lista;
    private int ordine;

    public Utente(int lista, int ordine) {
        this.ordine = ordine;
        this.lista = lista;
    }

    public int getOrdine() {
        return ordine;
    }

    public void setOrdine(int ordine) {
        this.ordine = ordine;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public void generaLista(Museo m){
        switch(lista){
            case 1:
                if(ordine==1 || ordine==2){
                    ComparatorQuadroTecnica cqt= new ComparatorQuadroTecnica(ordine);
                    System.out.println("I quadri ordinati per tecnica (crescente) sono:");
                    m.ordinaQuadri(cqt);
                    break;
                } else {
                    System.out.println("Ordine non stabilito");
                    break;
                }
            case 2:
                if(ordine==1 || ordine==2){
                    ComparatorQuadroAutore cqa= new ComparatorQuadroAutore(ordine);
                    System.out.println("I quadri ordinati per autore (decrescente) sono:");
                    m.ordinaQuadri(cqa);
                    break;
                } else {
                    System.out.println("Ordine non stabilito");
                    break;
                }
            case 3:
                if(ordine==1 || ordine==2){
                    ComparatorStatuaMateriale csm= new ComparatorStatuaMateriale(ordine);
                    System.out.println("Le statue ordinate per materiale (decrescente) sono:");
                    m.ordinaStatue(csm);
                } else {
                    System.out.println("Ordine non stabilito");
                    break;
                }
            case 4:
                if(ordine==1 || ordine==2){
                    ComparatorStatuaAutore csa= new ComparatorStatuaAutore(ordine);
                    System.out.println("Le statue ordinate per autore (crescente) sono:");
                    m.ordinaStatue(csa);
                    break;
                } else {
                    System.out.println("Ordine non stabilito");
                    break;
                }
            case 5:
                if(ordine==1 || ordine==2){
                    ComparatorAutoreNascita can= new ComparatorAutoreNascita(ordine);
                    System.out.println("Gli autori ordinati per nascita (crescente) sono:");
                    m.ordinaAutori(can);
                } else {
                    System.out.println("Ordine non stabilito");
                    break;
                }
            default:
                System.out.println("Lista non presente");
                break;
        }
    }
}
