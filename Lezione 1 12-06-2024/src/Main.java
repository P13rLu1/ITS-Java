import Poligoni.Rettangolo;
import Poligoni.Triangolo;
import Interesse.Denaro;

public class Main {
    public static void main(String[] args) {
        ProvaStringhe();

        CalcoloPoligoni();

        CalcoloInteresse();
    }

    public static void ProvaStringhe() {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        String ma = "Ma";
        double uno = 1.23;
        String rio = ma + "rio";
        System.out.println(rio);
        rio += " Mario";
        System.out.println(rio);

        System.out.printf("Hello %f\n", uno);
    }

    public static void CalcoloPoligoni() {
        Rettangolo rettangolo = new Rettangolo(3, 7);
//        System.out.printf("\nRettangolo\nArea: %.2f\nPerimetro %.2f\n", rettangolo.getArea(), rettangolo.getPerimetro());
        System.out.println("\nPoligoni.Rettangolo:\n" + rettangolo);

        Triangolo triangolo = new Triangolo(3, 7);
//        System.out.printf("\nTriangolo\nArea: %.2f\nPerimetro %.2f\n", triangolo.getArea(), triangolo.getPerimetro());
        System.out.println("\nPoligoni.Triangolo:\n" + triangolo);
    }

    public static void CalcoloInteresse() {
        System.out.println("\nInteresse del Denaro:");
        double capitale = 1000;
        double interesse = 0.1;
        int anni = 3;
        for (int i = 1; i <= anni; i++) {
            double sommaTotale = capitale + new Denaro(capitale, interesse).getInteresseAnnuo();
            System.out.printf("La somma dopo anni %d è %.2f\n", i, sommaTotale);
            capitale = sommaTotale;
        }
    }
}