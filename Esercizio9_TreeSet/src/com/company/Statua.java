package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company;

public class Statua extends Opera{

    private enum Materiale{
        MARMO,
        PIETRA,
        GESSO
    }
    private Materiale materiale;
    private double altezza;

    public Statua(){
        super();
    }

    public String getMateriale() {
        return materiale.toString();
    }

    public void setMateriale(String materiale) {
        this.materiale = Materiale.valueOf(materiale);
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return "STATUA{" + super.toString() +
                "MATERIALE='" + materiale.toString() + '\'' +
                ", ALTEZZA=" + altezza +
                '}' + "\n";
    }
}
