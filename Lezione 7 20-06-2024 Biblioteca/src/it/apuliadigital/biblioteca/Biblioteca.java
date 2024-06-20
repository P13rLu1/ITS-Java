package it.apuliadigital.biblioteca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;

//la classe biblioteca deve gestire:
// i libri presenti
// gli studenti / docenti che possono accedere al servizio prestito
// i prestiti dei libri effettuati
public class Biblioteca {
    private Map<String, Libro> libri;
    private Map<String, Utente> utenti;
    private List<Prestito> prestiti;

    // costruttore della biblioteca
    public Biblioteca() {
        this.libri = new HashMap<>();
        this.utenti = new HashMap<>();
        this.prestiti = new ArrayList<>();
    }

    // funzione per aggiungere una persona alla biblioteca (studente o docente)
    public void aggiungiPersona(String nome, String cognome, String numeroTelefono, String matricola, String tipo) {
        try {
            if (utenti.containsKey(matricola)) {
                throw new IllegalArgumentException("Utente già presente");
            }
            if (tipo.equalsIgnoreCase("studente")) {
                utenti.put(matricola, new Studente(nome, cognome, matricola, numeroTelefono));
            } else if (tipo.equalsIgnoreCase("docente")) {
                utenti.put(matricola, new Docente(nome, cognome, numeroTelefono, matricola));
            } else {
                System.out.println("Tipo non valido");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per rimuovere una persona dalla biblioteca
    public void rimuoviPersona(String matricola) {
        try {
            if (!utenti.containsKey(matricola)) {
                throw new IllegalArgumentException("Utente non presente");
            }
            utenti.remove(matricola);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per aggiungere un libro alla biblioteca
    public void aggiungiLibro(String titolo, String autore, String isbn, Stato stato) {
        try {
            if (libri.containsKey(isbn)) {
                throw new IllegalArgumentException("Libro già presente");
            }
            libri.put(isbn, new Libro(titolo, autore, isbn, stato));
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    //funzione per aggiungere piú libri alla biblioteca
    public void aggiungiLibri(List<Libro> libri) {
        for (Libro libro : libri) {
            aggiungiLibro(libro.getTitolo(), libro.getAutore(), libro.getISBN(), libro.getStato());
        }
    }

    // funzione per rimuovere un libro dalla biblioteca
    public void rimuoviLibro(String isbn) {
        try {
            if (!libri.containsKey(isbn)) {
                throw new IllegalArgumentException("Libro non presente");
            }
            libri.remove(isbn);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per verificare la presenza di un libro nella biblioteca
    public void verificaPresenzaLibro(String isbn) {
        try {
            if (libri.containsKey(isbn) && libri.get(isbn).getStato().equals(Stato.DISPONIBILE)) {
                System.out.println("Libro disponibile");
            } else if (libri.containsKey(isbn) && libri.get(isbn).getStato().equals(Stato.IN_PRESTITO)) {
                System.out.println("Libro in prestito");
            } else if (libri.containsKey(isbn) && libri.get(isbn).getStato().equals(Stato.PRENOTATO)) {
                System.out.println("Libro prenotato");
            } else {
                System.out.println("Libro non presente");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per richiedere un libro in prestito
    public void richiediLibro(String isbn, String matricola) {
        try {
            if (!utenti.containsKey(matricola)) {
                throw new IllegalArgumentException("Utente non presente");
            }

            for (Prestito prestito : prestiti) {
                if (prestito.getISBN().equals(isbn)) {
                    throw new IllegalArgumentException("Libro già in prestito");
                }
            }

            if (!libri.containsKey(isbn)) { //se il libro non é presente nella biblioteca viene salvato nei prestiti senza date
                if (utenti.get(matricola) instanceof Studente) {
                    prestiti.add(new Prestito(isbn, matricola));
                } else if (utenti.get(matricola) instanceof Docente) {
                    prestiti.add(new Prestito(isbn, matricola));
                }
                System.out.println("Libro non presente, salvato nei prestiti");
                return;
            }
            // se il libro é presente nella biblioteca viene salvato nei prestiti con le date di inizio e fine prestito in base al tipo di utente
            if (utenti.get(matricola) instanceof Studente) {
                prestiti.add(new Prestito(isbn, matricola, LocalDate.now(), LocalDate.now().plusDays(7)));
                libri.get(isbn).setStato(Stato.IN_PRESTITO);
            } else if (utenti.get(matricola) instanceof Docente) {
                prestiti.add(new Prestito(isbn, matricola, LocalDate.now(), LocalDate.now().plusDays(30)));
                libri.get(isbn).setStato(Stato.IN_PRESTITO);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per rimuovere un prestito
    public void rimuoviPrestito(String isbn) {
        try {
            prestiti.removeIf(prestito -> prestito.getISBN().equals(isbn));

            if (libri.containsKey(isbn)) {
                libri.get(isbn).setStato(Stato.DISPONIBILE);
            }
            System.out.println("Prestito rimosso");
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per verificare un prestito
    public void verificaPrestito(String isbn) {
        try {
            if (libri.get(isbn).getStato().equals(Stato.PRENOTATO)) {
                System.out.println("Libro prenotato non si sa quando sarà disponibile");
            } else if (libri.get(isbn).getStato().equals(Stato.IN_PRESTITO)) {
                System.out.println("Libro in prestito");
            } else if (libri.get(isbn).getStato().equals(Stato.DISPONIBILE)) {
                System.out.println("Libro disponibile");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // funzione per stampare su file txt i prestiti in ordine crescente sulla matricola
    public void reportPrestiti(String nomeFile) {
        try {
            FileWriter fileWriter = new FileWriter(nomeFile, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            Collections.sort(prestiti);
            for (Prestito prestito : prestiti) {
                writer.write(prestito.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
