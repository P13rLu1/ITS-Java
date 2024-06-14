package Banca;

public class Conto {
    private final String iban;
    private double saldo;

    public Conto(String iban) {
        this.iban = iban;
        this.saldo = 0;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        if (saldo < 0) {
            System.out.println("Saldo negativo");
            return 0;
        } else {
            return saldo;
        }
    }

    public void deposita(double importo) {
        saldo += importo;
    }

    public void preleva(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
        } else {
            System.out.println("Saldo insufficiente");
        }
    }
}
