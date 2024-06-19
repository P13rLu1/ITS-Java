package Persone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestoreAnagrafiche {
    // Struttura dati per memorizzare le anagrafiche
    private final List<Anagrafica> anagrafiche;

    // Costruttore
    public GestoreAnagrafiche() {
        this.anagrafiche = new ArrayList<>();
    }

    // Metodo per inserire una nuova anagrafica
    public void insertAnagrafica(String nome, String cognome, String dataDiNascita, String numeroTelefono) {
        LocalDate dataNascita = convertiData(dataDiNascita);
        Anagrafica nuovaAnagrafica = new Anagrafica(nome, cognome, dataNascita, numeroTelefono);
        anagrafiche.add(nuovaAnagrafica);
    }

    // Metodo per aggiornare un'anagrafica dato l'ID
    public void updateAnagraficaById(int id, String nome, String cognome, String dataDiNascita, String numeroTelefono) {
        LocalDate dataNascita = convertiData(dataDiNascita);
        Anagrafica anagraficaDaAggiornare = anagrafiche.get(id);
        if (anagraficaDaAggiornare != null) {
            anagraficaDaAggiornare.setNome(nome);
            anagraficaDaAggiornare.setCognome(cognome);
            anagraficaDaAggiornare.setDataDiNascita(dataNascita);
            anagraficaDaAggiornare.setNumeroTelefono(numeroTelefono);
        }
    }

    // Metodo per eliminare un'anagrafica dato l'ID
    public void deleteAnagraficaById(int id) {
        anagrafiche.remove(id);
    }

    // Metodo per formattare la data in entrata
    private LocalDate convertiData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    // Metodo per stampare le anagrafiche nel formato richiesto
    public void stampaAnagrafiche() {
        for (Anagrafica anagrafica : anagrafiche) {
            System.out.println(anagrafica.toString());
        }
    }

    // Classe interna per rappresentare un'entità Anagrafica
    private class Anagrafica {
        private String nome;
        private String cognome;
        private LocalDate dataDiNascita;
        private String numeroTelefono;

        // Costruttore di Anagrafica
        public Anagrafica(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono) {
            this.nome = nome;
            this.cognome = cognome;
            this.dataDiNascita = dataDiNascita;
            this.numeroTelefono = numeroTelefono;
        }

        // Override del metodo toString per stampare nel formato richiesto
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return "[" + nome + "|" + cognome + "|" + formatter.format(dataDiNascita) + "|" + numeroTelefono + "]";
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public void setDataDiNascita(LocalDate dataDiNascita) {
            this.dataDiNascita = dataDiNascita;
        }

        public void setNumeroTelefono(String numeroTelefono) {
            this.numeroTelefono = numeroTelefono;
        }
    }
}
