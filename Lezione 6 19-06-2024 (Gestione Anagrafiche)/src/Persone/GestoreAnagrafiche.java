package Persone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestoreAnagrafiche {
    private final List<Persona> anagrafiche;

    public GestoreAnagrafiche() {
        this.anagrafiche = new ArrayList<>();
    }

    public void insertAnagrafica(String nome, String cognome, String dataDiNascita, String numeroTelefono) {
        LocalDate dataNascita = convertiData(dataDiNascita);
        Persona nuovaAnagrafica = new Persona(nome, cognome, dataNascita, numeroTelefono);
        anagrafiche.add(nuovaAnagrafica);
    }

    public void updateAnagraficaById(int id, String nome, String cognome, String dataDiNascita, String numeroTelefono) {
        LocalDate dataNascita = convertiData(dataDiNascita);
        Persona anagraficaDaAggiornare = anagrafiche.get(id);
        if (anagraficaDaAggiornare != null) {
            anagraficaDaAggiornare.setNome(nome);
            anagraficaDaAggiornare.setCognome(cognome);
            anagraficaDaAggiornare.setDataDiNascita(dataNascita);
            anagraficaDaAggiornare.setNumeroTelefono(numeroTelefono);
        }
    }

    public void deleteAnagraficaById(int id) {
        anagrafiche.remove(id);
    }

    private LocalDate convertiData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    public void stampaAnagrafiche() {
        for (Persona anagrafica : anagrafiche) {
            System.out.println(anagrafica.toString());
        }
    }
}
