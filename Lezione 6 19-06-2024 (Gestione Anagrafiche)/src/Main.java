import Persone.GestoreAnagrafiche;

public class Main {
    public static void main(String[] args) {
        GestoreAnagrafiche gestore = new GestoreAnagrafiche();

        // Inserimento di un'anagrafica
        gestore.insertAnagrafica("Mario", "Rossi", "23/03/1983", "3331234567");

        // Stampa tutte le anagrafiche
        gestore.stampaAnagrafiche();

        // Esempio di aggiornamento di un'anagrafica (supponiamo di voler aggiornare la prima anagrafica)
        gestore.updateAnagraficaById(0, "Luigi", "Verdi", "12/05/1990", "3339876543");

        // Stampa tutte le anagrafiche dopo l'aggiornamento
        gestore.stampaAnagrafiche();

        // Esempio di eliminazione di un'anagrafica (eliminiamo la prima anagrafica)
        gestore.deleteAnagraficaById(0);

        // Stampa tutte le anagrafiche dopo l'eliminazione
        gestore.stampaAnagrafiche();
    }
}
