package Interesse;

public class Denaro {
    private final double Capitale;
    private final double Interesse;

    public Denaro(double capitale, double interesse) {
        Capitale = capitale;
        Interesse = interesse;
    }

    public double getInteresseAnnuo() {
        return Capitale * Interesse;
    }
}
