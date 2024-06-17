package Banca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banca {
    // HashMap<IBAN, Conto> un iban è associato ad un oggetto conto
    Map<String, ContoCorrente> conti = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    // Menu principale
    public void menuPrincipale() {
        String scelta;
        do {
            System.out.print("A Cosa Vuoi Accedere?\n1. Conto Fiduciario\n2. Conto Deposito\nScelta: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1" -> menuContoFiduciario();
                case "2" -> menuContoDeposito();
                default -> System.out.println("Scelta non valida");
            }
        } while (!scelta.equals("5"));
    }

    // Menu per il conto fiduciario
    private void menuContoFiduciario() {
        String scelta;
        do {
            System.out.print("Che Vuoi Fare?\n1. Crea Conto\n2. Visualizza Conto\n3. Deposita\n4. Preleva\n5. Torna al Menu Principale\nScelta: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1" -> creaConto();
                case "2" -> visualizzaConto();
                case "3" -> deposita();
                case "4" -> preleva();
                case "5" -> System.out.println("Arrivederci!");
                default -> System.out.println("Scelta non valida");
            }
        } while (!scelta.equals("5"));
    }

    // Metodo per creare un conto corrente
    private void creaConto() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        try {
            System.out.print("Fido: ");
            int fido = scanner.nextInt();
            if (conti.containsKey(iban)) {
                System.out.println("Conto già esistente");
            } else {
                conti.put(iban, new ContoFiduciario(iban, fido));
                System.out.println("Conto creato con successo");
            }
        } catch (Exception e) {
            System.out.println("Fido non valido");
        }

        premiUnTastoPerContinuare();
    }

    // Metodo per visualizzare il saldo di un conto corrente
    private void visualizzaConto() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        try {
            if (c == null) {
                System.out.println("Conto non esistente");
            } else {
                System.out.println("Saldo: " + c.getSaldo());
            }
        } catch (Exception e) {
            System.out.println("IBAN non valido");
        }

        premiUnTastoPerContinuare();
    }

    // Metodo per depositare denaro in un conto corrente
    private void deposita() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        try {
            if (c == null) {
                System.out.println("Conto non esistente");
            } else {
                System.out.print("Importo: ");
                double importo = scanner.nextDouble();
                c.deposita(importo);
                System.out.println("Deposito effettuato con successo");
            }
        } catch (Exception e) {
            System.out.println("IBAN non valido");
        }

        premiUnTastoPerContinuare();
    }

    // Metodo per prelevare denaro da un conto corrente
    private void preleva() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        try {
            if (c == null) {
                System.out.println("Conto non esistente");
            } else {
                System.out.print("Importo: ");
                double importo = scanner.nextDouble();
                c.preleva(importo);
                System.out.println("Prelievo effettuato con successo");
            }
        } catch (Exception e) {
            System.out.println("IBAN non valido");
        }

        premiUnTastoPerContinuare();
    }

    // Menu per il conto deposito
    private void menuContoDeposito() {
        String scelta;
        do {
            System.out.print("Che Vuoi Fare?\n1. Crea Conto\n2. Visualizza Conto\n3. Deposita\n4. Calcola Interessi\n5. Torna al Menu Principale\nScelta: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1" -> creaContoDeposito();
                case "2" -> visualizzaContoDeposito();
                case "3" -> depositaDeposito();
                case "4" -> calcolaInteressi();
                case "5" -> System.out.println("Arrivederci!");
                default -> System.out.println("Scelta non valida");
            }
        } while (!scelta.equals("5"));
    }

    // Metodo per creare un conto deposito
    private void creaContoDeposito() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        try {
            System.out.print("Tasso Interesse: ");
            double tassoInteresse = scanner.nextDouble();
            if (conti.containsKey(iban)) {
                System.out.println("Conto già esistente");
            } else {
                conti.put(iban, new ContoDeposito(iban, tassoInteresse));
                System.out.println("Conto creato con successo");
            }
        } catch (Exception e) {
            System.out.println("Tasso Interesse non valido");
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per visualizzare il saldo di un conto deposito
    private void visualizzaContoDeposito() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        try {
            if (c == null) {
                System.out.println("Conto non esistente");
            } else {
                System.out.println("Saldo: " + c.getSaldo());
            }
        } catch (Exception e) {
            System.out.println("IBAN non valido");
        }

        premiUnTastoPerContinuare();
    }

    // Metodo per depositare denaro in un conto deposito
    private void depositaDeposito() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        try {
            if (c == null) {
                System.out.println("Conto non esistente");
            } else {
                System.out.print("Importo: ");
                double importo = scanner.nextDouble();
                c.deposita(importo);
                System.out.println("Deposito effettuato con successo");
            }
        } catch (Exception e) {
            System.out.println("IBAN non valido");
        }

        premiUnTastoPerContinuare();
    }

    // Metodo per calcolare gli interessi maturati di un conto deposito
    private void calcolaInteressi() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        if (c instanceof ContoDeposito cd){
            try {
                cd.calcolaInteressi();
                System.out.println("Interessi calcolati con successo");
            } catch (Exception e) {
                System.out.println("IBAN non valido");
            }
        }
        else {
            System.out.println("Conto non esistente");
        }

        premiUnTastoPerContinuare();
    }

    // Metodo per far attendere l'utente prima di continuare
    private void premiUnTastoPerContinuare() {
        try {
            System.out.print("Premi un tasto per continuare...");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
