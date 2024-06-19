import Persona.Persona;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Application");

        File file = new File("file1.txt");
        File file2 = new File("file2.txt");

        // Check if file exists
        if (file.isFile()) { //controlla se file1 esiste
            try {
                FileReader fileReader = new FileReader(file); //questa riga legge il contenuto di file1
                BufferedReader bufferedReader = new BufferedReader(fileReader); //questa riga fa il buffer del contenuto di file1

                Writer out = new BufferedWriter(new FileWriter(file2));  //scrive su file2 il contenuto di file1 in maiuscolo

                String line; //variabile che contiene la riga di file1

                while ((line = bufferedReader.readLine()) != null) { //legge il contenuto di file1 riga per riga e lo mette in line
                    out.write(line.toUpperCase()); //scrive su file2 il contenuto di file1 in maiuscolo
                    out.flush(); //svuota il buffer
                }

                bufferedReader.close(); //chiude il buffer
            } catch (Exception e) { //se c'è un errore stampa l'errore
                System.out.println("Error: " + e.getMessage());
            }
        }

        Persona persona = new Persona("Mario", "Rossi");

        Path path = Paths.get("persona.txt"); //questa riga crea un path per il file persona.txt

        try {
            FileOutputStream fos = new FileOutputStream(path.toFile()); //questa riga crea un file persona.txt

            ObjectOutputStream oos = new ObjectOutputStream(fos); //questa riga crea un buffer per scrivere su persona.txt

            oos.writeObject(persona); //scrive su persona.txt l'oggetto persona

            oos.close(); //chiude il buffer
        } catch (Exception e) { //se c'è un errore stampa l'errore
            System.out.println("Error: " + e.getMessage());
        }

        try {
            FileInputStream fis = new FileInputStream(path.toFile()); //questa riga legge il file persona.txt

            ObjectInputStream ois = new ObjectInputStream(fis); //questa riga crea un buffer per leggere da persona.txt

            Persona p = (Persona) ois.readObject(); //legge da persona.txt l'oggetto persona

            System.out.println(p.getCognome());//stampa l'oggetto persona

            ois.close(); //chiude il buffer
        } catch (Exception e) { //se c'è un errore stampa l'errore
            System.out.println("Error: " + e.getMessage());
        }
    }
}