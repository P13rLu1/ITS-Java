package it.apuliadigital.biblioteca;

public class Libro {

    private String titolo;
    private String autore;
    private String ISBN;
    private Stato stato;

    public Libro(String titolo, String autore, String ISBN, Stato stato) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.stato = stato;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", ISBN: " + ISBN + ", Stato: " + stato;
    }
}
