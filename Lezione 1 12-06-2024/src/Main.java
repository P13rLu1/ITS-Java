import Poligoni.Rettangolo;
import Poligoni.Triangolo;
import Interesse.Denaro;
import Calendario.Calendario2024;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        provaStringhe();

        calcoloPoligoni();

        calcoloInteresse();

        vedereStagioni();

        metodiArray();

        fibonacci();

        calendario2024();

        System.out.println("\nFine del programma");
    }

    // Metodo per provare le stringhe
    public static void provaStringhe() {
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

    // Metodo per calcolare le aree e i perimetri di Poligoni.Rettangolo e Poligoni.Triangolo
    public static void calcoloPoligoni() {
        Rettangolo rettangolo = new Rettangolo(3, 7);
//        System.out.printf("\nRettangolo\nArea: %.2f\nPerimetro %.2f\n", rettangolo.getArea(), rettangolo.getPerimetro());
        System.out.println("\nPoligoni.Rettangolo:\n" + rettangolo);

        Triangolo triangolo = new Triangolo(3, 7);
//        System.out.printf("\nTriangolo\nArea: %.2f\nPerimetro %.2f\n", triangolo.getArea(), triangolo.getPerimetro());
        System.out.println("\nPoligoni.Triangolo:\n" + triangolo);
    }

    // Metodo per calcolare l'interesse del Denaro
    public static void calcoloInteresse() {
        System.out.println("\nInteresse del Denaro:");
        Denaro denaro = new Denaro(1000, 0.09);
        int anni = 3;
        for (int i = 1; i <= anni; i++) { // Calcolo Interesse Annuo per <anni> anni
            denaro.getInteresseAnnuo();
            System.out.printf("Il Saldo dopo Anni %d é di: %.1f€ con saldo %.2f\n", i, denaro.dammiSomma(), denaro.getInteresse());

            denaro.setInteresse(denaro.getInteresse() + 0.01);
        }
    }

    // Metodo per vedere le stagioni
    public static void vedereStagioni() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserire il numero del mese: ");
        int numeroMese = scanner.nextInt();

        // Switch per vedere le stagioni
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

        // Switch per vedere le stagioni (Java 12+)
        switch (numeroMese) {
            case 1, 2 -> System.out.println("Inverno");
            case 3 -> System.out.println("Inverno o Primavera");
            case 4, 5 -> System.out.println("Primavera");
            case 6 -> System.out.println("Primavera o Estate");
            case 7, 8 -> System.out.println("Estate");
            case 9 -> System.out.println("Estate o Autunno");
            case 10, 11 -> System.out.println("Autunno");
            case 12 -> System.out.println("Autunno o Inverno");
            default -> System.out.println("Mese non valido");
        }

        // If-Else per vedere le stagioni
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

    // Metodo per provare gli array
    public static void metodiArray() {
        int[] array = {3, 2, 1, 4, 5, 6, 8, 7, 10, 9};

        //trova il massimo
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Il massimo è: " + max);

        //ordina l'array in modo crescente
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        //stampa l'array ordinato in modo crescente
        System.out.print("Array ordinato: ");
        for (int j : array) {
            System.out.print(j + " ");
        }

        //creare un nuovo array di 10 numeri e riempirlo con i numeri ordinati in modo decrescente
        int[] arrayDecrescente = new int[10];
        for (int i = 0; i < array.length; i++) {
            arrayDecrescente[i] = array[array.length - 1 - i];
        }

        //stampa l'array ordinato in modo decrescente
        System.out.print("\nArray decrescente: ");
        for (int j : arrayDecrescente) {
            System.out.print(j + " ");
        }
    }

    // Metodo per calcolare la successione di Fibonacci
    public static void fibonacci() {
        int n = 10;
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        System.out.print("\nSerie di Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
    }

    // Metodo per stampare il giorno corrente
    public static void calendario2024() {
        //giorno corrente
        int giornoCorrente = 13;
        int meseCorrente = 6;

        Calendario2024 calendario = new Calendario2024();
        System.out.println("\nOggi é: " + calendario.getGiorno(meseCorrente, giornoCorrente));

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("EEEE");
        System.out.println("Oggi é: " + df.format(date));
    }
}