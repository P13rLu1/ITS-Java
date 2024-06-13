package Interesse;

public class Denaro {
    private double capitale;
    private double interesse;

    public Denaro(double capitale, double interesse) {
        this.capitale = capitale;
        this.interesse = interesse;
    }

    // Getter e Setter Capitale
    public double getCapitale() {
        return capitale;
    }

    public void setCapitale(double capitale) {
        this.capitale = capitale;
    }

    // Getter e Setter Interesse
    public double getInteresse() {
        return interesse;
    }

    public void setInteresse(double interesse) {
        this.interesse = interesse;
    }

    // Metodo per calcolare l'interesse annuo
    public void getInteresseAnnuo() {
        capitale += capitale * interesse;
    }

    // Metodo per restituire il capitale
    public double dammiSomma() {
        return capitale;
    }
}
