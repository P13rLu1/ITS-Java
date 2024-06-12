import Poligoni.Rettangolo;
import Poligoni.Triangolo;
import Interesse.Denaro;

public class Main {
    public static void main(String[] args) {
        ProvaStringhe();

        CalcoloPoligoni();

        CalcoloInteresse();

        VedereStagioni();
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
            System.out.printf("la somma dopo anni %d é di: %.1f\n", i, sommaTotale);
            capitale = sommaTotale;
        }
    }

    public static void VedereStagioni() {
        int numeroMese = 3;
        switch (numeroMese) {
            case 1:
            case 2:
                System.out.println("Inverno");
                break;
            case 3:
                System.out.println("Inverno o Primavera");
                break;
            case 4:
            case 5:
                System.out.println("Primavera");
                break;
            case 6:
                System.out.println("Primavera o Estate");
                break;
            case 7:
            case 8:
                System.out.println("Estate");
                break;
            case 9:
                System.out.println("Estate o Autunno");
                break;
            case 10:
            case 11:
                System.out.println("Autunno");
                break;
            case 12:
                System.out.println("Autunno o Inverno");
                break;
            default:
                System.out.println("Mese non valido");
        }

        if (numeroMese == 3) {
            System.out.println("Inverno o Primavera");
        } else if (numeroMese == 4 || numeroMese == 5) {
            System.out.println("Primavera");
        } else if (numeroMese == 6) {
            System.out.println("Primavera o Estate");
        } else if (numeroMese == 7 || numeroMese == 8) {
            System.out.println("Estate");
        } else if (numeroMese == 9) {
            System.out.println("Estate o Autunno");
        } else if (numeroMese == 10 || numeroMese == 11) {
            System.out.println("Autunno");
        } else if (numeroMese == 12) {
            System.out.println("Autunno o Inverno");
        } else if (numeroMese == 1 || numeroMese == 2) {
            System.out.println("Inverno");
        } else {
            System.out.println("Mese non valido");
        }
    }
}