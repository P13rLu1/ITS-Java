package Interesse;

public class Denaro {
    private double Capitale;
    private double Interesse;

    public Denaro(double capitale, double interesse) {
        Capitale = capitale;
        Interesse = interesse;
    }

    public double getInteresseAnnuo() {
        return Capitale * Interesse;
    }
}
