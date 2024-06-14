package Banca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banca {
    Map<String, Conto> conti = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void menuPrincipale() {
        String scelta;
        do {
            System.out.print("1. Crea conto\n2. Visualizza conto\n3. Deposita\n4. Preleva\n5. Esci\nScelta: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1":
                    creaConto();
                    break;
                case "2":
                    visualizzaConto();
                    break;
                case "3":
                    deposita();
                    break;
                case "4":
                    preleva();
                    break;
                case "5":
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (!scelta.equals("5"));
    }

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
