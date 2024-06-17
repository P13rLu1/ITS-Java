package Animalo;

public abstract class Animale {
    // dichiarazione delle variabili
    private String nome;
    private String razza;
    private int eta;
    private String mangia;

    // costruttore
    public Animale(String nome, String razza, int eta, String mangia) {
        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
        this.mangia = mangia;
    }

    // metodi getter
    public String getMangia() {
        return mangia;
    }
    public int getEta() {
        return eta;
    }
    public String getRazza() {
        return razza;
    }
    public String getNome() {
        return nome;
    }

    // metodo astratto cosaMangia da implementare nelle classi figlie
    public abstract String cosaMangia();
}
