package it.apuliadigital.biblioteca;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Prestito implements Comparable<Prestito>, Serializable {
    @Serial
    private static final long serialVersionUID = 3130209274725626467L;
    private String matricola;
    private String ISBN;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public Prestito(String matricola, String ISBN, LocalDate dataInizio, LocalDate dataFine) {
        this.matricola = matricola;
        this.ISBN = ISBN;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Prestito(String matricola, String ISBN) {
        this.matricola = matricola;
        this.ISBN = ISBN;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Matricola: " + matricola + ", ISBN: " + ISBN + ", Data inizio: " + dataInizio + ", Data fine: " + dataFine;
    }

    @Override
    public int compareTo(Prestito prestitoComparato) {
        return this.matricola.compareTo(prestitoComparato.getMatricola());
    }
}
