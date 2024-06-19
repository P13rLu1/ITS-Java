package Banca;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banca {
    // HashMap<IBAN, Conto> un iban è associato ad un oggetto conto
    Map<String, ContoCorrente> conti = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    // Costruttore per caricare i conti dal file
    public Banca() {
        caricaContiDaFile();
    }

    // Menu principale
    public void menuPrincipale() {
        String scelta;
        do {
            System.out.print("A Cosa Vuoi Accedere?\n1. Conto Fiduciario\n2. Conto Deposito\n5. Esci\nScelta: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1" -> gestisciConto("fiduciario");
                case "2" -> gestisciConto("deposito");
                case "5" -> {
                    salvaContiSuFile();
                    System.out.println("Arrivederci!");
                }
                default -> System.out.println("Scelta non valida");
            }
        } while (!scelta.equals("5"));
    }

    // Metodo generico per la gestione di conti
    private void gestisciConto(String tipoConto) {
        String scelta;
        do {
            System.out.printf("Che Vuoi Fare?\n1. Crea Conto\n2. Visualizza Conto\n3. Deposita\n4. %s\n5. Torna al Menu Principale\nScelta: ",
                    tipoConto.equals("fiduciario") ? "Preleva" : "Calcola Interessi");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1" -> {
                    if (tipoConto.equals("fiduciario")) creaContoFiduciario();
                    else creaContoDeposito();
                }
                case "2" -> visualizzaConto();
                case "3" -> deposita();
                case "4" -> {
                    if (tipoConto.equals("fiduciario")) preleva();
                    else calcolaInteressi();
                }
                case "6" -> System.out.println("Torna al Menu Principale");
                default -> System.out.println("Scelta non valida");
            }
        } while (!scelta.equals("5"));
    }

    // Metodo per creare un conto fiduciario
    private void creaContoFiduciario() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        try {
            System.out.print("Fido: ");
            int fido = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline
            if (conti.containsKey(iban)) {
                System.out.println("Conto già esistente");
            } else {
                conti.put(iban, new ContoFiduciario(iban, fido));
                System.out.println("Conto creato con successo");
            }
        } catch (Exception e) {
            System.out.println("Fido non valido");
            scanner.nextLine(); // Consuma il newline
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per creare un conto deposito
    private void creaContoDeposito() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        try {
            System.out.print("Tasso Interesse: ");
            double tassoInteresse = scanner.nextDouble();
            scanner.nextLine(); // Consuma il newline
            if (conti.containsKey(iban)) {
                System.out.println("Conto già esistente");
            } else {
                conti.put(iban, new ContoDeposito(iban, tassoInteresse));
                System.out.println("Conto creato con successo");
            }
        } catch (Exception e) {
            System.out.println("Tasso Interesse non valido");
            scanner.nextLine(); // Consuma il newline
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per visualizzare il saldo di un conto corrente
    private void visualizzaConto() {
        ContoCorrente c = ottieniConto();
        if (c != null) {
            System.out.println("Saldo: " + c.getSaldo());
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per depositare denaro in un conto corrente
    private void deposita() {
        ContoCorrente c = ottieniConto();
        if (c != null) {
            try {
                System.out.print("Importo: ");
                double importo = scanner.nextDouble();
                scanner.nextLine(); // Consuma il newline
                c.deposita(importo);
                System.out.println("Deposito effettuato con successo");
            } catch (Exception e) {
                System.out.println("Importo non valido");
                scanner.nextLine(); // Consuma il newline
            }
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per prelevare denaro da un conto corrente
    private void preleva() {
        ContoCorrente c = ottieniConto();
        if (c != null) {
            try {
                System.out.print("Importo: ");
                double importo = scanner.nextDouble();
                scanner.nextLine();
                c.preleva(importo);
                System.out.println("Prelievo effettuato con successo");
            } catch (Exception e) {
                System.out.println("Importo non valido");
                scanner.nextLine();
            }
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per calcolare gli interessi maturati di un conto deposito
    private void calcolaInteressi() {
        ContoCorrente c = ottieniConto();
        if (c instanceof ContoDeposito cd) {
            cd.calcolaInteressi();
            System.out.println("Interessi calcolati con successo");
        } else {
            System.out.println("Conto non esistente o non è un conto deposito");
        }
        premiUnTastoPerContinuare();
    }

    // Metodo per ottenere un conto dal IBAN
    private ContoCorrente ottieniConto() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        ContoCorrente c = conti.get(iban);
        if (c == null) {
            System.out.println("Conto non esistente");
        }
        return c;
    }

    // Metodo per far attendere l'utente prima di continuare
    private void premiUnTastoPerContinuare() {
        System.out.print("Premi un tasto per continuare...");
        scanner.nextLine();
    }

    // Metodo per salvare i conti su file
    private void salvaContiSuFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("conti.txt"))) {
            oos.writeObject(conti);
            System.out.println("Dati salvati correttamente");
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio dei dati");
        }
    }

    // Metodo per caricare i conti dal file
    private void caricaContiDaFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("conti.txt"))) {
            if (ois.readObject() instanceof Map<?, ?> map){
                conti = (Map<String, ContoCorrente>) map;
            }
            System.out.println("Dati caricati correttamente");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore nel caricamento dei dati");
        }
    }
}