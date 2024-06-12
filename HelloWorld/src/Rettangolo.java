public class Rettangolo {

    private final double Base;
    private final double Altezza;

    public Rettangolo(double base, double altezza) {
        Base = base;
        Altezza = altezza;
    }

    public double getArea() {
        return Base * Altezza;
    }

    public double getPerimetro() {
        return 2 * (Base + Altezza);
    }

    @Override
    public String toString() {
        return "Perimetro: " + getPerimetro() + "\nArea: " + getArea();
    }
}
