package com.company;

import com.company.Exception.AlreadyPresentException;
import com.company.Exception.NotFoundException;
import com.company.Exception.NullAuthorException;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NullAuthorException {
        HashSet<Opera> deposito= new HashSet<>();
        LinkedHashSet<Opera> esposizione= new LinkedHashSet<>(3);

        Museo m= new Museo(deposito, esposizione);

        Autore a1 = new Autore();
        a1.setNome("Mario");
        a1.setCognome("Rossi");
        a1.setNascita(LocalDate.of(1856, 1, 25));

        Autore a2 = new Autore();
        a2.setNome("Franco");
        a2.setCognome("Bianchi");
        a2.setNascita(LocalDate.of(1972, 7, 18));

        Autore a3 = new Autore();
        a3.setNome("Maria");
        a3.setCognome("Verdi");
        a3.setNascita(LocalDate.of(2004, 12, 2));

/*        Autore a4 = new Autore();            //Prova exception*/

        Quadro q1 = new Quadro();
        try{
            q1.setTitolo("La Gioconda");
            q1.setAutore(a1);
            q1.setTecnicaUsata("ACQUERELLO");
        } catch(NullAuthorException e) {
            System.out.println("Autore non esistente o nullo\n");
        }

        Quadro q2 = new Quadro();
        try{
            q2.setTitolo("Ragazza col turbante");
            q2.setAutore(a2);
            q2.setTecnicaUsata("TEMPERA");
        } catch(NullAuthorException e) {
            System.out.println("Autore non esistente o nullo\n");
        }

        Quadro q3 = new Quadro();
        try{
            q3.setTitolo("L'urlo di Munch");
            q3.setAutore(a3);
            q3.setTecnicaUsata("OLIO");
        } catch(NullAuthorException e) {
            System.out.println("Autore non esistente o nullo\n");
        }

/*        Quadro q4= new Quadro();            //Prova exception
        try {
            q4.setTitolo("Prova exception");
            q4.setAutore(a4);
            q4.setTecnicaUsata("OLIO");
        } catch(NullAuthorException e){
            System.out.println("Autore non esistente o nullo\n");
        }*/

        Statua s1= new Statua();
        try{
            s1.setTitolo("David");
            s1.setAutore(a1);
            s1.setMateriale("MARMO");
            s1.setAltezza(5.20);
        } catch(NullAuthorException e){
            System.out.println("Autore non esistente o nullo\n");
        }

        Statua s2= new Statua();
        try{
            s2.setTitolo("Cristo Redentore");
            s2.setAutore(a2);
            s2.setMateriale("PIETRA");
            s2.setAltezza(38);
        } catch(NullAuthorException e){
            System.out.println("Autore non esistente o nullo\n");
        }

        Statua s3= new Statua();
        try{
            s3.setTitolo("Venere di Milo");
            s3.setAutore(a3);
            s3.setMateriale("GESSO");
            s3.setAltezza(2.02);
        } catch(NullAuthorException e){
            System.out.println("Autore non esistente o nullo\n");
        }

        try {
            m.carica(q1);       //esposizione
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        try {
            m.carica(q3);       //esposizione
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        try {
            m.carica(s1);       //esposizione
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        try {
            m.carica(q2);       //deposito
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        try {
            m.carica(s2);       //deposito
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        try {
            m.carica(s3);       //deposito
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        try {
            m.carica(s3);       //Errore: già presente
        } catch(AlreadyPresentException e) {
            System.out.println("Opera gia' presente\n");
        }

        System.out.println(m.stampaSala());
        System.out.println(m.stampaDeposito());

        try {
            m.sposta(s1.getId());       //spostato
        } catch(AlreadyPresentException e){
            System.out.println("Opera gia' presente in deposito\n");
        }

        try {
            m.sposta(q2.getId());       //Errore: già presente
        } catch(AlreadyPresentException e){
            System.out.println("Opera gia' presente in deposito\n");
        }

        try {
            m.cerca(q3.getId());        //sala
        } catch(NotFoundException e) {
            System.out.println("Opera non trovata nel museo\n");
        }

        try {
            m.cerca(s3.getId());        //deposito
        } catch(NotFoundException e) {
            System.out.println("Opera non trovata nel museo\n");
        }

 /*       try {
            m.cerca(q4.getId());        //Errore: non esistente
        } catch(NotFoundException e) {
            System.out.println("Opera non trovata nel museo\n");
        }*/

        System.out.println(m.stampaSala());
        System.out.println(m.stampaDeposito());

        System.out.println("Le opere di " + a2.getNome() + " " + a2.getCognome() + " sono: \n" + m.opereAutore(a2));

        System.out.println(m.quadriDaTecnica("ACQUERELLO"));
        System.out.println(m.statueDaMateriale("MARMO"));

/*        ComparatorStatuaMateriale csm= new ComparatorStatuaMateriale();
        System.out.println("Le statue ordinate per materiale (decrescente) sono:");
        m.ordinaStatue(csm);

        ComparatorQuadroTecnica cqt= new ComparatorQuadroTecnica();
        System.out.println("I quadri ordinati per tecnica (crescente) sono:");
        m.ordinaQuadri(cqt);

        ComparatorStatuaAutore csa= new ComparatorStatuaAutore();
        System.out.println("Le statue ordinate per autore (crescente) sono:");
        m.ordinaStatue(csa);

        ComparatorQuadroAutore cqa= new ComparatorQuadroAutore();
        System.out.println("I quadri ordinati per autore (decrescente) sono:");
        m.ordinaQuadri(cqa);

        ComparatorAutoreNascita can= new ComparatorAutoreNascita();
        System.out.println("Gli autori ordinati per nascita (crescente) sono:");
        m.ordinaAutori(can);*/

        Scanner sc= new Scanner(System.in);
        int lista= 0;
        int ordine= 0;
        try {
            System.out.println("Quale lista vuoi ordinare?");
            System.out.println("1 -> Quadri tecnica");
            System.out.println("2 -> Quadri autore");
            System.out.println("3 -> Statue materiale");
            System.out.println("4 -> Statue autore");
            System.out.println("5 -> Autore nascita");
            lista = sc.nextInt();
            if(lista>=1 && lista<=5){
                System.out.println("In quale ordine?");
                System.out.println("1 -> Crescente");
                System.out.println("2 -> Decrescente");
                ordine = sc.nextInt();
            } else
                System.out.println("Input non valido");
        } catch(InputMismatchException e){
            System.out.println("Input non valido");
        }
        Utente u= new Utente(lista, ordine);
        u.generaLista(m);
    }
}
