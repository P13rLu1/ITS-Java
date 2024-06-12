package Poligoni;

public class Triangolo {

    private final double Base;
    private final double Altezza;

    public Triangolo(double base, double altezza) {
        Base = base;
        Altezza = altezza;
    }

    public double getArea() {
        return (Base * Altezza) / 2;
    }

    public double getPerimetro() {
        return Base * 3;
    }

    @Override
    public String toString() {
        return "Perimetro: " + getPerimetro() + "\nArea: " + getArea();
    }
}