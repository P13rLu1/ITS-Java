package Persone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona{
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String numeroTelefono;

    public Persona(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroTelefono = numeroTelefono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "[" + nome + "|" + cognome + "|" + formatter.format(dataDiNascita) + "|" + numeroTelefono + "]";
    }
}
