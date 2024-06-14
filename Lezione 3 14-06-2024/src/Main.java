import Dizionario.DizionarioPersonale;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        DizionarioPersonale dizionario = new DizionarioPersonale();

        String scelta = "";
        while(!scelta.equals("0")){
            System.out.print("1. Cerca parola\n2. Aggiungi parola\n3. Mostra dizionario\n4. Aggiorna parola\n5. Elimina parola\n0. Esci\nScegli un'opzione: ");
            scelta = scanner.nextLine();
            switch(scelta){
                case "1":
                    cercaParola(dizionario);
                    break;
                case "2":
                    aggiungiParola(dizionario);
                    break;
                case "3":
                    mostraDizionario(dizionario);
                    break;
                case "4":
                    aggiornaParola(dizionario);
                    break;
                case "5":
                    eliminaParola(dizionario);
                    break;
                case "0":
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    public static void cercaParola(DizionarioPersonale dizionario){
        System.out.print("Inserisci la parola da cercare: ");
        String parola = scanner.nextLine();
        String significato = dizionario.getSignificato(parola);
        if(significato != null){
            System.out.println("Il significato di " + parola + " è: " + significato);
        } else {
            System.out.println("La parola " + parola + " non è presente nel dizionario.");
        }
    }

    public static void aggiungiParola(DizionarioPersonale dizionario){
        System.out.print("Inserisci la parola da aggiungere: ");
        String parola = scanner.nextLine();
        System.out.print("Inserisci il significato della parola: ");
        String significato = scanner.nextLine();
        dizionario.aggiungiParola(parola, significato);
    }

    public static void mostraDizionario(DizionarioPersonale dizionario){
        System.out.println("Dizionario:");
        for(String parola : dizionario.getDizionario().keySet()){
            System.out.println(parola + ": " + dizionario.getSignificato(parola));
        }
    }

    public static void aggiornaParola(DizionarioPersonale dizionario){
        System.out.print("Inserisci la parola da aggiornare: ");
        String parola = scanner.nextLine();
        System.out.print("Inserisci il nuovo significato della parola: ");
        String significato = scanner.nextLine();
        dizionario.aggiungiParola(parola, significato);
    }

    public static void eliminaParola(DizionarioPersonale dizionario){
        System.out.print("Inserisci la parola da eliminare: ");
        String parola = scanner.nextLine();
        dizionario.getDizionario().remove(parola);
    }
}