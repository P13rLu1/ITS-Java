package it.apuliadigital.biblioteca;

public class Studente extends Utente {

    public Studente(String nome, String cognome, String matricola, String numeroTelefono) {
        super(nome, cognome, matricola, numeroTelefono);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Cognome: " + getCognome() + ", Matricola: " + getMatricola() + ", Numero di telefono: " + getNumeroTelefono();
    }
}
