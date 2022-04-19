package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company;

import java.util.UUID;

public class Quadro extends Opera{

    private enum TecnicaUsata{
        ACQUERELLO,
        OLIO,
        TEMPERA
    }
    private TecnicaUsata tecnica;

    public Quadro(){
        super();
    }

    public String getTecnicaUsata() {
        return tecnica.toString();
    }

    public void setTecnicaUsata(String tecnica) {
        this.tecnica = TecnicaUsata.valueOf(tecnica.toUpperCase());
    }

    @Override
    public String toString() {
        return "QUADRO{" + super.toString() +
                "TECNICA USATA='" + tecnica.toString() +
                "}" + '\n';
    }
}
