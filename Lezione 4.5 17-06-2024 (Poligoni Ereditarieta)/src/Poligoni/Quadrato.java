package Poligoni;

public class Quadrato extends Rettangolo {

    public Quadrato(double lato) {
        super(lato, lato);
    }

    @Override
    public String toString() {
        return "Quadrato\nPerimetro: " + getPerimetro() + "\nArea: " + getArea();
    }
}