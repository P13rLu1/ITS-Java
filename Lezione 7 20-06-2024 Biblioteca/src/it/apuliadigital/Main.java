package it.apuliadigital;

import it.apuliadigital.biblioteca.Biblioteca;
import it.apuliadigital.biblioteca.Libro;
import it.apuliadigital.biblioteca.Stato;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            Biblioteca b = new Biblioteca();
            b.aggiungiPersona("Mario", "Rossi", "312717", "123", "Studente");
            b.aggiungiPersona("Luca", "Bianchi", "312717", "124", "Docente");

            b.rimuoviPersona("123");

            b.aggiungiLibro("Il signore degli anelli", "J.R.R. Tolkien", "123", Stato.DISPONIBILE);
            b.aggiungiLibro("Il Trono Di Spade", "George R.R. Martin", "124", Stato.IN_PRESTITO);
            b.aggiungiLibro("Il Diario Di Anne Frank", "Papá Anne Frank", "125", Stato.PRENOTATO);
            b.aggiungiLibro("Il Piccolo Principe", "Antoine de Saint-Exupéry", "126", Stato.DISPONIBILE);

            Libro l1 = new Libro("Il Piccolo Principe", "Antoine de Saint-Exupéry", "127", Stato.DISPONIBILE);
            Libro l2 = new Libro("Il Diario Di Anne Frank", "Papá Anne Frank", "128", Stato.PRENOTATO);
            Libro l3 = new Libro("Il Trono Di Spade", "George R.R. Martin", "129", Stato.IN_PRESTITO);
            Libro l4 = new Libro("Il signore degli anelli", "J.R.R. Tolkien", "130", Stato.DISPONIBILE);

            b.aggiungiLibri(Arrays.asList(l1, l2, l3, l4));

            b.rimuoviLibro("126");

            b.verificaPresenzaLibro("123");

            b.richiediLibro("123", "124");
            b.richiediLibro("122", "124");

            b.rimuoviPrestito("122");

            b.verificaPrestito("123");

            b.reportPrestiti("report.txt");
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}