import Dizionario.DizionarioPersonale;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        DizionarioPersonale dizionario = new DizionarioPersonale();
        String scelta = "";
        System.out.println("Benvenuto nel dizionario personale!");
        while (!scelta.equals("0")) {
            System.out.print("1. Cerca parola\n2. Aggiungi parola\n3. Mostra dizionario\n4. Aggiorna parola\n5. Elimina parola\n0. Esci\nScegli un'opzione: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "1":
                    System.out.print("Inserisci la parola da cercare: ");
                    String parola = scanner.nextLine();
                    dizionario.cercaParola(parola);
                    break;
                case "2":
                    System.out.print("Inserisci la parola da aggiungere: ");
                    String parolaDaAggiungere = scanner.nextLine();
                    System.out.print("Inserisci il significato della parola: ");
                    String significato = scanner.nextLine();
                    dizionario.aggiungiParola(parolaDaAggiungere, significato);
                    break;
                case "3":
                    System.out.println(dizionario.getDizionario());
                    break;
                case "4":
                    System.out.print("Inserisci la parola da aggiornare: ");
                    String parolaDaAggiornare = scanner.nextLine();
                    System.out.print("Inserisci il nuovo significato della parola: ");
                    String nuovoSignificato = scanner.nextLine();
                    dizionario.aggiornaParola(parolaDaAggiornare, nuovoSignificato);
                    break;
                case "5":
                    System.out.print("Inserisci la parola da eliminare: ");
                    String parolaDaEliminare = scanner.nextLine();
                    dizionario.eliminaParola(parolaDaEliminare);
                    break;
                case "0":
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}