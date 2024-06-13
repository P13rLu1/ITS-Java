package Calendario;

public class Calendario2024 {
    int NUMERO_MESI = 12;
    private final int[] giorniMesi = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final String[][] calendario = new String[12][31];
    private final String[] giorniSettimana = {"Lunedí", "Martedí", "Mercoledí", "Giovedí", "Venerdí", "Sabato", "Domenica"};
    private int giornoSettimana = 0;

    public void riempiCalendario() {
        for (int i = 0; i < NUMERO_MESI; i++) {
            for (int j = 0; j < giorniMesi[i]; j++) {
                calendario[i][j] = giorniSettimana[giornoSettimana];
                giornoSettimana++;
                if (giornoSettimana == 7) {
                    giornoSettimana = 0;
                }
            }
        }
    }

    public Calendario2024(){
        riempiCalendario();
    }

    public String getGiorno(int mese, int giorno) {
        return calendario[mese - 1][giorno - 1];
    }
}
