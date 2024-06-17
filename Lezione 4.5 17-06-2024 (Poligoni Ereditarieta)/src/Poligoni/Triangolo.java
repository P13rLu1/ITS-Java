package Poligoni;

public class Triangolo extends Poligono {

    private final double Base;
    private final double Altezza;

    public Triangolo(double base, double altezza) {
        Base = base;
        Altezza = altezza;
    }

    @Override
    public double getArea() {
        return (Base * Altezza) / 2;
    }

    @Override
    public double getPerimetro() {
        return Base * 3;
    }

    @Override
    public String toString() {
        return "Triangolo\nPerimetro: " + getPerimetro() + "\nArea: " + getArea();
    }
}