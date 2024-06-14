package Calendario;

import java.util.ArrayList;
import java.util.List;

public class Calendario2024 {
    private final int anno;
    int NUMERO_MESI = 12;
    private final List<List<String>> calendario = new ArrayList<>();
    private final List<String> giorniSettimana = List.of("Lunedí", "Martedí", "Mercoledí", "Giovedí", "Venerdí", "Sabato", "Domenica");
    private int giornoSettimana = 0;

    public Calendario2024(int anno) {
        this.anno = anno;
        riempiCalendario();
    }

    private List<Integer> calcolaAnno() {
        List<Integer> giorniMesi = new ArrayList<>();
        giorniMesi.add(31);
        System.out.printf("Anno %d\n", anno);
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            giorniMesi.add(29);
        } else {
            giorniMesi.add(28);
        }
        giorniMesi.add(31);
        giorniMesi.add(30);
        giorniMesi.add(31);
        giorniMesi.add(30);
        giorniMesi.add(31);
        giorniMesi.add(31);
        giorniMesi.add(30);
        giorniMesi.add(31);
        giorniMesi.add(30);
        giorniMesi.add(31);
        return giorniMesi;
    }

    public void riempiCalendario() {
        List<Integer> giorniMesi = calcolaAnno();
        for (int i = 0; i < NUMERO_MESI; i++) {
            List<String> giorniDelMese = new ArrayList<>();
            for (int j = 0; j < giorniMesi.get(i); j++) {
                giorniDelMese.add(giorniSettimana.get(giornoSettimana));
                giornoSettimana++;
                if (giornoSettimana == giorniSettimana.size()) {
                    giornoSettimana = 0;
                }
            }
            calendario.add(giorniDelMese);
        }
    }

    public String getGiorno(int mese, int giorno) {
        return calendario.get(mese - 1).get(giorno - 1);
    }
}
