package Persona;

import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = -1389085823247596142L;
    private String nome;
    private String cognome;

    public Persona() {
    }

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getCognome() {
        return nome;
    }
}
