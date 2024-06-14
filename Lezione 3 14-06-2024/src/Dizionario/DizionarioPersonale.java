package Dizionario;

import java.util.HashMap;
import java.util.Map;

public class DizionarioPersonale {

    Map<String, String> dizionario = new HashMap<>();

    public DizionarioPersonale() {
        popolaDizionario();
    }

    public void popolaDizionario(){
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

    public void aggiungiParola(String parola, String significato){
        dizionario.put(parola, significato);
    }

    public String getSignificato(String parola){
        return dizionario.get(parola);
    }

    public Map<String, String> getDizionario(){
        return dizionario;
    }
}
