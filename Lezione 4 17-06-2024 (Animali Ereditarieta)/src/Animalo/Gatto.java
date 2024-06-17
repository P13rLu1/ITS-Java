package Animalo;

public class Gatto extends Animale{
    // costruttore della classe Gatto che richiama il costruttore della classe Animale
    public Gatto(String nome, String razza, int eta, String mangia) {
        super(nome, razza, eta, mangia);
    }

    // implementazione del metodo astratto cosaMangia della classe Animale
    public String cosaMangia() {
        return getMangia();
    }

    // override del metodo toString per la classe Gatto
    @Override
    public String toString() {
        return "Gatto";
    }
}
