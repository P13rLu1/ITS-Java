package Banca;

public class Conto {
    private final String iban;
    private double saldo;

    // Costruttore della classe Conto
    public Conto(String iban) {
        this.iban = iban;
        this.saldo = 0;
    }

    // Metodo che restituisce l'IBAN del conto corrente
    public String getIban() {
        return iban;
    }

    // Metodo che restituisce il saldo del conto corrente
    public double getSaldo() {
        if (saldo < 0) {
            System.out.println("Saldo negativo");
            return 0;
        } else {
            return saldo;
        }
    }

    // Metodo per depositare denaro nel conto corrente
    public void deposita(double importo) {
        saldo += importo;
    }

    // Metodo per prelevare denaro dal conto corrente
    public void preleva(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
        } else {
            System.out.println("Saldo insufficiente");
        }
    }
}
