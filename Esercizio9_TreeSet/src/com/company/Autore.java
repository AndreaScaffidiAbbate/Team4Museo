package ExMuseo.Team4Museo.Esercizio9_TreeSet.src.com.company;


import java.time.LocalDate;

public class Autore {

    private String nome;
    private String cognome;
    private LocalDate nascita;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    @Override
    public String toString() {
        return "AUTORE{" +
                "NOME='" + nome + '\'' +
                ", COGNOME='" + cognome + '\'' +
                ", NASCITA='" + nascita +
                '}';
    }


}
