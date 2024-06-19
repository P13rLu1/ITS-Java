package Banca;

import java.io.Serial;
import java.io.Serializable;

public abstract class ContoCorrente implements Serializable {
    // Attributi della classe Conto
    @Serial
    private static final long serialVersionUID = -8633618944934002837L;
    private String iban;
    private double saldo;

    // Costruttore della classe Conto
    public ContoCorrente(String iban) {
        this.iban = iban;
        this.saldo = 0;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Metodo per depositare denaro nel conto corrente
    public abstract void deposita(double importo);

    // Metodo per prelevare denaro dal conto corrente
    public abstract void preleva(double importo);
}
