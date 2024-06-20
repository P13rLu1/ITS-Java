package it.apuliadigital.biblioteca;

public class Docente extends Utente {

    public Docente(String nome, String cognome, String numeroTelefono, String matricola) {
        super(nome, cognome, numeroTelefono, matricola);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Cognome: " + getCognome() + ", Matricola: " + getMatricola() + ", Numero di telefono: " + getNumeroTelefono();
    }
}
