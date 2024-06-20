package Rubrica;

import java.io.Serializable;

public class Contatto implements Comparable <Contatto>, Serializable  {


    private String nome;
    private String cognome;
    private String numero;

    public Contatto(String nome, String cognome, String numero) {

        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }


    public Contatto() {
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return  getNome() + " " + getCognome() + ": " + getNumero() ;
    }


    @Override
    public int compareTo(Contatto contattoComparato) {
        return this.cognome.compareTo(contattoComparato.getCognome());
    }



}
