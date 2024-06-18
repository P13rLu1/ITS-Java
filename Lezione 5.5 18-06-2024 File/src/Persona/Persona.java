package Persona;

import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 3230104742152883405L;
    private String nome;

    private String cognome;

    public Persona() {
    }

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
