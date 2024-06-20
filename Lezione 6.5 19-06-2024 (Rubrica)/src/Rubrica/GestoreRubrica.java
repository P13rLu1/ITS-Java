package Rubrica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestoreRubrica {

    private List<Contatto> contatti;

    public GestoreRubrica() {

        this.contatti = new ArrayList<>();
    }

    public void aggiungiContatto(String nome, String cognome, String numero) {
        if (nome == null || cognome == null || numero == null) {

            throw new IllegalArgumentException("I parametri non possono essere nulli!");

        }

        for (Contatto contatto : contatti) {

            if (contatto.getNumero().equals(numero)) {
                System.out.println("Numero inserito già presente in rubrica!");
                return;
            }

        }

        Contatto nuovContatto = new Contatto(nome, cognome, numero);
        contatti.add(nuovContatto);

    }

    public void stampa() {
        if (contatti.isEmpty()) {

            System.out.println("Nessun contatto da mostrare!");
            return;
        }

        // contatti.sort(Comparator.comparing(Contatto::getCognome));
        Collections.sort(contatti);
        System.out.println("--------------------------");
        for (Contatto contatto : contatti) {
            System.out.println(contatto.toString());
        }
        System.out.println("--------------------------");
    }

    public void ricercaContatto(String numeroDaCercare) {
        if (contatti.isEmpty()) {

            System.out.println("Nessun contatto da mostrare!");
            return;
        }

        for (Contatto contatto : contatti) {

            if (contatto.getNumero().equals(numeroDaCercare)) {
                System.out.println("Ho trovato : \n " + contatto);
            }
        }

    }
    

    public void stampaSuFile(String nomeFile){
        /* Path path = Paths.get("rubrica.txt");
        try{
            FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(contatti);

            oos.close();

            
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        } */

        try{
            FileWriter fileWriter = new FileWriter(nomeFile, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Contatto contatto : contatti){
                writer.write(contatto.toString());
                writer.newLine();
                
            }
            writer.flush();
            writer.close();
            System.out.println("Dati stampati su file!");

        }catch(IOException e){
            System.out.println("ERRORE ERROERE ERRORE ERRORE ERRORE" + e.getMessage());

        }

    }

}
