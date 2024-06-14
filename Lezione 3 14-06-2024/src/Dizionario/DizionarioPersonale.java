package Dizionario;

import java.util.HashMap;
import java.util.Map;

public class DizionarioPersonale {

    Map<String, String> dizionario = new HashMap<>();

    public DizionarioPersonale() {
        popolaDizionario();
    }

    public void popolaDizionario() {
        dizionario.put("cane", "animale domestico");
        dizionario.put("gatto", "animale domestico");
        dizionario.put("cavallo", "animale da corsa");
        dizionario.put("elefante", "animale selvatico");
        dizionario.put("tigre", "animale selvatico");
        dizionario.put("pappagallo", "animale da compagnia");
        dizionario.put("scoiattolo", "animale selvatico");
        dizionario.put("formica", "insetto");
        dizionario.put("ragno", "insetto");
        dizionario.put("mosca", "insetto");
    }

    public Map<String, String> getDizionario() {
        return dizionario;
    }

    public void cercaParola(String parola){
        String significato = dizionario.get(parola);
        if(significato != null){
            System.out.println("Il significato di " + parola + " è: " + significato);
        } else {
            System.out.println("La parola " + parola + " non è presente nel dizionario.");
        }
    }

    public void aggiungiParola(String parola, String significato){
        dizionario.put(parola, significato);
        System.out.println("Parola aggiunta correttamente.");
    }

    public void aggiornaParola(String parola, String significato){
        if(dizionario.containsKey(parola)){
            dizionario.put(parola, significato);
            System.out.println("Parola aggiornata correttamente.");
        } else {
            System.out.println("La parola " + parola + " non è presente nel dizionario.");
        }
    }

    public void eliminaParola(String parola){
        if(dizionario.containsKey(parola)){
            dizionario.remove(parola);
            System.out.println("Parola eliminata correttamente.");
        } else {
            System.out.println("La parola " + parola + " non è presente nel dizionario.");
        }
    }
}
