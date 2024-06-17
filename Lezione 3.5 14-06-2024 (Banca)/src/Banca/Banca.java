package Banca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banca {
    // HashMap<IBAN, Conto> un iban è associato ad un oggetto conto
    Map<String, Conto> conti = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    // Menu principale
    public void menuPrincipale() {
        String scelta;
        do {
            System.out.print("1. Crea conto\n2. Visualizza conto\n3. Deposita\n4. Preleva\n5. Esci\nScelta: ");
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
        if (conti.containsKey(iban)) {
            System.out.println("Conto già esistente");
        } else {
            conti.put(iban, new Conto(iban));
            System.out.println("Conto creato con successo");
        }
    }

    // Metodo per visualizzare il saldo di un conto corrente
    private void visualizzaConto() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        Conto c = conti.get(iban);
        if (c == null) {
            System.out.println("Conto non esistente");
        } else {
            System.out.println("IBAN: " + c.getIban());
            System.out.println("Saldo: " + c.getSaldo());
        }
    }

    // Metodo per depositare denaro in un conto corrente
    private void deposita() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        Conto c = conti.get(iban);
        if (c == null) {
            System.out.println("Conto non esistente");
        } else {
            System.out.print("Importo: ");
            double importo = scanner.nextDouble();
            c.deposita(importo);
            System.out.println("Deposito effettuato con successo");
        }
    }

    // Metodo per prelevare denaro da un conto corrente
    private void preleva() {
        System.out.print("IBAN: ");
        String iban = scanner.nextLine();
        Conto c = conti.get(iban);
        if (c == null) {
            System.out.println("Conto non esistente");
        } else {
            System.out.print("Importo: ");
            double importo = scanner.nextDouble();
            c.preleva(importo);
            System.out.println("Prelievo effettuato con successo");
        }
    }
}
