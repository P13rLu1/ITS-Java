package Animalo;

public class Cane extends Animale {
    // costruttore della classe Cane che richiama il costruttore della classe Animale
    public Cane(String nome, String razza, int eta, String mangia) {
        super(nome, razza, eta, mangia);
    }

    // implementazione del metodo astratto cosaMangia della classe Animale
    public String cosaMangia() {
        return getMangia();
    }

    // override del metodo toString per la classe Cane
    @Override
    public String toString() {
        return "Cane";
    }
}
