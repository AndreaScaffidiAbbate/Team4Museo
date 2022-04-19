package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company;

import ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Exception.AlreadyPresentException;
import ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company.Exception.NotFoundException;

import java.util.*;

public class Museo{

    private Map<Autore, ArrayList<Opera>> mappaAutori = new HashMap<>();
    private HashSet<Opera> deposito;
    private LinkedHashSet<Opera> esposizione;

    public Museo(HashSet<Opera> deposito, LinkedHashSet<Opera> esposizione) {
        this.deposito = deposito;
        this.esposizione = esposizione;
    }

    public HashSet<Opera> getDeposito() {
        return deposito;
    }

    public void setDeposito(HashSet<Opera> deposito) {
        this.deposito = deposito;
    }

    public LinkedHashSet<Opera> getEsposizione() {
        return esposizione;
    }

    public void setEsposizione(LinkedHashSet<Opera> esposizione) {
        this.esposizione = esposizione;
    }

    public void carica(Opera o) throws AlreadyPresentException {
        if(esposizione.size()<3){
            if(esposizione.contains(o)){
                throw new AlreadyPresentException();
            } else {
                esposizione.add(o);
                System.out.println("Opera "+o.getTitolo()+" aggiunta in esposizione\n");
            }
        } else {
            if(deposito.contains(o)){
                throw new AlreadyPresentException();
            } else {
                deposito.add(o);
                System.out.println("Opera "+o.getTitolo()+" aggiunta in deposito\n");
            }
        }
        if(!mappaAutori.containsKey(o.getAutore())){
            mappaAutori.put(o.getAutore(), new ArrayList<Opera>());
        }
            mappaAutori.get(o.getAutore()).add(o);
    }

    public void sposta(UUID id) throws AlreadyPresentException {
        for(Opera x: deposito){
            if(x.getId().equals(id)){
                throw new AlreadyPresentException();
            }
        }
        for(Opera x: esposizione){
            if(x.getId().equals(id)){
                esposizione.remove(x);
                deposito.add(x);
                System.out.println("Opera spostata in deposito\n");
                break;
            }
        }
    }

    public Opera cerca(UUID id) throws NotFoundException {
        Opera o= null;
        for(Opera x: deposito){
            if(x.getId().equals(id)){
                o= x;
                System.out.println("L'opera e' nel deposito\n");
                break;
            }
        }
        for(Opera x: esposizione){
            if(x.getId().equals(id)){
                o= x;
                System.out.println("L'opera e' in esposizione\n");
                break;
            }
        }
        if(o==null)
            throw new NotFoundException();
        return o;
    }

    public String stampaSala(){
        String opereSala= "";
        System.out.println("Sala esposizione:");
        for(Opera x: esposizione){
            opereSala= opereSala + x.toString();
        }
        return opereSala;
    }

    public String stampaDeposito(){
        System.out.println("Deposito:");
        String opereDeposito= "";
        for(Opera x: deposito){
            opereDeposito= opereDeposito + x.toString();
        }
        return opereDeposito;
    }

    public String opereAutore(Autore a){
        String opere= "";
       /* for(Opera x: esposizione){
            if(x.getAutore().equals(a)){
                opere+= x.toString();
            }
        }
        for(Opera x: deposito){
            if(x.getAutore().equals(a)){
                opere+= x.toString();
            }
        }*/

        if(mappaAutori.containsKey(a)){
            for(Opera x: mappaAutori.get(a)){
                opere+= x.toString();
            }
        }
        return opere;
    }

    public String quadriDaTecnica(String tecnica){
        System.out.println("I quadri dipinti con "+tecnica+" sono:");
        String quadri= "";
        for(Opera x: esposizione){
            if(x instanceof Quadro){
                Quadro test= new Quadro();
                test= (Quadro) x;
                if(test.getTecnicaUsata().equals(tecnica))
                    quadri+= x.toString();
            }
        }
        for(Opera x: deposito){
            if(x instanceof Quadro){
                Quadro test= new Quadro();
                test= (Quadro) x;
                if(test.getTecnicaUsata().equals(tecnica))
                    quadri+= x.toString();
            }
        }
        return quadri;
    }

    public String statueDaMateriale(String materiale){
        System.out.println("Le statue scolpite con "+materiale+" sono:");
        String statue= "";
        for(Opera x: esposizione){
            if(x instanceof Statua){
                Statua test= new Statua();
                test= (Statua) x;
                if(test.getMateriale().equals(materiale))
                    statue+= x.toString();
            }
        }
        for(Opera x: deposito){
            if(x instanceof Statua){
                Statua test= new Statua();
                test= (Statua) x;
                if(test.getMateriale().equals(materiale))
                    statue+= x.toString();
            }
        }
        return statue;
    }

    public void ordinaStatue(Comparator c){
        TreeSet<Statua> statue= new TreeSet<>(c);
        for(Opera o: this.esposizione){
            if(o instanceof Statua){
                statue.add((Statua) o);
            }
        }
        for(Opera o: this.deposito){
            if(o instanceof Statua){
                statue.add((Statua) o);
            }
        }
        System.out.println(statue);
    }

    public void ordinaQuadri(Comparator c){
        TreeSet<Quadro> quadri= new TreeSet<>(c);
        for(Opera o: this.esposizione){
            if(o instanceof Quadro){
                quadri.add((Quadro) o);
            }
        }
        for(Opera o: this.deposito){
            if(o instanceof Quadro){
                quadri.add((Quadro) o);
            }
        }
        System.out.println(quadri);
    }

    public void ordinaAutori(Comparator c){
        TreeSet<Autore> autori= new TreeSet<>(c);
        for(Opera o: this.esposizione){
            if(o instanceof Opera)
                autori.add(o.getAutore());
        }
        for(Opera o: this.deposito){
            if(o instanceof Opera)
                autori.add(o.getAutore());
        }
        System.out.println(autori);
    }


}
