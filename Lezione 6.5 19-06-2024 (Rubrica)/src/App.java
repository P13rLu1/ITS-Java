import Rubrica.GestoreRubrica;

public class App {
    public static void main(String[] args) {
        
        GestoreRubrica rubrica = new GestoreRubrica();

        rubrica.aggiungiContatto("Piero", "Angela", "3203606953");

        rubrica.aggiungiContatto("Stempio", "Pelato", "3349835527");

        rubrica.stampa();

        String numeroPassato = "3349835527";

        rubrica.ricercaContatto(numeroPassato);

        rubrica.stampaSuFile("rubrica.txt");
    }
}
